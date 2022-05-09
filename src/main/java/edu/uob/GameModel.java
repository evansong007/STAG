package edu.uob;

import edu.uob.entity.Location;
import edu.uob.entity.Player;

import java.util.HashMap;
import java.util.HashSet;

public class GameModel {
    private HashMap<String, HashSet<GameAction>> actionMap;
    private HashMap<String, Location> locationsMap;

    private HashSet<String> triggerList;

    private HashSet<String> actionList;

    public HashSet<Player> players;

    public GameModel(){
        this.actionMap = new HashMap<>();
        this.locationsMap = new HashMap<>();
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
}
