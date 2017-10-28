package com.nthportal.cryptopals
package challenges

package object set1 {
  private val printableChars = ' ' to '~'
  private val whitespaceChars = Set('\n', '\r', '\t')

  private[set1] def findByteKey(hexString: String, possibleKeys: Seq[Byte]): Option[ScoredString] = {
    findByteKey(hexString.hexToBytes, possibleKeys)
      .map(sb => ScoredString(hexString, sb.byte, sb.score))
  }


  private[set1] def findByteKey(bytes: Array[Byte], possibleKeys: Seq[Byte]): Option[ScoredByte] = {
    possibleKeys
      .iterator
      .map(byte => ScoredByte(byte, scoreBytes(bytes ^ byte)))
      .filter(_.score > 0)
      .reduceOption((a, b) => if (a.score >= b.score) a else b)
  }

  private def scoreBytes(bytes: Array[Byte]): Int = {
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

  private[set1] final case class ScoredByte(byte: Byte, score: Int)

  private[set1] final case class ScoredString(hexString: String, key: Byte, score: Int) {
    def decodedString: String = (hexString.hexToBytes ^ key).map(_.toChar).mkString
  }
}
