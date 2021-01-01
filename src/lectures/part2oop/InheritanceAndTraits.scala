package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal {
    val creaturtype = "wild"
    def eat = println("nomnom")
  }

  //single class inheritance
  class Cat extends Animal{
    def crunch = {
      eat
      println("Crunch Crunch")
    }
  }

  val cat = new Cat

  cat.crunch

  //constructors
  class Person (name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult (name: String, age: Int, idCard: String) extends Person(name)

  //override

  class Dog extends Animal {
    override val creaturtype: String = "tame"
    override def eat: Unit = println("dog yum yum")
    def supereat = println(super.eat)
  }

  class Budgie(override val creaturtype: String) extends Animal{
    override def eat: Unit = println("budgie yum yum")
    def supereat = println(super.eat)
  }

  val dog = new Dog
  dog.eat
  println(dog.creaturtype)

  val buttons = new Budgie("livid")
  println(buttons.creaturtype)
  val cinders = new Budgie("happy")
  println(cinders.creaturtype)

  //type substituation (broad polymorphism)

  val unknownAnimal = new Budgie("K9")
  unknownAnimal.eat


  //super
  dog.supereat

 //preventing overrides

  //use the word final before the super def
  //use final in front of class to prevent a class being extended
  // use sealed to allow only extend in current file
}
