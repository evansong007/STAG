package edu.uob.entity;

import edu.uob.GameVistor;

public class Artefact extends GameEntity {
    public Artefact(String name, String description) {
        super(name, description);
    }

    @Override
    public void accept(GameVistor vistor) {

    }

}
