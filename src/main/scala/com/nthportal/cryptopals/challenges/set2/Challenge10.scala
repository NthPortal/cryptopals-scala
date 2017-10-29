package com.nthportal.cryptopals
package challenges
package set2

object Challenge10 extends Challenge {
  override def apply(): String = {
    val iv = Array.ofDim[Byte](AESBlockSize)
    val key = YellowSubmarineKey
    val ciphertext = Challenge10Helper.base64String.base64ToBytes

    decryptCBC(ciphertext, key, iv).toCharString
  }
}
