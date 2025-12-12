package org.example.simpleflinkjob;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.time.Instant;

public class SimpleFlinkJob {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> textStream = env.fromData(
            "Hello Flink",
            "Flink is a powerful stream processing framework",
            "This is a simple Flink job"
        );

        DataStream<String> upperCasedStream = textStream.map(String::toUpperCase);

        DataStream<String> filteredStream = upperCasedStream.filter(line -> line.length() >= 20);

        filteredStream.print();

        env.execute(String.format("Simple Flink Job - %s", Instant.now().toString()));
    }
}
