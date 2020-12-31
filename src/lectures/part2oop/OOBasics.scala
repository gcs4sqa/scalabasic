package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  val newperson = new Person("cliff")
  println(person.age)
  person.greeting("daniel")
  person.greeting()
  newperson.greeting()
  println(newperson.age)

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.ageofauthor())
  println(novel.isWrittenby(author))
  println(novel.isWrittenby(imposter))

  val counter = new Counter()
  counter.inc.print()
  counter.inc.inc.print()
  counter.inc(10).print()
  counter.inc(0).print()
  counter.dec(1).print()
}

class Person(name: String, val age: Int) {
  def greeting(name: String):Unit = println(s"${this.name} says hello $name")
  //this is overloading
  def greeting():Unit = println(s"hi this is $name")

  //multiple constructor
  def this(name: String) = this(name, 30)
}
/*
Novel and writer
  writer: first name, surname, year
    method: full name

  Novel: name, year of release, author
  - author age
  - isWrittenBy
  - copy (new year of release) = new instance of novel

 */
class Writer(firstname: String, surname: String, val year: Int){
  def fullname():String = s"${this.firstname} ${this.surname}"
}
class Novel(name: String, yearofrelease: Int, author: Writer){
  def ageofauthor():Int = yearofrelease - author.year
  def isWrittenby(author: Writer): Boolean = author == this.author
  def copy(newYear: Int):Novel = new Novel(name, newYear, author)


}

/*
  Counter Class
  - receives an int value
  - method current count
  - method to increment/decrement => new counter
  - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0){
  def inc:Counter = {
    println("Incrementing")
    new Counter(count + 1 )
  } // this is immutability, you cannot change in an instances
  def dec: Counter = {
    println("decrementing")
    new Counter(count - 1 )
  }


  def inc(n:Int):Counter = {
    if(n<=0)this
    else inc.inc(n-1)
  }

  def dec(n:Int) :Counter = {
    if(n<=0) this
    else dec.dec(n-1)
  }

  def print(): Unit = println(count)
}