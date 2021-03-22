package scalaTest

class ApplyTest {

  private var name = ""
  private var age = 0

  def this (name : String, age : Int) {
    this()
    this.name = name
    this.age = age
  }
  def apply: ApplyTest = new ApplyTest("zhang", 18) {
  }
  def printName = {
    this.name
  }

}

