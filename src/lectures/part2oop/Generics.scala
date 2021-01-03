package lectures.part2oop

object Generics extends App {

  class MyList[A]{
    //use type A in the body
  }

  class MyMap[Key, Value]
  val myListofInts = new MyList[Int]
  val myListofStrings = new MyList[String]
  val myMapValue = new MyMap[String, String]

  //generic methods
//  object MyList{
//    def empty[A] : MyList[A] = println("is works")
//  }
//  val emptyListOfIntegers = MyList.empty[Int]

  //the variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  //1. yes, list of List[cat] extends list of List[Animal] - covariance
  class CovarianceList[+A]
  val animal: Animal = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]

  //2. no, - invariance
  class InvarianceList[A]
  //val animalList2: InvarianceList[Animal] = new InvarianceList[Cat]
 // remark out at invariance must have a new Animal not cat

  //3. hell no, contravariant
  class ContravariantList[-A]
  //val contravariantList : ContravariantList[Cat] = new ContravariantList[Animal]

  //bounded types
  // <: this means that only class inheriting from Animal can be used
  // >: this means that the super type of the class can only be used
  class Cage[A <: Animal](animal: A)
  val myCage = new Cage(new Dog)

  class Car

  //val newcage = new Cage(new Car)
}
