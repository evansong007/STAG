package edu.uob;

import edu.uob.entity.*;
import edu.uob.entity.Character;

public class GameConsumeVisitor extends GameVisitor {
    private final Player player;

    private final Location currentLocation;

    private final Location storeroom;

    public GameConsumeVisitor(GameModel model, String currentPlayer, GameAction action) {
        super(model, currentPlayer, action);
        this.player = model.getPlayer(currentPlayer);
        this.currentLocation = model.getLocation(player.getCurrentLocation());
        this.storeroom = model.getStoreroom();
    }


    @Override
    public void interactWithEntity(Artefact artefact) {
        this.player.dropArtefect(artefact.getName());
        this.currentLocation.removeEntity(artefact.getName());
        this.storeroom.addEntity(artefact);

    }

    @Override
    public void interactWithEntity(Character character) {
        this.storeroom.addEntity(character);
        this.currentLocation.removeEntity(currentPlayer);

    }

    @Override
    public void interactWithEntity(Furniture furniture) {
        this.storeroom.addEntity(furniture);
        this.currentLocation.removeEntity(furniture.getName());
    }

    @Override
    public void interactWithEntity(Location location) {
        this.currentLocation.getDestinations().remove(location.getName());
    }

    @Override
    public void interactWithEntity(Player player) {
        player.descreaseHealth();
    }

}
