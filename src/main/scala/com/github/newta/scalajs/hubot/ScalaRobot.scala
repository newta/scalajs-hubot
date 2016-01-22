package com.github.newta.scalajs.hubot

import com.github.newta.scalajs.hubot.warp.exec.CommandExecutor

import scala.scalajs.js
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scala.util.Random
import scala.util.matching.Regex
import scala.scalajs.js.DynamicImplicits._


/**
  * Created by shinden on 2015/12/09.
  */

object ScalaRobot extends JSApp {

  implicit class StringList(list:List[String]) {
    def random = new Random().shuffle(list).headOption
  }

  @JSExport
  def execute(robot:Robot): js.Any = {

    robot.respond(js.RegExp("aaa$"), js.Dictionary.empty,
      (res:Response) => {
        println("res1:::::::" + res.envelope.room)
        println("res2:::::::" + res.envelope.user)
        println("res3:::::::" + res.envelope.message)

        println("id:" + res.envelope.user.id)
        println("name:" + res.envelope.user.name)
        println("room:" + res.envelope.user.room)

//        println("id:::")
//        js.Object.getOwnPropertyNames(res.envelope.user.id).foreach(println)
//        println("room:::")
//        js.Object.getOwnPropertyNames(res.envelope.user.room).foreach(println)
//        println("name:::")
//        js.Object.getOwnPropertyNames(res.envelope.user.name).foreach(println)

        res.send("hoge334")
      }
    )


    robot.respond(js.RegExp("bbb$"), js.Dictionary.empty,
      (res:Response) => {
        res.reply("hoge555")
      }
    )



    robot.hear(js.RegExp("疲れた"), js.Dictionary.empty,
      (res:Response) => {
        List("お疲れ！", "頑張れ！").random.foreach(res.reply)
        res.finish()
      }
    )


    robot.hear(js.RegExp("exec (.*)"), js.Dictionary.empty,
      (res:Response) => {

        println(res.`match`)

//        val x = js.Object.getOwnPropertyNames(res.`match`)
//        x.foreach(println)
        val x2 = res.`match`
        val command = x2(1)

        println(command)

        CommandExecutor(command) {
          (error:js.Dynamic, stdout:String, stderr:String) => {

            if(error) res.reply(stderr)
            else res.reply(stdout)

          }
        }.run
      }
    )

  }

  def main(): Unit = {
    println("startup scala hubot.")
  }
}