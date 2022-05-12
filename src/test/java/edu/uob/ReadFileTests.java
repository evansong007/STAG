package edu.uob;

import com.alexmerz.graphviz.ParseException;
import edu.uob.entity.Artefact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;

public class ReadFileTests {
    private GameBuilder basicBuilder;
    private GameBuilder extendedBuilder;


    @Test
    void basicactionTest() {
        File entitiesFile = Paths.get("config/basic-entities.dot").toAbsolutePath().toFile();
        File actionsFile = Paths.get("config/basic-actions.xml").toAbsolutePath().toFile();
        basicBuilder = new GameBuilder(entitiesFile,actionsFile);
        basicBuilder.importActions();
        basicBuilder.importEntities();

    }

    @Test
    void extendedActionTest() {
        File extendedEntitiesFile = Paths.get("config/extended-entities.dot").toAbsolutePath().toFile();
        File extendedActionsFile = Paths.get("config/extended-actions.xml").toAbsolutePath().toFile();
        extendedBuilder = new GameBuilder(extendedEntitiesFile,extendedActionsFile);
        extendedBuilder.importActions();
        extendedBuilder.importEntities();
    }


}
