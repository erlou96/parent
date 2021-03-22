package scalaTest

import java.io.PrintWriter

import scala.io.Source

object WriteAndRead {
  // 写入一个文件
  def main(args: Array[String]): Unit = {
    var out = new PrintWriter("D://new.txt")
    for (i <- 1 to 5) out.println(i)
    out.close()

    // 读取文件
    val input = Source.fromFile("D://new.txt")
    val lines = input.getLines()
    for(line <- lines) println(line)
  }

}
