package com.github.newta.scalajs.hubot

import scala.scalajs.js

/**
  * Created by shinden on 2016/01/21.
  */
@js.native
class Envelope(
                val room:String,
                val user:User,
                val message:js.Object
              ) extends js.Object


@js.native
class User(
  val id:js.Object,
  val name:String,
  val room:String
) extends js.Object