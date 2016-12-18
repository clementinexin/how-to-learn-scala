package demo

import org.scalatest.FunSuite

/**
  * Created by daijiajia on 2016/12/18.
  */
class HelloTest extends FunSuite {

  test("testSayHello") {
    var hello = new Hello
    assert(hello.sayHello("Scala") == "Hello,Scala")
  }

}
