package com.nthportal.cryptopals.challenges
package set2

class Set2Tests extends SimpleSpec {
  "Challenge 9" should "pad correctly" in {
    padPKCS7(8, Array(0, 1, 2, 3)) shouldBe Array(0, 1, 2, 3, 4, 4, 4, 4)
  }

}
