package spark.sparkStreaming

import org.apache.kafka.clients.consumer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object DirectKafkaWordCount {

  def main(args: Array[String]): Unit = {
    if(args.length < 3) {
      System.err.println(s"""
                            |Usage: DirectKafkaWordCount <brokers> <groupId> <topics>
                            |  <brokers> is a list of one or more Kafka brokers
                            |  <groupId> is a consumer group name to consume from topics
                            |  <topics> is a list of one or more kafka topics to consume from
                            |
        """.stripMargin)
      System.exit(1)
    }

    val Array(brokers, groupId, topics) = args

    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("DirectKafkaWordCount")

    // 有时候会产生 _SUCCESS 文件。使用下面的设置就可以不产生这个文件：
    sparkConf.set("spark.hadoop.mapreduce.fileoutputcommitter.marksuccessfuljobs", "false")

    val ssc = new StreamingContext(sparkConf, Seconds(10))

    val topicsSet = topics.split(",").toSet

    val kafkaParams = Map[String, Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers,
      ConsumerConfig.GROUP_ID_CONFIG -> groupId,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer])

    val message = KafkaUtils.createDirectStream[String, String](ssc,
      LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](topicsSet, kafkaParams))

    val lines = message.map(_.value)

    val words = lines.flatMap(_.split(" "))

    val wordCounts = words.map( x => (x, 1)).reduceByKey(_+_)

    wordCounts.print()

    ssc.start()

    ssc.awaitTermination()

  }

}
