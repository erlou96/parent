package flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class WorldCountByWindow {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("参数个数不足");
            System.exit(1);
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> text = env.socketTextStream(host, port);

        SingleOutputStreamOperator<WordWithCount> windowCount = text.flatMap(new FlatMapFunction<String, WordWithCount>() {
            public void flatMap(String value, Collector<WordWithCount> out) {
                String[] strs = value.split("\\s");
                for (String word : strs) {
                    out.collect(new WordWithCount(word, 1));
                }
            }
        })
                .keyBy("word")
                //.timeWindow(Time.seconds(2), Time.seconds(1))
                .sum("count");

        windowCount.print().setParallelism(2);
        env.execute("stream word count");
    }
    public static class WordWithCount{
        public String word;
        public long count;
        public WordWithCount(){}
        public WordWithCount(String word, long count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return "WordWithCount{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
