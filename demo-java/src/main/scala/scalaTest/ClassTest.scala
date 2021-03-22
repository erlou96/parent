package scalaTest

object ClassTest {
  def main(args: Array[String]): Unit = {
    val counter = new ClassExample
    counter.value_=(28)
    println(counter.value)
    counter.nameValue_=("zhangsan")
    var app = new ApplyTest
    println(app.printName)
  }
}
