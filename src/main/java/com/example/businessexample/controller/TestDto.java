package com.example.businessexample.controller;

import lombok.Getter;

import java.util.List;

@Getter
public class TestDto {

    private Long id;
    private String rouletteCode;
    private List<String> good;
    private List<GoodDto> goodDto;
    //private Map<GoodDto, Integer> test;
    /*public TestDto(Roulette entity) {
        this.id = entity.getId();
        this.rouletteCode = entity.getRouletteCode();
        this.rouletteSegment = entity.getRouletteSegments().stream()
                .map(o -> new RouletteSegmentResponseDto(o)).collect(Collectors.toList());
        this.prize = entity.getPrize();
        this.title = entity.getTitle();
        this.rouletteStatus = entity.getStatus();
    }*/


}