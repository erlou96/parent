package scalaTest

object xunhuan {

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) println(i)

    // 设置步长为2
    for (i <- 1 to 10 by 2) println(i)

    // 设置过滤条件
    for (i <- 1 to 10 if i % 2 == 0) println(i)

    // 设置多个循环
    for (i <- 1 to 5; j <- 1 to 3) println(i * j)

    // 设置多个循环，并设置守卫
    for (i <- 1 to 5 if i % 2 == 0; j <- 1 to 3 if j != i) println(i * j)
  }
}
