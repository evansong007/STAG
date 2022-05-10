package edu.uob;

import edu.uob.GameException.GameException;
import edu.uob.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;

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

    public String executeCommand() throws GameException.CommandException {
        if(actionsOfCommand.isEmpty()){
            throw new GameException.CommandException("No valid action in command");
        }
        String trigger = actionsOfCommand.get(0);
        switch (trigger){
            case "inventory":
            case "inv":
                return executeInventory();

            case "look":
                return "haha";
            case "health":
                return "haha";
            case "get":
                return "haha";
            case "drop":
                return "haha";
            case "goto":
                return "haha";
            default:
                return "haha";
        }

    }

    public Boolean isValidAction(String trigger){
        HashSet<GameAction> actions = model.getAction(trigger);
        String currnePlayer = model.getCurrentPlayer();
        return false;
    }

    public String executeInventory(){
        String result = "Your inventory have these :";
        Player currnePlayer = model.getPlayer(model.getCurrentPlayer());
        if(currnePlayer.getInventory().isEmpty()){
            return "Your inventory is empty";
        }else {
            return result + currnePlayer.getInventory().keySet();
        }
    }

    public String excuteLook(){
        String result = "Your inventory have these :";

        return result;
    }
}
