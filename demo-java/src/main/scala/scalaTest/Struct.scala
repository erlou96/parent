package scalaTest

object Struct {
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3)
    for (i <- array) println(i)

    val array1 = new Array[Int](3)
    array1(0) = 1
    array1(1) = 2
    array1(2) = 3

  }

}
