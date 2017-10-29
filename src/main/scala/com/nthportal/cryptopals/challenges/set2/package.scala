package com.nthportal.cryptopals.challenges

import java.util

package object set2 {
  private[set2] def padPKCS7(blockSize: Int, bytes: Array[Byte]): Array[Byte] = {
    require(blockSize > 1 && blockSize <= 0xff, "Invalid block size")
    val lastBlockContentsLen = bytes.length % blockSize
    if (lastBlockContentsLen == 0) bytes
    else {
      val res = Array.ofDim[Byte]((bytes.length / blockSize + 1) * blockSize)
      val padding = (blockSize - lastBlockContentsLen).toByte

      System.arraycopy(bytes, 0, res, 0, bytes.length)
      util.Arrays.fill(res, bytes.length, res.length, padding)

      res
    }
  }
}
