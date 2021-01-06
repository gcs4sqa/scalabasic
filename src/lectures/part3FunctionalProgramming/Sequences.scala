package lectures.part3FunctionalProgramming

import scala.util.Random

object Sequences extends App {
  //Seq
  val aSequence = Seq(1, 3, 2,  4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))//apply method like a get for the 2nd index
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  //Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).map(x => println("Hello World " + x))
  (1 until 10).map(x => println("Hello World " + x))

  //Lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // +: also does prepending.
  val preAndPostAppended = 42 +: aList :+ 89
  println(prepended)
  println(preAndPostAppended)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(aList.mkString("-|-"))

  //arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)

  //mutation
  numbers.foreach(println)
  numbers(2)=0 //syntax sugar for numbers.update(2, 0)
  numbers.foreach(println)
  println(numbers.mkString(" "))

  //arrays and sequences
  val numbersSeq: Seq[Int] = numbers // this is an implicit conversion - converts an array to a sequence
  println(numbersSeq)

  //vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  //performance test
  //vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 100000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      //Operation
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() -  currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //advantage of - keeps reference to tail
  //disadvantage of - updating an element in the middle takes a long time
  println(getWriteTime(numbersList))
  //advantage of - depth of the tree is small
  //disadvantage of - needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
