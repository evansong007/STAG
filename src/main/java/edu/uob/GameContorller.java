package edu.uob;

import java.util.ArrayList;

public class GameContorller {
    private GameModel model;

    private ArrayList<String> tokens;

    public GameContorller(GameModel model,String command){
        this.model = model;
        GameTokenizer tokenizer = new GameTokenizer(command);
        tokens = tokenizer.getTokens();
    }

    public Boolean isValidCommand(){


        return false;
    }

}
