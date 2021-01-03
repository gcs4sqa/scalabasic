package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal =  new Animal {
    override def eat: Unit = println("ahahahahah")
  }

  /*
  this is equivalent to
  class AnonymousClasses$$anon$1:Animal {
  override def eat: Unit = println("ahahahahah")

  val funnyAnimal: Animal = AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)
}
