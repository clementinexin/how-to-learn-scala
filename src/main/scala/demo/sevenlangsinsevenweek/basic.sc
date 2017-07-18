"abc" + 4
"40.0"+1

def whileloop: Unit = {
  var i=0
  while (i<3){
    println(i)
    i+=1
  }
}

whileloop

val list = List(1, 2, 3)



List("one","two",3)

List("one","two",3)(2)

//List("one","two",3)(4)


Nil

//List("one","two",3)(-1)


val numbers = Set("1","2","3")
numbers + "4"

numbers - "4"

numbers ++ Set("3","4")
numbers -- Set("3")
numbers & Set("3")

Set(1,2,3) == Set(3,1,2)

val oridinals = Map(1 -> "one",2 -> "two")
oridinals(1)


//numbers + Set("4")

import scala.collection.mutable
import scala.collection.mutable.HashMap
val map = new mutable.HashMap[Int,String]()

map += 4 -> "four"


val fruits = List("apple","banana","orange")
fruits.foreach(fruit => println(fruit))
val fruitSet = Set("apple","banana","orange")
fruitSet.foreach(fruit => println(fruit))
val fruitMap = Map("apple"->"fruit","banana"->"fruit")
fruitMap.foreach(fruit => println(fruit))
fruitMap.foreach(fruit => println(fruit._1))
fruitMap.foreach(fruit => println(fruit._2))

numbers
numbers.isEmpty
numbers.size
numbers.head

numbers.tail

list
list.isEmpty
list.length
list.size
list.head
list.tail

list.last
list.init

list.reverse
list.drop(1)
list
list.drop(2)
list
Nil.isEmpty

fruits.count(fruit => fruit.length >5)
fruits.filter(fruit => fruit.length >5)
fruits.map(fruit => fruit.length)
fruits.forall(fruit => fruit.length >=5)
fruits.exists(fruit => fruit.length >5)
fruits.sortWith((s,t) => s.charAt(0).toLower < t.charAt(0).toLower)

val sum = (list.foldLeft(0)((sum,i) => sum +i))

def toDo(weather: String) = weather match {
  case "sunny" => "stay at home"
  case "cloudy" => "go bike"
  case _ => "hang around"
}

println(toDo("rainny"))
println(toDo("cloudy"))

val reg = """^(F|f)\w*""".r

reg.findFirstIn("i love fruit")

val regs = "fruit".r
regs.findAllIn("i love fruit")











