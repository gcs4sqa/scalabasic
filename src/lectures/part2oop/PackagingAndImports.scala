package lectures.part2oop

import playground.{Buttons, Cinderella}

import java.util.Date
import java.sql.{Date => SQLDate}

object PackagingAndImports extends App {

  //package members are accessible by their simple name

  val writer = new Writer("Cliff", "RockTheJVM", 2021)

  //Importing the package

  val cinders = new Cinderella
  //or you can use the fully qualified name
  //val cinders = mew playground.Cinderella

  val buttons = new Buttons

  //package objects
  sayHello
  println(SPEED_OF_LIGHT)

  //imports with same name can be aliased
  val date = new Date()
  val sqlDate = new SQLDate(2004, 5, 4)

}
