package edu.uob;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeMap;

public class GameBuilder {
    public File actionsFile;
    public File entitiesFile;

    public GameModel model;

    public GameBuilder(File entitiesFile,File actionsFile){
        this.actionsFile = actionsFile;
        this.entitiesFile = entitiesFile;
        this.model = new GameModel();
    }

    //reader actions form Xml File
    public void importActions() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(actionsFile);
        Element root = document.getDocumentElement();
        NodeList actions = root.getElementsByTagName("actions");
        for(int i = 0;i < actions.getLength();i++){
            Element actionXML = (Element)actions.item(i);
            
            NodeList triggers = actionXML.getElementsByTagName("triggers");
            for(int j = 0;j < triggers.getLength();j++){
                String trigger = triggers.item(j).getTextContent();
                GameAction action = new GameAction(trigger);

                //add subjects to action
                NodeList subjects = actionXML.getElementsByTagName("subjects");
                for(int m = 0;m < subjects.getLength();m++){
                    String item = subjects.item(m).getTextContent();
                    action.addSubject(item);
                }

                //add consumed to action
                NodeList consumed = actionXML.getElementsByTagName("consumed");
                for(int m = 0;m < consumed.getLength();m++){
                    String item = consumed.item(m).getTextContent();
                    action.addConsumed(item);
                }

                //add produced to action
                NodeList produced = actionXML.getElementsByTagName("produced");
                for(int m = 0;m < produced.getLength();m++){
                    String item = produced.item(m).getTextContent();
                    action.addProduced(item);
                }

                //set narration to action
                String narration = actionXML.getElementsByTagName("narration").item(0).getTextContent();
                action.setNarration(narration);

                model.addAction(action);
            }





        }
    }


}
