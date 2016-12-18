package demo.akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by daijiajia on 2016/12/18.
  */
class HelloActor extends Actor {
  override def receive: Receive = {
    case "hello" => println("hello back to you.")
    case _ => println("huh?")
  }
}

object Test1_HelloActor extends App {

  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloActor")

  helloActor ! "hello"

  helloActor ! "what"

  system.terminate()
}
