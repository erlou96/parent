package scalaTest

object ListTest {
  def main(args: Array[String]): Unit = {
    // 定义一个list
    val list = List[String]("scala","java","python")
    for(i <- list) println(i)

    // 头部插入一个元素
    val newlist = "c#"::list
    for(i <- newlist) println(i)

    // 或者这样定义一个list
    val intList = 1::2::3::Nil

    val intList1 = List(1,2)
    val intList2 = List(3,4)
    val intList3 = intList1:::intList2

    // list 的一些function
    println(intList3.sum)
    val intList4 = intList3.map(x => x + 1)
    intList4.foreach(println)

  }

}
