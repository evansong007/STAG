package edu.uob;

import edu.uob.entity.Location;
import edu.uob.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameModel {
    private HashMap<String, HashSet<GameAction>> actionMap;
    private HashMap<String, Location> locationsMap;
    private HashMap<String,Player> players;
    private Set<String> triggerList;
    private Set<String> subjectList;
    private String currentPlayer;

    public GameModel(){
        this.actionMap = new HashMap<>();
        this.locationsMap = new HashMap<>();
        this.players = new HashMap<>();
        this.subjectList = new HashSet<>();
        this.triggerList = new HashSet<>();
        triggerList.add("inventory");
        triggerList.add("inv");
        triggerList.add("get");
        triggerList.add("drop");
        triggerList.add("goto");
        triggerList.add("look");
    }

    public void addAction(GameAction action){
        if(actionMap.containsKey(action.getTrigger())){
            actionMap.get(action.getTrigger()).add(action);
        }else {
            HashSet<GameAction> actionHashSet = new HashSet<>();
            actionHashSet.add(action);
            actionMap.put(action.getTrigger(),actionHashSet);
        }
    }

    public void addLocation(Location location){
        locationsMap.put(location.getName(),location);
    }

    public HashMap<String,HashSet<GameAction>> getActionMap(){
        return actionMap;
    }

    public HashMap<String,Location> getLocationsMap(){return locationsMap;}

    public void addPlayer(Player player){
        players.put(player.getName(),player);
    }

    public void addTrigger(String trigger){
        triggerList.add(trigger);
    }

    public void addsubject(String subject){
        subjectList.add(subject);
    }

    public void setCurrentPlayer(String currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public String getCurrentPlayer(){
        return currentPlayer;
    }

    public Set<String> getTriggerList(){
        return triggerList;
    }

    public Set<String> getSubjectList(){
        return subjectList;
    }
}
