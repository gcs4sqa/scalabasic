package lectures.part2oop

object notations extends App {

  class Person(val name: String, favoriteMovie: String){
    def likes(movie: String):Boolean = movie == favoriteMovie
    // can be used as an operator like math function
    def +(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the !!!"
    def isAlive : Boolean = true
    def apply(): String = s"Hi my name is $name and my favoriate movie is $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")// infox or operator notation

  val tom = new Person("Tom", "Fight Club")

  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //prefix notation
  val n = -1
  val m = 1.unary_-

  println(n)
  println(m)

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())



}
