package com.nthportal

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

import org.apache.commons.codec.binary.Hex

package object cryptopals {

  implicit final class RichString(private val s: String) extends AnyVal {
    def hexToBytes: Array[Byte] = DatatypeConverter.parseHexBinary(s)

    def base64ToBytes: Array[Byte] = Base64.getDecoder.decode(s)

    def charsToBytes: Array[Byte] = s.map(_.toByte).toArray
  }

  implicit final class RichByte(private val b: Byte) extends AnyVal {
    def xor(that: Byte): Byte = (b ^ that).toByte
  }

  implicit final class RichByteArray(private val bytes: Array[Byte]) extends AnyVal {
    def toHexString: String = Hex.encodeHexString(bytes)

    def toBase64String: String = Base64.getEncoder.encodeToString(bytes)

    def toCharString: String = bytes.iterator.map(_.toChar).mkString

    def xor(that: Array[Byte]): Array[Byte] = byteArrayOp(that, _ xor _)

    def ^(that: Array[Byte]): Array[Byte] = xor(that)

    def xor(b: Byte): Array[Byte] = bytes.map(_ xor b)

    def ^(b: Byte): Array[Byte] = xor(b)

    private def byteArrayOp(that: Array[Byte], op: (Byte, Byte) => Byte): Array[Byte] = {
      require(bytes.length == that.length, "arrays must be the same size")
      bytes.iterator
        .zip(that.iterator)
        .map(op.tupled)
        .toArray
    }
  }

  /* Utilities */

  val AESBlockSize = 16
  val YellowSubmarineKey: Array[Byte] = "YELLOW SUBMARINE".charsToBytes

  def decryptECB(ciphertext: Array[Byte], key: Array[Byte], padding: Boolean = true): Array[Byte] = {
    val cipher = Cipher.getInstance("AES/ECB/" + paddingType(padding))
    val secretKey = new SecretKeySpec(key, "AES")
    cipher.init(Cipher.DECRYPT_MODE, secretKey)
    cipher.doFinal(ciphertext)
  }

  def encryptECB(plaintext: Array[Byte], key: Array[Byte], padding: Boolean = true): Array[Byte] = {
    val cipher = Cipher.getInstance("AES/ECB/" + paddingType(padding))
    val secretKey = new SecretKeySpec(key, "AES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    cipher.doFinal(plaintext)
  }

  private def paddingType(padding: Boolean): String = if (padding) "PKCS5Padding" else "NoPadding"

}
