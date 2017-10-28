package com.nthportal.cryptopals.challenges.set1

import org.scalatest.{FlatSpec, Matchers}

class Set1Tests extends FlatSpec with Matchers {
  "Challenge 1" should "convert hex to base64" in {
    Challenge1() shouldBe "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
  }

  "Challenge 2" should "xor bytes" in {
    Challenge2() shouldBe "746865206b696420646f6e277420706c6179"
  }

  "Challenge 3" should "find the key" in {
    Challenge3().char shouldBe 'X'
  }

  "Challenge 4" should "find the correct string" in {
    val res = Challenge4()
    res.hexString shouldBe "7b5a4215415d544115415d5015455447414c155c46155f4058455c5b523f"
    res.decodedString shouldBe "Now that the party is jumping\n"
  }

  "Challenge 5" should "encrypt using repeating-key XOR" in {
    Challenge5() shouldBe "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272" +
      "a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"
  }
}
