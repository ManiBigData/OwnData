package SparkPack

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object SparkObj {

  def main(args:Array[String]):Unit={
    val conf = new SparkConf().setAppName("wordcount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().getOrCreate()


    val rdd = sc.textFile("file:///E:/Big_data_files/txns_gym.txt")
    val word = rdd.flatMap(line => line.split(""))
    val wordpair = word.map(word => (word,1))
    val df = sc.parallelize(wordpair)
    







  }

}
