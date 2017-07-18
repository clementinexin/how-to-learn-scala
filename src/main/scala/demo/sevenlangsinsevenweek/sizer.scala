package demo.sevenlangsinsevenweek

import akka.actor.Actor._

import scala.io._
/**
  * Created by dj on 2017/6/1.
  */
class sizer {

  object PageLoader {
    def getPageSize(url:String) = Source.fromURL(url).mkString.size
  }

  var urls = List("http://amazon.com","http://google.com","http://twitter.com","http://cnn.com")

  def time(method : ()=> Unit): Unit = {
    val start = System.currentTimeMillis()
    method()
    val end = System.currentTimeMillis()
    println("Method cost " + (end-start)/1000 + " seconds")
  }

  def getPageSizeSequentially(): Unit = {
    for (url <- urls) {
      println("Size for " + url +":" +PageLoader.getPageSize(url))
    }
  }

  def getPageSizeConcurrent(): Unit = {
    for (url <- urls) {
      //actor {self ! (url,PageLoader.getPageSize(url))}
    }

    for (i <- 1 to urls.size) {
      //receive {
      //  case (url,size) => println("Size for " + url + ":"+size)
      //}
    }
  }

  time(getPageSizeSequentially)
  time(getPageSizeConcurrent)
}



