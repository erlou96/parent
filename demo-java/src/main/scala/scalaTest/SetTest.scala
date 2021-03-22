package scalaTest

import scala.collection.mutable.Set

object SetTest {

  def main(args: Array[String]): Unit = {
    var set = Set("zhangsan","lisi")
    set.+("wangwu")
    val set2 = set.+("wangwu")
    println(set)
    println(set2)
  }
}
