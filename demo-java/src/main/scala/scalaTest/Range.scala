package scalaTest

object Range {
  // Range 数值遍历
  def main(args: Array[String]): Unit = {
    // 1 to 1 to 5
    1 to 5
    // 2 to 1.to(5)
    1.to(5)
    // 3 to by 创建一个从1到10的数值序列，包含区间终点10，步长为2
    val range = 1 to 10 by 2
    println(range)
    // 4 to by 创建一个从1到10的数值序列，包含区间终点10，步长为2
    val range1 = 1.to(10).by(2)
    println(range1)
    // 5 until 创建一个从1到5的数值序列，不包含区间终点5，步长为1
    val until = 1 until 5 by 2
    println(until)
  }

}
