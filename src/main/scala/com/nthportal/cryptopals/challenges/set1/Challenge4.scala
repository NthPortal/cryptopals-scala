package com.nthportal.cryptopals
package challenges
package set1

object Challenge4 extends Challenge {
  override def apply(): ScoredString = {
    Challenge4Helper.strings
      .iterator
      .flatMap(s =>
        findCharKey(s.hexToBytes)
          .map(sc => ScoredString(s, sc.byte, sc.score))
      )
      .maxBy(_.score)
  }

  private def findCharKey(bytes: Array[Byte]): Option[ScoredByte] = {
    (0x00 to 0xff)
      .iterator
      .map(_.toByte)
      .map(byte => ScoredByte(byte, scoreBytes(bytes ^ byte)))
      .filter(_.score > 0)
      .reduceOption((a, b) => if (a.score >= b.score) a else b)
  }

  private final case class ScoredByte(byte: Byte, score: Int)

  private[set1] final case class ScoredString(hexString: String, key: Byte, score: Int) {
    def decodedString: String = (hexString.hexToBytes ^ key).map(_.toChar).mkString
  }

}
