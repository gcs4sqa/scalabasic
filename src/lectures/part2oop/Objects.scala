package lectures.part2oop

object Objects extends App {

  //Scala does not have class-level functionality ("STATIC")
  object Person {
    val N_EYES = 2
    def canFly:Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    //instance level functionality
  }
  //the above are COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  //scala object is a singleton instance

  val mary = new Person("Mary")
  val john = new Person("John")

  println(mary == john)

  val bobbie = Person(john, mary)

  println(bobbie.name)

  //Scala Application = scala object with
  // def main(args: Array[String]) :Unit

}
