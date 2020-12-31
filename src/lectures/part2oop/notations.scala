package lectures.part2oop

object notations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0 ){
    def likes(movie: String):Boolean = movie == favoriteMovie
    // can be used as an operator like math function
    def +(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    // added this for exercise 1..
    def +(nickname: String) :Person = new Person ( this.name + " (" + nickname + ")", "Grimsby Brothers")
    // end of exercise 1
    def unary_! : String = s"$name what the !!!"
    // added this for exercise 2.
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age +1)
    //end of ex 2
    def isAlive : Boolean = true
    // added this for exercise 3
    def learns(islearning: String): String = s"${this.name} is learning $islearning"
    def learns(): String = this.learns("Scala")
    //end of ex 3
    def apply(): String = s"Hi my name is $name and my favoriate movie is $favoriteMovie"
    //start of exercise 4
    def apply(timesWatched: Int): String = s"${this.name} watched her favorite movie, ${this.favoriteMovie} $timesWatched times"
    //end of ex 4
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")// infox or operator notation

  val tom = new Person("Tom", "Fight Club")

  println(mary + tom)
  println(mary.+(tom))
  //request for exercise 1.
  val newname = mary + "the rock star"
  println(newname.name)
  //end of exercise 1.

  //start of exercise 2
  val newmary = +mary
  println("the new age is " + newmary.age)
  //end of exercise 2

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
  //start of exercise 3
  println(mary.learns("VB"))
  println(mary learns "C++")
  println(mary.learns())
  println(mary learns())
  //end of exercise 3

  //apply
  println(mary.apply())
  println(mary())
  //start of exercise 4
  println(mary.apply(3))
  println(mary apply 4)
  //end of exercise 4



}
