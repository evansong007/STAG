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
    void basicactionTest() throws ParserConfigurationException, IOException, SAXException, ParseException {
        File entitiesFile = Paths.get("config/basic-entities.dot").toAbsolutePath().toFile();
        File actionsFile = Paths.get("config/basic-actions.xml").toAbsolutePath().toFile();
        basicBuilder = new GameBuilder(entitiesFile,actionsFile);
        basicBuilder.importActions();
        basicBuilder.importEntities();
        System.out.println("hello\n");
    }

    @Test
    void extendedActionTest() throws ParserConfigurationException, IOException, SAXException, ParseException {
        File extendedEntitiesFile = Paths.get("config/extended-entities.dot").toAbsolutePath().toFile();
        File extendedActionsFile = Paths.get("config/extended-actions.xml").toAbsolutePath().toFile();
        extendedBuilder = new GameBuilder(extendedEntitiesFile,extendedActionsFile);
        extendedBuilder.importActions();
        extendedBuilder.importEntities();
        System.out.println("hello\n");
        System.out.println("hello\n");
    }

    @Test
    void avad(){
        HashSet<Artefact> abc = new HashSet<>();
        Artefact ooo = new Artefact("agc","ppp");
        Artefact ppp = new Artefact("agc","ppp");
        abc.add(ooo);
        abc.add(ppp);
        System.out.println(abc);
    }
}
