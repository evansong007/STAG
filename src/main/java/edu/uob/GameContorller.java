package edu.uob;

import edu.uob.GameException.GameException;
import edu.uob.entity.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public class GameContorller {
    private GameModel model;

    private String player;
    private ArrayList<String> actionsOfCommand;

    private ArrayList<String> subjectOfCommand;


    public GameContorller(GameModel model,String command){
        this.model = model;
        GameTokenizer tokenizer = new GameTokenizer(command);
        this.player = tokenizer.getPlayerName();
        this.actionsOfCommand = tokenizer.getActions(model.getTriggerList());
        this.subjectOfCommand = tokenizer.getSubjects(model.getSubjectList());

    }

    public String executeCommand() throws GameException.CommandException {
        checkPlayer();
        if(actionsOfCommand.isEmpty()){
            throw new GameException.CommandException("No valid action in command");
        }
        Player currentPlayer = model.getPlayer(player);
        String trigger = actionsOfCommand.get(0);
        switch (trigger){
            case "inventory":
            case "inv":
                return executeInventory(currentPlayer);
            case "look":
                return executeLook(currentPlayer);
            case "health":
                return executeHealth(currentPlayer);
            case "get":
                return executeGet(currentPlayer);
            case "drop":
                return executeDrop(currentPlayer);
            case "goto":
                return executeGoto(currentPlayer);
            default:
                return "haha";
        }
    }

    public void checkPlayer(){
        if(!model.getPlayers().containsKey(this.player)){
            Player player = new Player(this.player,"A student of Bristol");
            player.setCurrentLocation(model.getStartLocation());
            model.addPlayer(player);
        }
    }

    public String executeInventory(Player currentPlayer){
        String result = "Your inventory have these :";
        if(currentPlayer.getInventory().isEmpty()){
            return "Your inventory is empty";
        }else {
            return result + currentPlayer.getInventory().keySet();
        }
    }

    public String executeLook(Player currentPlayer){
        String result = "Your are in : ";

        Location currentLocation = model.getLocation(currentPlayer.getCurrentLocation());
        String entities = currentLocation.getEntities();
        String path = currentLocation.getDestinations().toString();
        return result + currentLocation.getName()+"\nYou can see : "+entities +"\nYou can go : "+path;
    }

    public String executeHealth(Player currentPlayer){
        String result = "Your health status is : ";
        return result + currentPlayer.getHealth();
    }

    public String executeGet(Player currentPlayer) throws GameException.CommandException {
        String result = "You have gained : ";
        Location currentLocation = model.getLocation(currentPlayer.getCurrentLocation());
        int numberOfCanBeGet = 0;
        String target = "";
        for (String subject: subjectOfCommand) {
            if(currentLocation.getArtefectList().containsKey(subject)){
                numberOfCanBeGet += 1;
                target = subject;
            }
        }
        if(numberOfCanBeGet == 0){
            throw new GameException.CommandException("No Valid entity can obtain");
        }else if(numberOfCanBeGet == 1){
            Artefact entity = currentLocation.getArtefect(target);
            currentLocation.removeArtefect(entity.getName());
            currentPlayer.getArtefect(entity);
        }else {
            throw new GameException.CommandException("Ambiguous Command");
        }

        return result + target;
    }

    public String executeDrop(Player currentPlayer) throws GameException.CommandException {
        String result = "You have droped : ";
        Location currentLocation = model.getLocation(currentPlayer.getCurrentLocation());
        int numberOfCanBeGet = 0;
        String target = "";
        for (String subject: subjectOfCommand) {
            if(currentPlayer.getInventory().containsKey(subject)){
                numberOfCanBeGet += 1;
                target = subject;
            }
        }
        if(numberOfCanBeGet == 0){
            throw new GameException.CommandException("No Valid entity can drop");
        }else if(numberOfCanBeGet == 1){
            Artefact entity = currentPlayer.dropArtefect(target);
            currentLocation.addArtefact(entity);

        }else {
            throw new GameException.CommandException("Ambiguous Command");
        }

        return result + target;
    }

    public String executeGoto(Player currentPlayer) throws GameException.CommandException {
        String result = "You have move to  : ";
        Location currentLocation = model.getLocation(currentPlayer.getCurrentLocation());
        int numberOfCanBeGet = 0;
        String target = "";
        for (String subject: subjectOfCommand) {
            if(currentLocation.getDestinations().contains(subject)){
                numberOfCanBeGet += 1;
                target = subject;
            }
        }
        if(numberOfCanBeGet == 0){
            throw new GameException.CommandException("No Valid entity can obtain");
        }else if(numberOfCanBeGet == 1){
            currentLocation.removePlayer(currentPlayer.getName());
            currentPlayer.setCurrentLocation(target);
            model.getLocation(target).addPlayer(currentPlayer);
        }else {
            throw new GameException.CommandException("Ambiguous Command");
        }

        return result + target;
    }

    public String executeAction(Player currentPlayer,String trigger){
        HashSet<GameAction> actions = model.getAction(trigger);
        ArrayList<GameAction> executableActions = new ArrayList<>();
        for (GameAction action: actions) {

        }

        return "hahah";
    }
}
