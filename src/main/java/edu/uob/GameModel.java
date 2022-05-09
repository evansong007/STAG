package edu.uob;

import edu.uob.entity.Location;
import edu.uob.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameModel {
    private HashMap<String, HashSet<GameAction>> actionMap;
    private HashMap<String, Location> locationsMap;

    private Set<String> triggerList;

    private Set<String> subjectList;

    public HashSet<Player> players;

    public GameModel(){
        this.actionMap = new HashMap<>();
        this.locationsMap = new HashMap<>();
        this.players = new HashSet<>();
        this.subjectList = new HashSet<>();
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
        players.add(player);
    }

    public void setTrigger(){
        triggerList = actionMap.keySet();
    }

    public void addsubject(String subject){
        subjectList.add(subject);
    }
}
