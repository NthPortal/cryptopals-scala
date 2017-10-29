package com.nthportal.cryptopals.challenges

trait Challenge extends (() => Any) {
  def apply(): Any
}
