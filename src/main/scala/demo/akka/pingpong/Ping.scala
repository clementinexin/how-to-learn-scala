package demo.akka.pingpong

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case object StartMessage

case object PingMessage

case object PongMessage

case object StopMessage

/**
  * Created by daijiajia on 2016/12/18.
  */
class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incrementAndPrint: Unit = {
    count += 1;
    println(s"$count:ping");
  }

  override def receive: Receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PongMessage
    case PingMessage =>
      incrementAndPrint
      if (count > 10) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      }
      else
        sender ! PongMessage

    case _ => println("Ping got unexpected information")
  }
}

class Pong extends Actor {
  var count = 0

  override def receive: Receive = {
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
    case PongMessage =>
      count += 1
      println(s"$count:pong")
      sender ! PingMessage

    case _ => println("Pong got unexpected information")
  }
}

object PingPongTest extends App {
  val system = ActorSystem("PingPongTest")
  val pongActor = system.actorOf(Props[Pong], name = "PongActor")
  val pingActor = system.actorOf(Props(new Ping(pongActor)), name = "PingActor")

  pingActor ! StartMessage
}
