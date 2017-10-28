package com.nthportal.cryptopals.challenges

package object set1 {
  private val printableChars = ' ' to '~'
  private val whitespaceChars = Set('\n', '\r', '\t')

  private[set1] def scoreBytes(bytes: Array[Byte]): Int = {
    val chars = bytes.map(_.toChar)
    if (!chars.forall(isPrintable)) -1
    else scoreChars(chars)
  }

  private def isPrintable(c: Char): Boolean = (printableChars contains c) || (whitespaceChars contains c)

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
