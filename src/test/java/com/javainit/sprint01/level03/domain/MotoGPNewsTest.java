package com.javainit.sprint01.level03.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MotoGPNewsTest {

    private static final double DELTA = 0.0001;

    @Test
    void calculatePrice_returns150_whenTeamIsHonda() {
        MotoGPNews news = new MotoGPNews("Some title", "Honda");
        double price = news.calculatePrice();
        assertEquals(150.0, price, DELTA);
    }

    @Test
    void calculatePrice_returns100_whenTeamIsOther() {
        MotoGPNews news = new MotoGPNews("Some title", "Ducati");
        double price = news.calculatePrice();
        assertEquals(100.0, price, DELTA);
    }

    @Test
    void calculateScore_returns6_whenTeamIsHonda_caseInsensitive() {
        MotoGPNews news = new MotoGPNews("Some title", "hOnDa");
        int score = news.calculateScore();
        assertEquals(6, score);
    }


}
