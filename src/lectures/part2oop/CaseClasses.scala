package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  //1. class parameters are fields

  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible toString
  println(jim.toString)

  //3. equals and hashcode are implemented ootb
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //4. case class have any copy methods
  val jim3 = jim.copy(age=45)
  println(jim3)

  //5. case class have companion objects
  val thePerson = Person
  val mary = Person("Mary", 44)
  println(mary)

  //6. case classes are serializable
  //like AKKA

  //7. case classes have extractor patterns = case classes can be used in pattern matching


  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }
}
