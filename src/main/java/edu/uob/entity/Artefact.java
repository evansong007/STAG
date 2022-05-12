package edu.uob.entity;

import edu.uob.GameVisitor;

public class Artefact extends GameEntity {
    public Artefact(String name, String description) {
        super(name, description);
    }

    @Override
    public void accept(GameVisitor vistor) {
        vistor.interactWithEntity(this);
    }

}
