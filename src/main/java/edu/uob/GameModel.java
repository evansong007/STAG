package edu.uob;

import edu.uob.entity.Location;
import edu.uob.entity.Player;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameModel {
    private final HashMap<String, HashSet<GameAction>> actionMap;
    private final HashMap<String, Location> locationsMap;
    private final HashMap<String,Player> players;
    private String startLocation;
    private final Set<String> triggerList;
    private final Set<String> subjectList;

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
        triggerList.add("health");
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


    public HashMap<String,Location> getLocationsMap(){return locationsMap;}

    public void addPlayer(Player player){
        players.put(player.getName(),player);
    }

    public void addTrigger(String trigger){
        triggerList.add(trigger);
    }

    public void addSubject(String subject){
        subjectList.add(subject);
    }

    public Set<String> getTriggerList(){
        return triggerList;
    }

    public Set<String> getSubjectList(){
        return subjectList;
    }

    public HashSet<GameAction> getAction(String trigger){
        return actionMap.get(trigger);
    }

    public void setStartLocation(String location){
        this.startLocation = location;
    }

    public Player getPlayer(String player){
        return players.get(player);
    }

    public Location getLocation(String location){
        return locationsMap.get(location);
    }

    public String getStartLocation(){
        return startLocation;
    }

    public HashMap<String,Player> getPlayers(){return players;}

    public Location getStroeroom(){
        return locationsMap.get("storeroom");
    }

}
