package demo.akka

import akka.actor.{Actor, ActorSystem, PoisonPill, Props}

case class CreateChild(name: String)

case class Name(name: String)

/**
  * Created by daijiajia on 2016/12/18.
  */
class Child extends Actor {
  var name = "No name"

  @scala.throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    println(s"D'oh! They killed me ($name): ${self.path}")
  }

  override def receive: Receive = {
    case Name(name) => this.name = name
    case _ => println(s"Child $name got message")
  }
}

class Parent extends Actor {
  override def receive: Receive = {
    case CreateChild(name) =>
      println(s"Parent about to create child ($name) ...")
      val child = context.actorOf(Props[Child], name = s"$name")
      child ! Name(name)
    case _ => println(s"Parent got some other message.")
  }
}

object Demo extends App {
  val actorSystem = ActorSystem("ParentChildTest")
  val parent = actorSystem.actorOf(Props[Parent], name = "Parent")

  parent ! CreateChild("xiaoming")
  parent ! CreateChild("xiaohong")
  Thread.sleep(1000)

  println("Sending XiaoMing a PoisonPill ... ")
  val xiaoming = actorSystem.actorSelection("user/Parent/xiaoming")
  xiaoming ! PoisonPill
  println("XiaoMing was killed")

  Thread.sleep(1000)
  actorSystem.terminate()
}
