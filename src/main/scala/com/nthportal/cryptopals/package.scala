package com.nthportal

import java.util.Base64
import javax.xml.bind.DatatypeConverter

import org.apache.commons.codec.binary.Hex

package object cryptopals {

  implicit final class RichString(private val s: String) extends AnyVal {
    def hexToBytes: Array[Byte] = DatatypeConverter.parseHexBinary(s)

    def base64ToBytes: Array[Byte] = Base64.getDecoder.decode(s)
  }

  implicit final class RichByte(private val b: Byte) extends AnyVal {
    def xor(that: Byte): Byte = (b ^ that).toByte
  }

  implicit final class RichByteArray(private val bytes: Array[Byte]) extends AnyVal {
    def toHexString: String = Hex.encodeHexString(bytes)

    def toBase64String: String = Base64.getEncoder.encodeToString(bytes)

    def xor(that: Array[Byte]): Array[Byte] = byteArrayOp(that, _ xor _)

    def ^(that: Array[Byte]): Array[Byte] = xor(that)

    def xor(b: Byte): Array[Byte] = bytes.map(_ xor b)

    def ^(b: Byte): Array[Byte] = xor(b)

    private def byteArrayOp(that: Array[Byte], op: (Byte, Byte) => Byte): Array[Byte] = {
      require(bytes.length == that.length, "arrays must be the same size")
      bytes.toStream
        .zip(that)
        .map(op.tupled)
        .toArray
    }
  }
}
