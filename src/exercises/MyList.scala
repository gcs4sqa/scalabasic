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
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
//HOFs
  def foreach(f: A => Unit):Unit
  def sort(compare: (A, A)=> Int): MyList[A]
  def zipWith[B, C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A)=>B): B
}

case object Empty extends MyList [Nothing]{
  def head : Nothing = throw new NoSuchElementException
  def tail : MyList [Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add[B >: Nothing](element: B): MyList [B] = new Cons(element, Empty)
  def printElements: String = ""
  def map[B] (transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B] (transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int) = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] =
    if(!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
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

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

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

  //hofs
  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)


  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head  ) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortTail = t.sort(compare)
    insert(h, sortTail)
  }

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] =
    if(list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  override def fold[B](start: B)(operator: (B, A) => B): B ={
    t.fold(operator(start, h ))(operator)
  }


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
  val listofString: MyList[String]  = new Cons("Hello", new Cons("bonjour",  Empty))
  println(listofString.tail.head)
  println(listofString.add("good day").head)
//  println(listofString.toString)
//
//  println(listofInteger.map( elem => elem * 2).toString)
//
//  println(listofInteger.filter(elem => elem % 2 == 0).toString)
//
//  println((listofInteger ++ anotherListofInteger).toString)
//  println(listofInteger.flatmap(element => new Cons(element, new Cons(element + 1, Empty))).toString)
//
//  println(listofInteger ==  clonelistofInteger)
//  println(clonelistofInteger)
//
//  listofInteger.foreach(println)
  println("Sort")
  println(listofInteger.sort((x, y) => y - x))
  println("pre-test")
  println(anotherListofInteger)
  println(listofString)
  println(anotherListofInteger.zipWith[String, String](listofString, _ + "-" + _ ))
  println(listofInteger.fold(0)(_+_))

  val combs = for {
   n <- listofInteger
    string <- listofString
  } yield n + "-" + string

  println(combs)
}



