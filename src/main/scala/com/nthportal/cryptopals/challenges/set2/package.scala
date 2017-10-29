package com.nthportal.cryptopals
package challenges

import java.util

package object set2 {
  def padPKCS7(blockSize: Int, bytes: Array[Byte]): Array[Byte] = {
    require(blockSize > 1 && blockSize <= 0xff, "Invalid block size")

    val padding = blockSize - (bytes.length % blockSize)
    val padded = Array.ofDim[Byte](bytes.length + padding)

    System.arraycopy(bytes, 0, padded, 0, bytes.length)
    util.Arrays.fill(padded, bytes.length, padded.length, padding.toByte)

    padded
  }

  def validPKCS7Padding(blockSize: Int, bytes: Array[Byte]): Boolean = {
    val padByte = bytes.last

    (padByte < bytes.length) &&
      (padByte <= blockSize) &&
      bytes.view(bytes.length - padByte, bytes.length)
        .forall(_ == padByte)
  }

  def unpadPKCS7(blockSize: Int, bytes: Array[Byte]): Array[Byte] = {
    require(validPKCS7Padding(blockSize, bytes), "Invalid padding")

    val padByte = bytes.last
    util.Arrays.copyOf(bytes, bytes.length - padByte)
  }

  def encryptCBC(plaintext: Array[Byte], key: Array[Byte], iv: Array[Byte]): Array[Byte] = {
    val padded = padPKCS7(AESBlockSize, plaintext)
    val ciphertext = Array.ofDim[Byte](padded.length)

    val blocks = padded.grouped(AESBlockSize)
    var prev = iv
    var i = 0
    while (blocks.hasNext) {
      val output = encryptECB(blocks.next() ^ prev, key, padding = false)
      prev = output

      System.arraycopy(output, 0, ciphertext, i * AESBlockSize, AESBlockSize)
      i += 1
    }

    ciphertext
  }

  def decryptCBC(ciphertext: Array[Byte], key: Array[Byte], iv: Array[Byte]): Array[Byte] = {
    val plaintext = Array.ofDim[Byte](ciphertext.length)

    val blocks = ciphertext.grouped(AESBlockSize)
    var prev = iv
    var i = 0
    while (blocks.hasNext) {
      val nextBlock = blocks.next()
      val output = decryptECB(nextBlock, key, padding = false) ^ prev
      prev = nextBlock

      System.arraycopy(output, 0, plaintext, i * AESBlockSize, AESBlockSize)
      i += 1
    }

    unpadPKCS7(AESBlockSize, plaintext)
  }
}
