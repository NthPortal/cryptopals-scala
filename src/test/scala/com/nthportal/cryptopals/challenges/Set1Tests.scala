package com.nthportal.cryptopals.challenges

import com.nthportal.cryptopals.challenges.set1._
import org.scalatest.{FlatSpec, Matchers}

class Set1Tests extends FlatSpec with Matchers {
  "Challenge 1" should "convert hex to base64" in {
    Challenge1() should be ("SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t")
  }
}
