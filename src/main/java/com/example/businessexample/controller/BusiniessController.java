package com.example.businessexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class BusiniessController {

    // 1. DTO Mapping Tutorial

    /* Post Man 요청 값
    {
            "id" : 1,
            "rouletteCode" : "hello",
            "good" : ["hi", "hi", "hi"],
            "goodDto" : [
            {"id" :1, "title":"안뇽"},
            {"id" :1, "title":"안녕"}
            ]
    }
    */

    //DTO 연결 및 정제 튜토리얼
    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody TestDto testDto) {
        System.out.println(testDto.getRouletteCode()); // 단일 값 매핑
        System.out.println(testDto.getGood().size()); // 배열(goodDto) 내 Object 배핑
        System.out.println(testDto.getGoodDto().get(0).getId());
        List<GoodDto> goodDto = testDto.getGoodDto();

        System.out.println(HelloDto.classify(goodDto)); // 배열 내 동일한 id끼리 묶기
        // 순서화되지 않은 값들을 정제할 때 좋음.
        // 분류할 때 좋음

        return new ResponseEntity<>(testDto, HttpStatus.OK);
    }

    // 2. HashMap Practice

    @PostMapping("/test2")
    public void test2() {
        String[] arr1 = {"aaa", "bbb", "ccc", "aaa", "aaa", "ccc"};

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String a : arr1) map.put(a, map.getOrDefault(a, 0) + 1);
        System.out.println(map);
        // [aaa=3, ccc=2, bbb=1]
    }
}

