package exercises

/**
  * Created by soner.guzeloglu onn 4.07.2019
  */
abstract class MyList[+A] {
  /*
  *
  * 1. head = first element of the list
  * 2. tail = remainder of the list
  * 3. isEmpty: boolean
  * 4. add(Int) => new list with this element added
  * 5. toString => a string representation of the list.
  * */
  val list: List[Int] = List.empty

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  // Polymorphic call
  // toString hashCode and equals are present on anyref we need to override them
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]

  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]

  def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]

  def fold[B](start: B)(operator: (B, A) => B): B

}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  override def printElements: String = ""

  /* higher-order functions */
  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  //override def foreach[A](f: Nothing => Unit): Unit = Empty
  override def foreach(f: Nothing => Unit): Unit = Unit

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else Empty
  }

  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
  * [1, 2, 3].map(n * 2) = new Cons(2, [2,3].map(n * 2))
  *                      = new Cons(2, new Cons(4, [3].map(n * 2)))
  *                      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
  *                      = new Cons(2, new Cons(4, new Cons(6, Empty))))
  * */
  override def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  /*  FLATMAP
  * [1, 2].flatMap(n => [n, n+1]))
  * = [1, 2] ++ [2].flatMap(n => [n, n+1])
  * = [1, 2] ++ [2, 3] ++ Empty
  * = [1, 2, 2, 3]
  * */
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  /* FILTER
  * [1, 2, 3]. filter(n % 2 == 0) =>
  *                               = [2,3].filter
  *                               = new Cons(2, [3].filter(n % 2 == 0))
  *                               = new Cons(2, Empty.filter(n % 2 == 0))
  *                               = new Cons(2, Empty)
  * */
  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /* ++
  * [1, 2] ++ [3, 4, 5]
  * = new Cons(1, [2] ++ [3,4,5]))
  * = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  * = new Cons(1, new Cons(2, new Cons(3,new Cons(4,new Cons(5))))
  * */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  // HOFS
  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {

    def insert(x: A, list: MyList[A]): MyList[A] =
      if (list.isEmpty) Cons(x, Empty)
      else if (compare(x, list.head) <= 0) new Cons(x, list)
      else Cons(list.head, insert(x, list.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Cons(zip(h, list.head), t.zipWith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B = t.fold(operator(start, h))(operator)
}


object ListTest extends App {
  /*  val list= new Cons(1, new Cons(2, new Cons(3, Empty)))
    println(list.tail.head)
    println(list.add(4).head)
    println(list.isEmpty)

    println(list.toString)*/

  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val clonelistOfIntegers: MyList[Int] = new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val alistOfIntegers: MyList[Int] = new Cons[Int](4, new Cons[Int](5, Empty))
  val listOfStrings: MyList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.map(_ * 2)).toString
  val doubler1: Int => Int = x => x * 2

  println(listOfIntegers.filter(_ % 2 == 0).toString)

  println(listOfIntegers ++ alistOfIntegers).toString
  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons[Int](elem + 1, Empty))))

  println(clonelistOfIntegers == listOfIntegers)
  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))
  println(List(1).head, List(2).tail)
  println(alistOfIntegers.zipWith[String, String](listOfStrings, _ + "-" + _))
  println(listOfIntegers.fold(0)(_ + _ ))

  val forComprehension = for{
    n <- listOfIntegers
    l <- listOfStrings
  }yield n+l

  println(forComprehension)

  println(List(1,2,3).map(_+ "Soner"))
}
