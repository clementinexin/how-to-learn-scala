/**
  * Created by dj on 2017/7/5.
  */
// BEGIN scala_process
val employees = List("neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan",
  "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack")

val result = employees
  .filter(_.length() > 1)
  .map(_.capitalize)
  .reduce(_ + "," + _)
// END scala_process
println("Process:" + result)

// BEGIN scala_process_parallel
val parallelResult = employees
  .par
  .filter(_.length() > 1)
  .map(_.capitalize)
  .reduce(_ + "," + _)
// END scala_process_parallel
println("Parallel:" + parallelResult)

println("\nBoundary:\n================")
val bresult = List("")
  .filter(_.length() > 1)
  .map(_.capitalize)

println("Boundary:" + bresult)

val numbers = List.range(1,11)
numbers filter(_ % 3 == 0)

val words = List("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog")
words filter (_.length == 3)

numbers partition(_ % 3 == 0)

numbers find(_ % 3 ==0)

numbers find(_ < 0)

numbers takeWhile( _ % 3 == 0)

words dropWhile(_ startsWith("t"))

List(1,2,3,4,5) map (_ + 1)

words.map(_.length)

List(List(1,2,3),List(4,5,6),List(7,8,9)) flatMap(_.toList)

words flatMap(_.toList)
List.range(1,10) reduceLeft((a,b) => a + b)

List.range(1,10) reduceLeft(_ + _)

List.range(1,10) reduceRight(_ - _)

words.reduceLeft((a,b) => if (a.length > b.length) a else b)

List.range(1,10).foldLeft(0)(_ + _)

(0 /: List.range(1,10)) (_ + _)

(List.range(1,10) :\ 0) (_ - _)

def filter(xs:List[Int] ,p:Int => Boolean):List[Int] =
  if(xs.isEmpty) xs
  else if (p(xs.head)) xs.head::filter(xs.tail,p)
  else filter(xs.tail,p)

def modN(n:Int)(x:Int) = ( (x % n) == 0)

println(filter(List.range(1,10),modN(2)))

println(filter(List.range(1,10),modN(3)))


def price(product:String) :Double =
  product match {
    case "apple" => 100
    case "orange" => 200
  }

def withTax(cost:Double, state:String) :Double =
  state match {
    case "NY" => cost * 2
    case "FL" => cost * 3
  }

val locallyTaxed = withTax(_:Double,"NY")
val appleCost = locallyTaxed(price("apple"))

val cities = Map("Atlanta" -> "GA", "New York" -> "New York",
  "Chicago" -> "IL", "San Francsico " -> "CA", "Dallas" -> "TX")

cities map {case (k,v) => println(k + " -> " + v )}


//List(1,3,5,"seven") map { case number:Int => number + 1 }


List(1,3,5,"seven") collect { case number:Int => number + 1 }

val diviede = new PartialFunction[Int,Int] {
  def apply(d:Int) = 1 /d
  def isDefinedAt(d:Int) = d != 0
}

assert(diviede.isDefinedAt(1))
assert(!diviede.isDefinedAt(0))

val divide :PartialFunction[Int,Int] = {
  case d:Int if d!= 0 => 1/d
}

