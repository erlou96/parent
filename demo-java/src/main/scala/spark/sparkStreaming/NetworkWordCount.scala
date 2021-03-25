package spark.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Spark Streaming 处理 Socket 数据
  *
  */
object NetworkWordCount {

  def main(args: Array[String]): Unit = {

    if(args.length < 2) {
      System.err.println("需要2个参数")
      System.exit(1)
    }

    // 创建SparkConf对象
    val sparkConf = new SparkConf().setAppName("NetworkWordCount").setMaster("local[2]")

    //创建StreamingContext对象，与集群进行交互
    val ssc = new StreamingContext(sparkConf, Seconds(1))

    // Create the FileInputDStream on the directory and use the
    // stream to count words in new files created
    //如果目录中有新创建的文件，则读取
    val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_AND_DISK_SER)

    val words = lines.flatMap( x => x.split(" "))
    //统计单词出现次数
    val wordsCount = words.map( x => (x, 1)).reduceByKey(_+_)

    wordsCount.print
    //启动Spark Streaming
    ssc.start()
    //一直运行，除非人为干预再停止
    ssc.awaitTermination()

  }

}
