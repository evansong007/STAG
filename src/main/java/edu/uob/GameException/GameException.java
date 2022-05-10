package edu.uob.GameException;

public class GameException extends Exception {
    public GameException(String message){
        super(message);
    }

    public static class CommandException extends GameException{

        public CommandException(String message) {
            super(message);
        }
    }


}
