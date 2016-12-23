package com.nthportal.cryptopals
package challenges
package set1

object Challenge2 extends Challenge {
  override def apply(): String = {
    ("1c0111001f010100061a024b53535009181c".hexToBytes ^ "686974207468652062756c6c277320657965".hexToBytes)
      .toHexString
  }
}
