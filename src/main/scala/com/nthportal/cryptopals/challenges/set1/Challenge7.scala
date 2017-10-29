package com.nthportal.cryptopals
package challenges
package set1

import javax.crypto._
import javax.crypto.spec.SecretKeySpec

object Challenge7 extends Challenge {
  override def apply(): String = {
    val bytes = Challenge7Helper.base64String.base64ToBytes

    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val key = new SecretKeySpec("YELLOW SUBMARINE".charsToBytes, "AES")
    cipher.init(Cipher.DECRYPT_MODE, key)

    cipher.doFinal(bytes).toCharString
  }
}
