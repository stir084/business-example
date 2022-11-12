package com.example.businessexample.controller;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.stream.Stream;

@Getter
@EqualsAndHashCode(exclude = {"title"})
public class HelloDto {
    private int id;
    private String title;

    public HelloDto(GoodDto entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
    }
    public static Stream<List<HelloDto>> classify(List<GoodDto> goodDtos){
        Map<HelloDto, List<HelloDto>> classifiedPayment = new LinkedHashMap<>();

        for (GoodDto goodDto : goodDtos) {
            HelloDto dto = new HelloDto(goodDto);
            List<HelloDto> list = classifiedPayment.get(dto); //classifiedPayment를 꺼내서 list에 같은 주소 값을 담음 -> 이미 존재한다면 add 처리

            if(list != null){
                list.add(dto);
            } else {
                classifiedPayment.put(dto, new ArrayList<>(Collections.singletonList(dto)));
            }
        }
        System.out.println("하하"+classifiedPayment);
        return classifiedPayment.entrySet().stream()
                .map(Map.Entry::getValue);
    }
}