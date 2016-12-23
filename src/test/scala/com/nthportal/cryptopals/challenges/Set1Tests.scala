package com.nthportal.cryptopals.challenges

import com.nthportal.cryptopals.challenges.set1._
import org.scalatest.{FlatSpec, Matchers}

class Set1Tests extends FlatSpec with Matchers {
  "Challenge 1" should "convert hex to base64" in {
    Challenge1() should be ("SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t")
  }

  "Challenge 2" should "xor bytes" in {
    Challenge2() should be ("746865206b696420646f6e277420706c6179")
  }

  "Challenge 3" should "find the key" in {
    Challenge3() should be ('X')
  }
}
