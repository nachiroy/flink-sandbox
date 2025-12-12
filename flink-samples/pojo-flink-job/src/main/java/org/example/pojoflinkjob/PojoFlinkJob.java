package org.example.pojoflinkjob;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.time.Instant;

public class PojoFlinkJob {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Person> flintstones = env.fromData(
                new Person("Fred Flintstone", 35),
                new Person("Wilma Flintstone", 33),
                new Person("Barney Rubble", 34),
                new Person("Betty Rubble", 32),
                new Person("Pebbles Flintstone", 6),
                new Person("Bamm-Bamm Rubble", 5),
                new Person("Dino", 4)
        );

        DataStream<Person> adults = flintstones
                .filter(person -> person.age >= 18);

        adults.print();

        env.execute(String.format("Pojo Flink Job - %s", Instant.now().toString()));
    }
}

