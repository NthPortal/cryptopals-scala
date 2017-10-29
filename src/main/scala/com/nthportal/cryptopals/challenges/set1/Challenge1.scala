package com.nthportal.cryptopals
package challenges
package set1

object Challenge1 extends Challenge {
  override def apply(): String = {
    "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
      .hexToBytes
      .toBase64String
  }
}
