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
    res._2 shouldBe Set1Tests.plaintext1
  }

  "Challenge 7" should "decrypt AES-encrypted text in ECB mode" in {
    Challenge7() shouldBe Set1Tests.plaintext1
  }

  "Challenge 8" should "detect the correct AES-ECB encrypted string" in {
    Challenge8() shouldBe "d880619740a8a19b7840a8a31c810a3d08649af70dc06f4fd5d2d69c744cd283e2dd052f6b641dbf9d11b0348542bb5708649af70dc06f4fd5d2d69c744cd2839475c9dfdbc1d46597949d9c7e82bf5a08649af70dc06f4fd5d2d69c744cd28397a93eab8d6aecd566489154789a6b0308649af70dc06f4fd5d2d69c744cd283d403180c98c8f6db1f2a3f9c4040deb0ab51b29933f2c123c58386b06fba186a"
  }
}

object Set1Tests {
  private val plaintext1 = {
    "I'm back and I'm ringin' the bell \n" +
      "A rockin' on the mike while the fly girls yell \n" +
      "In ecstasy in the back of me \n" +
      "Well that's my DJ Deshay cuttin' all them Z's \n" +
      "Hittin' hard and the girlies goin' crazy \n" +
      "Vanilla's on the mike, man I'm not lazy. \n" +
      "\n" +
      "I'm lettin' my drug kick in \n" +
      "It controls my mouth and I begin \n" +
      "To just let it flow, let my concepts go \n" +
      "My posse's to the side yellin', Go Vanilla Go! \n" +
      "\n" +
      "Smooth 'cause that's the way I will be \n" +
      "And if you don't give a damn, then \n" +
      "Why you starin' at me \n" +
      "So get off 'cause I control the stage \n" +
      "There's no dissin' allowed \n" +
      "I'm in my own phase \n" +
      "The girlies sa y they love me and that is ok \n" +
      "And I can dance better than any kid n' play \n" +
      "\n" +
      "Stage 2 -- Yea the one ya' wanna listen to \n" +
      "It's off my head so let the beat play through \n" +
      "So I can funk it up and make it sound good \n" +
      "1-2-3 Yo -- Knock on some wood \n" +
      "For good luck, I like my rhymes atrocious \n" +
      "Supercalafragilisticexpialidocious \n" +
      "I'm an effect and that you can bet \n" +
      "I can take a fly girl and make her wet. \n" +
      "\n" +
      "I'm like Samson -- Samson to Delilah \n" +
      "There's no denyin', You can try to hang \n" +
      "But you'll keep tryin' to get my style \n" +
      "Over and over, practice makes perfect \n" +
      "But not if you're a loafer. \n" +
      "\n" +
      "You'll get nowhere, no place, no time, no girls \n" +
      "Soon -- Oh my God, homebody, you probably eat \n" +
      "Spaghetti with a spoon! Come on and say it! \n" +
      "\n" +
      "VIP. Vanilla Ice yep, yep, I'm comin' hard like a rhino \n" +
      "Intoxicating so you stagger like a wino \n" +
      "So punks stop trying and girl stop cryin' \n" +
      "Vanilla Ice is sellin' and you people are buyin' \n" +
      "'Cause why the freaks are jockin' like Crazy Glue \n" +
      "Movin' and groovin' trying to sing along \n" +
      "All through the ghetto groovin' this here song \n" +
      "Now you're amazed by the VIP posse. \n" +
      "\n" +
      "Steppin' so hard like a German Nazi \n" +
      "Startled by the bases hittin' ground \n" +
      "There's no trippin' on mine, I'm just gettin' down \n" +
      "Sparkamatic, I'm hangin' tight like a fanatic \n" +
      "You trapped me once and I thought that \n" +
      "You might have it \n" +
      "So step down and lend me your ear \n" +
      "'89 in my time! You, '90 is my year. \n" +
      "\n" +
      "You're weakenin' fast, YO! and I can tell it \n" +
      "Your body's gettin' hot, so, so I can smell it \n" +
      "So don't be mad and don't be sad \n" +
      "'Cause the lyrics belong to ICE, You can call me Dad \n" +
      "You're pitchin' a fit, so step back and endure \n" +
      "Let the witch doctor, Ice, do the dance to cure \n" +
      "So come up close and don't be square \n" +
      "You wanna battle me -- Anytime, anywhere \n" +
      "\n" +
      "You thought that I was weak, Boy, you're dead wrong \n" +
      "So come on, everybody and sing this song \n" +
      "\n" +
      "Say -- Play that funky music Say, go white boy, go white boy go \n" +
      "play that funky music Go white boy, go white boy, go \n" +
      "Lay down and boogie and play that funky music till you die. \n" +
      "\n" +
      "Play that funky music Come on, Come on, let me hear \n" +
      "Play that funky music white boy you say it, say it \n" +
      "Play that funky music A little louder now \n" +
      "Play that funky music, white boy Come on, Come on, Come on \n" +
      "Play that funky music \n"
  }
}
