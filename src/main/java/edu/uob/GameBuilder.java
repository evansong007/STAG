package edu.uob;

import com.alexmerz.graphviz.ParseException;
import com.alexmerz.graphviz.Parser;
import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;
import edu.uob.entity.*;
import edu.uob.entity.Character;
import org.w3c.dom.*;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameBuilder {
    public final File actionsFile;
    public final File entitiesFile;

    public final GameModel model;

    public GameBuilder(File entitiesFile, File actionsFile) {
        this.actionsFile = actionsFile;
        this.entitiesFile = entitiesFile;
        this.model = new GameModel();
    }

    //reader actions form XML File
    public void importActions() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(actionsFile);
            DocumentTraversal map = (DocumentTraversal) document;


            MyFilter filter = new MyFilter();
            NodeIterator it = map.createNodeIterator(document.getDocumentElement(),
                    NodeFilter.SHOW_ELEMENT, filter, true);

            for (Node node = it.nextNode(); node != null;
                 node = it.nextNode()) {
                Element action = (Element) node;
                makeAction(action, model);
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            System.out.println(e.getMessage());
        }


    }

    public static class MyFilter implements NodeFilter {

        @Override
        public short acceptNode(Node thisNode) {
            if (thisNode.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) thisNode;
                String nodeName = e.getNodeName();
                if ("action".equals(nodeName)) {
                    return NodeFilter.FILTER_ACCEPT;
                }
            }
            return NodeFilter.FILTER_REJECT;
        }
    }

    public void makeAction(Element action, GameModel model) {
        Element triggers = (Element) action.getElementsByTagName("triggers").item(0);
        NodeList keywords = triggers.getElementsByTagName("keyword");

        for (int i = 0; i < keywords.getLength(); i++) {
            String keyword = keywords.item(i).getTextContent().toLowerCase();
            GameAction movement = new GameAction();
            movement.setTrigger(keyword);
            model.addTrigger(keyword);

            //add subject to action
            Element subjects = (Element) action.getElementsByTagName("subjects").item(0);
            NodeList entities = subjects.getElementsByTagName("entity");
            for (int m = 0; m < entities.getLength(); m++) {
                String entity = entities.item(m).getTextContent().toLowerCase();
                model.addSubject(entity);
                movement.addSubject(entity);
            }

            //add consumed to action
            Element consumed = (Element) action.getElementsByTagName("consumed").item(0);
            NodeList consumables = consumed.getElementsByTagName("entity");
            for (int m = 0; m < consumables.getLength(); m++) {
                String consumable = consumables.item(m).getTextContent().toLowerCase();
                movement.addConsumed(consumable);
            }

            //add produced to action
            Element produced = (Element) action.getElementsByTagName("produced").item(0);
            NodeList produces = produced.getElementsByTagName("entity");
            for (int m = 0; m < produces.getLength(); m++) {
                String produce = produces.item(m).getTextContent().toLowerCase();
                movement.addProduced(produce);
            }

            //set narration to action
            String narration = action.getElementsByTagName("narration").item(0).getTextContent().toLowerCase();
            movement.setNarration(narration);

            model.addAction(movement);
        }
    }

    public void importEntities() {
        try {
            Parser parser = new Parser();
            FileReader reader = new FileReader(entitiesFile);
            parser.parse(reader);
            Graph wholeDocument = parser.getGraphs().get(0);
            ArrayList<Graph> sections = wholeDocument.getSubgraphs();
            ArrayList<Graph> locations = sections.get(0).getSubgraphs();
            Graph firstLocation = locations.get(0);
            String Name = firstLocation.getNodes(false).get(0).getId().getId().toLowerCase();
            model.setStartLocation(Name);

            //read location form .dot
            for (Graph location : locations) {
                com.alexmerz.graphviz.objects.Node locationDetails = location.getNodes(false).get(0);
                // read name and description of location
                String locationName = locationDetails.getId().getId().toLowerCase();
                model.addSubject(locationName);
                String description = locationDetails.getAttribute("description").toLowerCase();
                Location locationMap = new Location(locationName, description);
                model.addLocation(locationMap);
                ArrayList<Graph> entityList = location.getSubgraphs();
                for (Graph entity : entityList) {
                    readEntityFormLocation(locationMap, entity);
                }
            }

            ArrayList<Edge> paths = sections.get(1).getEdges();
            for (Edge edge : paths) {
                readPathOfLocation(edge);
            }
        } catch (FileNotFoundException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    //read entity in the location
    public void readEntityFormLocation(Location location, Graph entity) {
        ArrayList<com.alexmerz.graphviz.objects.Node> nodes = entity.getNodes(false);
        if (nodes.isEmpty()) {
            return;
        }
        String TypeOfEntity = entity.getId().getId();
        for (com.alexmerz.graphviz.objects.Node node : nodes) {
            String entityName = node.getId().getId().toLowerCase();
            model.addSubject(entityName);
            String description = node.getAttribute("description").toLowerCase();
            switch (TypeOfEntity) {
                case "artefacts" -> location.addEntity(new Artefact(entityName, description));
                case "furniture" -> location.addEntity(new Furniture(entityName, description));
                case "characters" -> location.addEntity(new Character(entityName, description));
            }
        }

    }

    //read path of location
    public void readPathOfLocation(Edge edge) {
        com.alexmerz.graphviz.objects.Node fromLocation = edge.getSource().getNode();
        String fromName = fromLocation.getId().getId().toLowerCase();
        com.alexmerz.graphviz.objects.Node toLocation = edge.getTarget().getNode();
        String toName = toLocation.getId().getId().toLowerCase();
        Location location = model.getLocationsMap().get(fromName);
        location.addDestination(toName);
    }

    public GameModel getModel() {
        return model;
    }
}



