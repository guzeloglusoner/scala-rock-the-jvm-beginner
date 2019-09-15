package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)

  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))


  val counter =  new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// Constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // This is a field

  println(1 + 3)

  // Method
  def greet(name: String) = println(s"${this.name} says: Hi $name") // this.name is the name of the object

  // overloading
  def greet() = println(s"Hi, I Am $name") // if you dont have a parameter name no need to use this.name


  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")

}

/*
* Novel and a Writer
*
* Writer: first name, surname, year
* -- method fullName
*
* Novel: name, year of release, author
* --method authorAge
* --method isWrittenBy(author)
* --copy (new year of release) = new instance of Novel
*
* */
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName() = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge = yearOfRelease - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}


/*
*
* Counter class
*   --receives an int value
*   -- nethod current count
*   -- method to inc/dec => new Counter
*   -- overload inc/dec to receive amount
* */

class Counter(val count: Int = 0) {

  def inc(): Counter = {
    println("incrementing")
    new Counter(count + 1) // immutability}
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }


  def dec(): Counter = new Counter(count - 1) // immutability


  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n - 1)


  def print = println(count)
}

// class parameter are NOT FIELDS