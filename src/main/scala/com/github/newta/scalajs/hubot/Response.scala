package com.github.newta.scalajs.hubot

import scala.collection.mutable
import scala.scalajs.js

/**
  * Created by shinden on 2016/01/18.
  */
@js.native
trait Response  extends js.Object {

  val envelope:Envelope
  val `match`:js.Array[String] = js.native

  def send(message:String):js.Dynamic = js.native

  def reply(message:String):js.Dynamic = js.native

  def finish():js.Dynamic = js.native

}

