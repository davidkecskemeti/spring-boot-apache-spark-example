package com.dk.springapachespark.controller;

import com.dk.springapachespark.bean.Count;
import com.dk.springapachespark.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class WordCountController {

    @Autowired
    private WordCounterService wordCounterService;

    @GetMapping
    public ResponseEntity<List<Count>> words(@RequestBody String input) {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    @PostMapping( path = "/wordcount")
    public Map<String, Long> count(@RequestBody String input) {
        return wordCounterService.getCount(input);
    }
}