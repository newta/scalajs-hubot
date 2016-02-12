package com.github.newta.scalajs.hubot.warp.exec

import scala.scalajs.js

/**
  * Created by shinden on 2016/01/21.
  */
case class CommandExecutor(command:String)(f:(js.Dynamic, String, String) => js.Dynamic) {

  var executor = scala.scalajs.js.Dynamic.global.require("child_process").exec

  def run():js.Dynamic = executor(command, f)


}
