package com.nthportal.cryptopals
package challenges
package set1

object Challenge3 extends Challenge {

  override def apply(): ScoredChar = {
    val bytes = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736".hexToBytes

    (('a' to 'z') ++ ('A' to 'Z'))
      .iterator
      .map(c => ScoredChar(c, scoreBytes(bytes ^ c.toByte)))
      .maxBy(_.score)
  }

  private[set1] final case class ScoredChar(char: Char, score: Int)
}
