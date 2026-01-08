package com.javainit.sprint01.level03.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class F1NewsTest {

    private static final double DELTA = 0.0001;


    @Test
    void calculatePrice_returns150_whenTeamIsMercedes() {
        F1News news = new F1News("Some title", "Mercedes");
        double price = news.calculatePrice();
        assertEquals(150.0, price, DELTA);
    }

    @Test
    void calculatePrice_returns100_whenTeamIsOther() {
        F1News news = new F1News("some title", "Alphine");
        double price = news.calculatePrice();
        assertEquals(100.0, price, DELTA);
    }

    @Test
    void calculateScore_returns6_whenTeamIsMercedes_caseIntensive() {
        F1News news = new F1News("Some title", "Mercedes");
        int score = news.calculateScore();
        assertEquals(6, score);

    }
}
