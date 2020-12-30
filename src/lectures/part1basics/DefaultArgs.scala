package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFunc(n: Int, acc :Int = 1): Int =
    if (n <=1 )acc
    else trFunc(n-1, n * acc)

  println(trFunc(10))

  def savepicture(format:String = "bmp", width:Int = 1920, height: Int = 1080):Unit =
    println("the format is " + format + " the width is " + width + " the height is " + height)

 println(savepicture(width = 800))
}
