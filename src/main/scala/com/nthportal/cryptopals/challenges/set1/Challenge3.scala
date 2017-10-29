package com.nthportal.cryptopals
package challenges
package set1

object Challenge3 extends Challenge {

  override def apply(): ScoredString = {
    val keyRange = (('a' to 'z') ++ ('A' to 'Z')).map(_.toByte)
    val bytes = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"

    findByteKey(bytes, keyRange).get
  }
}
