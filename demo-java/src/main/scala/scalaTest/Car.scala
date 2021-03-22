package scalaTest

abstract class Car {
  var Name : String // 字段没有初始化，就是抽象字段
  def info() // 抽象方法，不需要加abstract关键字
  def greetiong(): Unit = {
    println("welcome to my car")
  }

}
