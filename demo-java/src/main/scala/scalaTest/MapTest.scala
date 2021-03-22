package scalaTest

object MapTest {
  def main(args: Array[String]): Unit = {
    val map = Map("zhangsan" -> 18, "li" -> 20, "wangwu" -> 23)

    for (i <- map) {
      println(i._1 + " ---- " + i._2)
    }

    println(map)
    println(map("zhangsan"))
    for ((k,v) <- map) {
      println(k + v)
    }
  }
}
