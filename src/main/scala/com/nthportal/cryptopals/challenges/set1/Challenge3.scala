package com.nthportal.cryptopals
package challenges
package set1

object Challenge3 extends Challenge {
  private val printableChars = ' ' to '~'

  override def apply(): Char = {
    val bytes = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736".hexToBytes

    (('a' to 'z') ++ ('A' to 'Z'))
      .iterator
      .map(c => (c, bytes ^ c.toByte))
      .maxBy(t => scoreBytes(t._2))
      ._1
  }

  private def scoreBytes(bytes: Array[Byte]): Int = {
    val chars = bytes.map(_.toChar)
    if (!chars.forall(printableChars.contains)) -1
    else scoreChars(chars)
  }

  private def scoreChars(chars: Array[Char]): Int = {
    chars.iterator
      .map({
        case c if c.isLower => 3
        case c if c.isUpper => 2
        case ' ' => 2
        case _ => 0
      })
      .sum
  }
}
