package edu.uob;

import java.util.ArrayList;

public class GameContorller {
    private GameModel model;

    private ArrayList<String> actionsOfCommand;

    private ArrayList<String> subjectOfCommand;


    public GameContorller(GameModel model,String command){
        this.model = model;
        GameTokenizer tokenizer = new GameTokenizer(command);
        model.setCurrentPlayer(tokenizer.getPlayer().getName());
        model.addPlayer(tokenizer.getPlayer());
        this.actionsOfCommand = tokenizer.getActions(model.getTriggerList());
        this.subjectOfCommand = tokenizer.getSubjects(model.getSubjectList());

    }

    public Boolean isValidCommand(){


        return false;
    }
}
