package sparkSql

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object SparkSQLExample {

  case class Person (age: BigInt, name:String)

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value").master("local[2]").getOrCreate()

    runBasicDataFrameExample(spark)

    // runDatasetCreationExample(spark)

    // runInferSchemaExample(spark)

    runProgrammaticSchemaExample(spark)

  }

  private def runBasicDataFrameExample(spark: SparkSession): Unit = {

    val df = spark.read.json("D:\\code\\test\\src\\main\\resources\\spark\\people.json")

    df.show()

    import spark.implicits._

    df.printSchema()

    df.select("name").show()

    // 过滤算子filter(filter等价于where算子)
    // 必须增加语句：import spark.implicits._，否则$表达式会报错
    df.select("*").filter( $"age" > 20).show()

    df.select($"name", $"age" + 1).show()

    df.groupBy("age").count().show()

    df.createOrReplaceTempView("people")

    val sqlDF = spark.sql("SELECT * FROM people")

    sqlDF.show()
  }

  private def runDatasetCreationExample(spark: SparkSession) = {
    import spark.implicits._

    val caseClassDS = Seq(Person(2, "Andy")).toDS()

    caseClassDS.show()

    val primitiveDS = Seq(1, 2, 3).toDS()

    primitiveDS.map(_ + 1).collect()

    val path = "D:\\code\\test\\src\\main\\resources\\spark\\people.json"

    val peopleDS = spark.read.json(path).as[Person]

    peopleDS.show()

  }

  private def runInferSchemaExample(spark: SparkSession) = {
    import spark.implicits._

    val peopleDF = spark.sparkContext.textFile("file:///D:/code/test/src/main/resources/spark/people.txt")

    val lines = peopleDF.map(_.split(","))

    val map = lines.map(attributes => Person(attributes(0).toInt, attributes(1).trim())).toDF()

    map.createOrReplaceTempView("people")

    val teenagersDF = spark.sql("select * from people")

    teenagersDF.show()

    val teenagersDF1 = spark.sql("select name, age from people where age between 13 and 19")

    teenagersDF1.show()

    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]

    teenagersDF.map(teenager => teenager.getValuesMap[Any](List("age", "name"))).collect()
  }

  private def runProgrammaticSchemaExample(spark:SparkSession) = {
    import spark.implicits._
    val peopleRDD = spark.sparkContext.textFile("file:///D:/code/test/src/main/resources/spark/people.txt")

    val schemaString = "name age"

    val fields = schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, nullable = true))

    val schema = StructType(fields)

    val rowRDD = peopleRDD.map(_.split(",")).map(attributes => Row(attributes(0), attributes(1)))

    val peopleDF = spark.createDataFrame(rowRDD, schema)

    peopleDF.createOrReplaceTempView("people")

    val result = spark.sql("select * from people")

    result.map(attribute => "Name:" + attribute(1)).show()
  }

}
