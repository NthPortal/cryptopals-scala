package com.nthportal.cryptopals
package challenges
package set1

object Challenge6 extends Challenge {
  private val keyRange = printableChars.map(_.toByte)

  override def apply(): (String, String) = {
    val bytes = Challenge6Helper.base64String.base64ToBytes

    val keyLengths = (2 to 40).iterator
      .map(len => (len, normalizedHammingDistance(bytes, len)))
      .toSeq
      .sortBy(_._2) // possibly reverse ordering
      .map(_._1)

    val keys = for {
      keyLen <- keyLengths.iterator
      key <- tryFindKey(bytes, keyLen)
    } yield key

    // Try first key
    val key = keys.next()
    (key, repeatingKeyXor(bytes, key).map(_.toChar).mkString)
  }

  private def normalizedHammingDistance(bytes: Array[Byte], keyLength: Int): Double = {
    val iter = bytes.view.sliding(keyLength)

    val d1 = hammingDistance(iter.next(), iter.next()).toDouble / keyLength
    val d2 = hammingDistance(iter.next(), iter.next()).toDouble / keyLength
    (d1 + d2) / 2
  }

  private def tryFindKey(bytes: Array[Byte], keyLen: Int): Option[String] = {
    val matrix = {
      val res = bytes
        .grouped(keyLen)
        .toArray
      if (res.last.length == keyLen) res
      else res.init
    }.transpose

    val keyOptions = for (row <- matrix) yield findByteKey(row, keyRange)

    if (!keyOptions.forall(_.isDefined)) None
    else Some(keyOptions.map(_.get.byte.toChar).mkString)
  }
}
