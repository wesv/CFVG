package engine;
import java.util.ArrayList;

/**
 * Created by Wes on 9/16/2016.
 */
public class Graph {
    public static void main(String[] args) {
        Graph start = new Graph();
        java.util.Scanner in = new java.util.Scanner(System.in);
        Node currentNode = start.createBaseRules();


        while(currentNode.doesntEqual(Node.NULL_NODE)) {
            ArrayList<Node> options = currentNode.getChildren();

            System.out.println("Current Node: " + currentNode.name());
            currentNode.resolveEffect();
            for (int x = 0; x < options.size(); x++) {
                System.out.println(x + ") " + options.get(x).name());
            }
            //System.out.println(options.size() + ") Go Back");

            int choice = in.nextInt();

            if (choice == options.size()) {
                currentNode = currentNode.parent();
            } else {
                options.get(choice).setParent(currentNode);
                currentNode = options.get(choice);
            }
        }
    }

    /*

    Creates the base rules and returning the root node

     */
    public Node createBaseRules() {
        Node startOfGame = new Node("Start the Game");
        Node deckBuilding = new engine.script.CheckDeckScript().connect(startOfGame);
        Node prepareGame = new engine.script.PrepareGameScript().connect(deckBuilding);
        return startOfGame;
    }
}
