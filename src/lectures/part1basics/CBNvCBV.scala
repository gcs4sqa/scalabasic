package lectures.part1basics

object CBNvCBV extends App {

  def callByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  def callByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinate(): Int = 1 + infinate()
  def printfirst(x: Int, y: => Int): Unit = println(x)

  //printfirst(infinate(), 34)
  printfirst(34, infinate())

}
