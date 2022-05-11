package edu.uob;

import edu.uob.entity.*;
import edu.uob.entity.Character;

public class GameConsumed extends GameVistor{
    private Player player;

    private Location currentLocation;

    private Location stroeroom;

    public GameConsumed(GameModel model, String currentPlayer, GameAction action) {
        super(model, currentPlayer, action);
        this.player = model.getPlayer(currentPlayer);
        this.currentLocation = model.getLocation(player.getCurrentLocation());
        this.stroeroom = model.getStroeroom();
    }

    @Override
    public void interactWithEntity(GameEntity gameEntity) {
        gameEntity.accept(this);
    }

    @Override
    public void interactWithEntity(Artefact artefact) {
        this.stroeroom.addEntity(artefact);
        this.player.dropArtefect(artefact.getName());
        this.currentLocation.removeEntity(artefact.getName());

    }

    @Override
    public void interactWithEntity(Character character) {
        this.stroeroom.addEntity(character);
        this.currentLocation.removeEntity(currentPlayer);

    }

    @Override
    public void interactWithEntity(Furniture furniture) {
        this.stroeroom.addEntity(furniture);
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
