package demo.akka

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.gracefulStop

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

case object StopDemoActorStop

/**
  * Created by daijiajia on 2016/12/18.
  */
class StopDemoActor extends Actor {


  @scala.throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    println("StopDemoActor: postStop")
  }

  override def receive: Receive = {
    case StopDemoActorStop =>
      context.stop(self)
    case _ => println("StopDemoActor got message")
  }
}

object GracefulStopTest extends App {
  val system = ActorSystem("GracefulStopTest")
  val testActor = system.actorOf(Props[StopDemoActor], name = "test")
  try {
    val stopped: Future[Boolean] = gracefulStop(testActor, 2 seconds, StopDemoActorStop)
    Await.result(stopped, 3 seconds)
    println(s"testActor was stopped ? $stopped")
  } catch {
    case e: akka.pattern.AskTimeoutException => e.printStackTrace
  } finally {
    system.terminate()
  }
}
