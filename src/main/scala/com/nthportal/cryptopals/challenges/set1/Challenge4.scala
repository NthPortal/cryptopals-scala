package com.nthportal.cryptopals
package challenges
package set1

object Challenge4 extends Challenge {
  override def apply(): ScoredString = {
    val keyRange = (0x00 to 0xff).map(_.toByte)

    Challenge4Helper.strings
      .iterator
      .flatMap(s =>
        findByteKey(s.hexToBytes, keyRange)
          .map(sc => ScoredString(s, sc.byte, sc.score))
      )
      .maxBy(_.score)
  }
}
