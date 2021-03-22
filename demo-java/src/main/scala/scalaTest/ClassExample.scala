package scalaTest

class ClassExample {
  private var name : String = ""
  private var age : Int = 20
  def nameVale=name
  def nameValue_=(nameStr : String) {
    name = nameStr
  }
  def value = age
  def value_=(newValue : Int) {
    age = newValue
  }
}
