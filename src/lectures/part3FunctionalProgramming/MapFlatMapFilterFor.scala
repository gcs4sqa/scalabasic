package lectures.part3FunctionalProgramming

object MapFlatMapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  //map
  println("map")
  println(list.map(_+1))
  println(list.map(_ + " is a number"))

  //filter
  println("filter")
  println(list.filter(_ % 2 == 0)) //only retains the even numbers

  //FlatMap
  println("flatMap")
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  //exercise
  val numbers = List(1, 2, 3, 4)
  val char = List('a', 'b', 'c', 'd')
  val colours = List("Red", "Yellow", "Green", "Blue")

  //iterations
  val combs = numbers.flatMap(n => char.map(c => "" + n + c))
  val combPlus = numbers.flatMap(n => char.flatMap(c => colours.map(colours => "" + n + c + "-" + colours)))
  println(combs)
  println(combPlus)

  //foreach
  list.foreach(println)
  combPlus.foreach(println)

  //short hand for all these chains are called for-comprehensions
  //this example includes an if guard which is the same as filter
  val forComb = for {
    n <- numbers if n % 2 == 0
    c <- char
    colours <- colours
  } yield "" + n + c + "-" + colours

  println(forComb)
}
