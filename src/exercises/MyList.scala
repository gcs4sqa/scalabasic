package exercises


abstract class MyList [+A] {

  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
   */

  def head : A
  def tail : MyList [A]
  def isEmpty : Boolean
  def add [B >: A](element: B): MyList [B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B] (transformer: A => B): MyList[B]
  def flatmap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList [Nothing]{
  def head : Nothing = throw new NoSuchElementException
  def tail : MyList [Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add[B >: Nothing](element: B): MyList [B] = new Cons(element, Empty)
  def printElements: String = ""
  def map[B] (transformer: Nothing => B): MyList[B] = Empty
  def flatmap[B] (transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons [+A](h: A, t: MyList [A]) extends MyList [A]{
  override def head: A = h
  override def tail: MyList [A] = t
  override def isEmpty: Boolean = false
  override def add [B >: A](element: B): MyList [B] = new Cons(element, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
  how the map works
  [1, 2, 3].map(n * 2)
  = new Cons(2, [2,3].map(n * 2))
  = new Cons(2, new Cons(4, [3]. map(n * 2 )))
  = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
  = new Cons(2, new Cons(4, new Cons(6, Empty))))
   */
  override def map[B](transformer: A => B): MyList[B] =
    new Cons (transformer(h), t.map(transformer))

  /*
  how the flatmap works
  [1, 2].flatmap(n => [n, n + 1])
  = [1, 2] ++ [2].flatmap(n => [n, n + 1])
  = [1, 2] ++ [2, 3] ++ Empty.flatmap(n => [n, n + 1])
  = [1, 2] ++ [2, 3] ++ Empty
  = [1,2,2,3]
   */

  override def flatmap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatmap(transformer)

  /*
  how the filter works
  [1, 2, 3].filter(n % 2 == 0)
  = [2, 3].filter(n % 2 == 0)
  = new Cons(2, [3].filter(n % 2 == 0))
  = new Cons(2, Empty.filter(n % 2 == 0))
  = new Cons(2, Empty)

   */
  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  how the ++ concatenation works
  [1, 2] ++ [3, 4, 5]
  = new Cons(1, [2] ++ [3, 4, 5])
  = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
  = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */

  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)


}

//trait MyPredicate[-T] {
//  def test(element: T): Boolean
//}
//
//
//
//trait MyTransformer[-A, B]{
//  def transform(element: A): B
//}

object ListTest extends App {
  val listofInteger: MyList[Int]  = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val clonelistofInteger: MyList[Int]  = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListofInteger: MyList[Int]  = new Cons(4, new Cons(5, Empty))
  println(listofInteger.tail.head)
  println(listofInteger.add(4).head)
  println(listofInteger.toString)

  val listofString: MyList[String]  = new Cons("Hello", new Cons("bonjour", new Cons("guttenTag", Empty)))
  println(listofString.tail.head)
  println(listofString.add("good day").head)
  println(listofString.toString)

  println(listofInteger.map( elem => elem * 2).toString)

  println(listofInteger.filter(elem => elem % 2 == 0).toString)

  println((listofInteger ++ anotherListofInteger).toString)
  println(listofInteger.flatmap(element => new Cons(element, new Cons(element + 1, Empty))).toString)

  println(listofInteger ==  clonelistofInteger)
  println(clonelistofInteger)
}



