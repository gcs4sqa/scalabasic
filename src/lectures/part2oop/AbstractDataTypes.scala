package lectures.part2oop

object AbstractDataTypes extends App {

  //abstract class
  abstract class Animal {
    val creature : String = "Wild"
    def eat : Unit
  }

  class Dog extends Animal {
    override val creature: String = "canine"
    override def eat: Unit = println("crunch crunch")
  }

  //Traits
  trait Canivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded {
    def blood(animal: Animal): Unit
  }

  class Crocodile extends Animal with Canivore with ColdBlooded {
    override val creature: String = "croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and i eat ${animal.creature}")

    override def blood(animal: Animal): Unit = println(s"I'm a ${this.creature} and I am coldblooded, unlike a ${animal.creature}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
  croc.blood(dog)

  //traits v abstract
  // 1. traits do not have constructor parameters
  // 2. multiple traits can be inherited by the same class
  // 3. traits are behaviour, abstract is a thing

}
