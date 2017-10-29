package com.nthportal.cryptopals
package challenges
package set2

class Set2Tests extends SimpleSpec {
  "Challenge 9" should "pad and unpad correctly" in {
    padPKCS7(8, Array(0, 1, 2, 3)) shouldBe Array(0, 1, 2, 3, 4, 4, 4, 4)
    padPKCS7(4, Array(0, 1, 2, 3)) shouldBe Array(0, 1, 2, 3, 4, 4, 4, 4)
  }

  it should "unpad correctly" in {
    unpadPKCS7(8, Array(0, 1, 2, 3, 4, 4, 4, 4)) shouldBe Array(0, 1, 2, 3)
    unpadPKCS7(4, Array(0, 1, 2, 3, 4, 4, 4, 4)) shouldBe Array(0, 1, 2, 3)
  }

  "Challenge 10" should "decrypt AES CBC correctly" in {
    Challenge10() shouldBe CipherStrings.plaintext1
  }

  it should "encrypt AES CBC correctly" in {
    val iv = Array.ofDim[Byte](AESBlockSize)
    val key = YellowSubmarineKey

    val plaintext = CipherStrings.plaintext1.charsToBytes
    encryptCBC(plaintext, key, iv) shouldBe Challenge10Helper.base64String.base64ToBytes
  }

}
