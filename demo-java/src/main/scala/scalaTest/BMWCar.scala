package scalaTest

class BMWCar extends Car {

  var Name = "BMW"
  override def info(): Unit = {
    print("我是宝马")
  }
}
class BYDCar extends Car {
  var Name = "BYD"

  override def info(): Unit = {
    println("我是比亚迪")
  }
}

object MYCar {
  def main(args: Array[String]): Unit = {
    val bm = new BMWCar
    val byd = new BYDCar
    println(bm.Name)
    print(byd.info)
  }
}
