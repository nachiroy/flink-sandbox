package com.microsoft.naroy.simpleflinkjob;

import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

import java.time.Instant;

public class SimpleFlinkJob {
    public static void main(String[] args) throws Exception {
        final ParameterTool params = ParameterTool.fromArgs(args);

        // Get the execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment
                .getExecutionEnvironment();

        // Set the global job parameters
        env.getConfig().setGlobalJobParameters(params);

        // Read a simple data stream
        DataStream<String> text = env.fromData(
                "Hello Flink!",
                "Flink is a powerful stream processing framework.",
                "This is a simple Flink job.",
                "Running on Naroy!"
        );

        // Filter lines of length greater than 15
        DataStream<String> filteredStream = text.filter(line -> line.length() > 15);

        // Print the filteredStream lines to the console
        filteredStream.print();

        // Execute the Flink job
        env.execute(String.format("Simple Flink Job - %s", Instant.now()));
    }
}
