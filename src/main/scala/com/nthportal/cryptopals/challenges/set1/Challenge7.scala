package com.nthportal.cryptopals
package challenges
package set1

object Challenge7 extends Challenge {
  override def apply(): String = {
    val bytes = Challenge7Helper.base64String.base64ToBytes
    val key = YellowSubmarineKey

    decryptECB(bytes, key).toCharString
  }
}
