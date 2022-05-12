package edu.uob;

import edu.uob.GameException.GameException;

import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

public class GameTokenizer {
    private final String[] command;
    private final String playerName;

    public GameTokenizer(String command) throws GameException.CommandException {
        if(command.equals("")) throw new GameException.CommandException("Empty Command");
        if(!command.contains(":"))throw new GameException.CommandException("Please give player name");
        this.playerName = command.split(":",2)[0];
        checkPlayerName(playerName);
        this.command = command.split(":",2)[1].toLowerCase().trim().split(" ");
    }

    public ArrayList<String> getActions(Set<String> triggers) throws GameException.CommandException {
        ArrayList<String> actions = new ArrayList<>();
        for (String word:command) {
            if(triggers.contains(word)){
                actions.add(word);
            }
        }
        if(actions.size() > 1){
            throw new GameException.CommandException("Too many triggers in command");
        }
        return actions;
    }

    public ArrayList<String> getSubjects(Set<String> subjects){
        ArrayList<String> entities = new ArrayList<>();
        for (String word:command) {
            if(subjects.contains(word)){
                entities.add(word);
            }
        }
        return entities;
    }

    public void checkPlayerName(String playerName) throws GameException.CommandException {
        String pattern = "^[A-Za-z' \\-]*$";
        if(! Pattern.matches(pattern, playerName)){
            throw new GameException.CommandException("Invalid playerName");
        }
    }
    public String getPlayerName(){
        return playerName;
    }
}
