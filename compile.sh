cd  ~/git/scalajs-hubot

sbt fastOptJS
cp -f target/scala-2.11/*.js myhubot/scripts/

cd myhubot
bin/hubot

