package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 2)

  /*Leading default parameter needs not to be ommited*/
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  savePicture(width = 900)

  /*
  * 1. pass in every leading argument
  * 2. name the arguments
  * */

  savePicture(height = 900, width = 1000, format = "bmp")
}
