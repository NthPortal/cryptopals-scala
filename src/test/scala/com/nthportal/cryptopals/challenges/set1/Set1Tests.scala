package com.nthportal.cryptopals.challenges
package set1

class Set1Tests extends SimpleSpec {
  "Challenge 1" should "convert hex to base64" in {
    Challenge1() shouldBe "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"
  }

  "Challenge 2" should "xor bytes" in {
    Challenge2() shouldBe "746865206b696420646f6e277420706c6179"
  }

  "Challenge 3" should "find the key" in {
    val res = Challenge3()
    res.key.toChar shouldBe 'X'
    res.decodedString shouldBe "Cooking MC's like a pound of bacon"
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

  "Challenge 6" should "compute Hamming Distance correctly" in {
    hammingDistance("this is a test", "wokka wokka!!!") shouldBe 37
  }

  it should "decrypt a repeating-key XOR'd string" in {
    val res = Challenge6()
    res._1 shouldBe "Terminator X: Bring the noise"
    res._2 shouldBe CipherStrings.plaintext1
  }

  "Challenge 7" should "decrypt AES-encrypted text in ECB mode" in {
    Challenge7() shouldBe CipherStrings.plaintext1
  }

  "Challenge 8" should "detect the correct AES-ECB encrypted string" in {
    Challenge8() shouldBe "d880619740a8a19b7840a8a31c810a3d08649af70dc06f4fd5d2d69c744cd283e2dd052f6b641dbf9d11b0348542bb5708649af70dc06f4fd5d2d69c744cd2839475c9dfdbc1d46597949d9c7e82bf5a08649af70dc06f4fd5d2d69c744cd28397a93eab8d6aecd566489154789a6b0308649af70dc06f4fd5d2d69c744cd283d403180c98c8f6db1f2a3f9c4040deb0ab51b29933f2c123c58386b06fba186a"
  }
}
