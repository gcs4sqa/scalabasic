package lectures.part3FunctionalProgramming

object TuplesAndMaps extends App {
  // Tuples - finite ordered lists
  val aTuple = new Tuple2(2, "Hello, scala") //tuple2[Int, String] = (Int, String)
  val aTuple2 = (2, "Hello, scala") //tuples can also be written this way
  println(aTuple._1)
  println(aTuple._2)

  println(aTuple.copy(_2 = "Goodbye Java"))

  println(aTuple.swap)
  //Maps - associates Keys to Values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Daniel" -> 123).withDefaultValue(-1)
  // a -> b is syntactic sugar for (a, b)
  println(phoneBook)

  //basic Map operations
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary"))

  //add a new pairing
  val pairing = "Mary" -> 678
  val newPhoneBook = phoneBook + pairing
  println(newPhoneBook)

  //functionals on maps
  //map, flatMap, filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys
  println(phoneBook.filterKeys(_.startsWith("J")))
  //is the same as
  println(phoneBook.filterKeys(x => x.startsWith("J")))
 //mapValues
  println(phoneBook.mapValues(number => "0245 " + number  * 10))

  //conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Daniel", "John", "Keith", "Brian", "Bernard", "Cliff", "James")
  println(names.groupBy(name => name.charAt(0)))

}
