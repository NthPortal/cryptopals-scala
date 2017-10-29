package com.nthportal.cryptopals
package challenges
package set1

import scala.collection.mutable

object Challenge8 extends Challenge {
  override def apply(): String = {
    Challenge8Helper.strings
      .iterator
      .map(s => (
        s,
        s.hexToBytes
          .grouped(16)
          .map(new mutable.WrappedArray.ofByte(_))
          .toSet)
      )
      .minBy(_._2.size)
      ._1
  }
}
