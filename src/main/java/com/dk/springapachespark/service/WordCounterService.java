package com.dk.springapachespark.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class WordCounterService {

    @Autowired
    private JavaSparkContext javaSparkContext;

    public Map<String, Long> getCount(String input) {
        List<String> wordList = Arrays.asList(input.split("\\|"));
        JavaRDD<String> words = javaSparkContext.parallelize(wordList);
        return words.countByValue();
    }
}