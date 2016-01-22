package com.github.newta.scalajs.hubot

import scala.scalajs.js


/**
  * Created by shinden on 2016/01/20.
  */
@js.native
trait Robot extends js.Object {

  def respond(matcher:js.Any, options:js.Dictionary[js.Any], callback:js.Function1[Response, js.Dynamic]): js.Dynamic = js.native
  def hear(matcher:js.Any, options:js.Dictionary[js.Any], callback:js.Function1[Response, js.Dynamic]): js.Dynamic = js.native
}
