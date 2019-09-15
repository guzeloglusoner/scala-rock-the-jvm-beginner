package lectures.part3fp

import scala.util.Random

/**
  * Created by soner.guzeloglu onn 22.07.2019
  */
object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)

  //  unsafe APIs

  def unsafeMethod(): String = null

  //  val result = Some(unsafeMethod()) // WRONG

  val result = Option(unsafeMethod()) // Some or None

  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafaMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafaMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE DO NOT USE THIS

  // map, flatMap and filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
  *
  * */

  val config: Map[String, String] = Map(
    //     fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // Connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  //  try to establish a connection, if so - print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
      if(h != null)
        if(p != null)
          return Connection.apply(h, p)
  *
  *   return null
  * */
  val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))

  /*
  * if (c!=null)
  *   return c.connect
  * return null
  * */
  val connectionStatus: Option[String] = connection.map(c => c.connect)
  // if(connectionStatus == null) println(none) else print (Some(connectionStatus.get))
  println(connectionStatus)

  /*
  * if(status != null)
  *   printkn(status)
  *
  * */
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus: Option[String] = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)
}
