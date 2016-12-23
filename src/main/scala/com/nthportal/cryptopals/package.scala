package com.nthportal

import java.util.Base64
import javax.xml.bind.DatatypeConverter

package object cryptopals {

  implicit final class RichString(private val s: String) extends AnyVal {
    def hexToBytes: Array[Byte] = DatatypeConverter.parseHexBinary(s)

    def base64ToBytes: Array[Byte] = Base64.getDecoder.decode(s)
  }

  implicit final class RichByteArray(private val bytes: Array[Byte]) extends AnyVal {
    def toHexString: String = DatatypeConverter.printHexBinary(bytes)

    def toBase64String: String = Base64.getEncoder.encodeToString(bytes)
  }
}
