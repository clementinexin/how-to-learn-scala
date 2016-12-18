package demo.akka

import akka.actor.{Actor, ActorSystem, Kill, Props}

/**
  * Created by daijiajia on 2016/12/18.
  */
class KillDemoActor extends Actor {


  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    println("I am alive")
  }

  @scala.throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    println("I am killed")
  }

  @scala.throws[Exception](classOf[Exception])
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(" :: preRestart")
  }

  @scala.throws[Exception](classOf[Exception])
  override def postRestart(reason: Throwable): Unit = {
    println(" :: postRestart")
  }

  override def receive: Receive = {
    case _ => println("I got a message")
  }

}

object KillTest extends App {
  val system = ActorSystem("KillTestSystem")
  val I = system.actorOf(Props[KillDemoActor], name = "Number5")
  I ! "hello"
  I ! Kill
  system.terminate()
}
