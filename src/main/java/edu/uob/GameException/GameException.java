package edu.uob.GameException;

import java.io.Serial;

public class GameException extends Exception {
    @Serial
    private static final long serialVersionUID = 1801625250791334830L;

    public GameException(String message){
        super(message);
    }

    public static class CommandException extends GameException{

        @Serial
        private static final long serialVersionUID = 7981967213598512634L;

        public CommandException(String message) {
            super("Warning:"+ message);
        }
    }

}
