package org.oandx.rest.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceRequestTest {

    private ChoiceRequest SUT = new ChoiceRequest();

    @Test
    void getX() {
        SUT.setX(1);
        assertEquals(SUT.getX(), 1);
    }

    @Test
    void setX() {
        SUT.setX(1);
        assertEquals(SUT.getX(), 1);
    }

    @Test
    void getY() {
        SUT.setX(1);
        assertEquals(SUT.getX(), 1);
    }

    @Test
    void setY() {
        SUT.setY(1);
        assertEquals(SUT.getY(), 1);
    }

    @Test
    void getCharacter() {
        SUT.setCharacter(1);
        assertEquals(SUT.getCharacter(), 1);
    }

    @Test
    void setCharacter() {
        SUT.setCharacter(1);
        assertEquals(SUT.getCharacter(), 1);
    }

    @Test
    void getBoardId() {
        SUT.setBoardId(1);
        assertEquals(SUT.getBoardId(), 1);
    }

    @Test
    void setBoardId() {
        SUT.setBoardId(1);
        assertEquals(SUT.getBoardId(), 1);
    }
}