package edu.uob;

import com.alexmerz.graphviz.ParseException;
import edu.uob.GameException.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

// PLEASE READ:
// The tests in this file will fail by default for a template skeleton, your job is to pass them
// and maybe write some more, read up on how to write tests at
// https://junit.org/junit5/docs/current/user-guide/#writing-tests
final class BasicCommandTests {

  private GameServer server;

  // Make a new server for every @Test (i.e. this method runs before every @Test test case)
  @BeforeEach
  void setup() {
      File entitiesFile = Paths.get("config/basic-entities.dot").toAbsolutePath().toFile();
      File actionsFile = Paths.get("config/basic-actions.xml").toAbsolutePath().toFile();
      server = new GameServer(entitiesFile, actionsFile);
  }

  // Test to spawn a new server and send a simple "look" command
  @Test
  void testLookingAroundStartLocation(){
    String response = server.handleCommand("player 1: look").toLowerCase();

    assertTrue(response.contains("empty room"), "Did not see description of room in response to look");
    assertTrue(response.contains("magic potion"), "Did not see description of artifacts in response to look");
    assertTrue(response.contains("wooden trapdoor"), "Did not see description of furniture in response to look");
  }

  // Add more unit tests or integration tests here.
  @Test
  void testinventory(){

    String response = server.handleCommand("haha: look").toLowerCase();
    System.out.println(response);
    String response1 = server.handleCommand("haha:get potion").toLowerCase();
    System.out.println(response1);
    String response2 = server.handleCommand("haha:goto forest").toLowerCase();
    System.out.println(response2);
    String response3 = server.handleCommand("haha:get key").toLowerCase();
    System.out.println(response3);
    String response4 = server.handleCommand("haha:goto cabin").toLowerCase();
    System.out.println(response4);
    String response5 = server.handleCommand("haha:open key").toLowerCase();
    System.out.println(response5);
    String response6 = server.handleCommand("haha:goto cellar").toLowerCase();
    System.out.println(response6);
    String response7 = server.handleCommand("haha:hit elf").toLowerCase();
    System.out.println(response7);
    String response8 = server.handleCommand("haha:look").toLowerCase();
    System.out.println(response8);
    String response9 = server.handleCommand("haha:inv").toLowerCase();
    System.out.println(response9);
    String response10 = server.handleCommand("haha:goto cabin").toLowerCase();
    System.out.println(response10);


  }

}
