package com.nthportal.cryptopals.challenges

package object set1 {
  private[set1] val printableChars = ' ' to '~'

  private[set1] def scoreBytes(bytes: Array[Byte]): Int = {
    val chars = bytes.map(_.toChar)
    scoreChars(chars)
  }

  private def scoreChars(chars: Array[Char]): Int = {
    chars.iterator
      .map({
        case c if c.isLower => 3
        case c if c.isUpper => 2
        case ' ' => 2
        case c if c.isDigit => 1
        case '.' | ',' | '\'' | '"' | '?' => 0
        case _ => -1
      })
      .sum
  }
}
