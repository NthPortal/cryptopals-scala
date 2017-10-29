package com.nthportal.cryptopals
package challenges
package set1

object Challenge5 extends Challenge {
  override def apply(): String = {
    val plaintext = "Burning 'em, if you ain't quick and nimble\nI go crazy when I hear a cymbal"
    val key = "ICE"
    repeatingKeyXor(plaintext, key).toHexString
  }
}
