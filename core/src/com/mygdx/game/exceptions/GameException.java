package com.mygdx.game.exceptions;

/**
 * Created by Sergey on 29.01.2017.
 */
public class GameException extends Exception {
    public GameException(String message) throws Exception {
        throw new Exception(message);
    }
}
