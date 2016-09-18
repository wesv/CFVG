package engine.script;

import engine.Node;

/**
 * Created by Wes on 9/18/2016.
 */
public class CheckDeckScript implements Script {

    @Override
    public Node connect(Node root) {
        Node checkingDeck = new Node("Checking Deck");
        Node checkDeckSize = new Node("Check Deck Size");
        Node checkDeckCardCopies = new Node("Checking Number of Cards");
        Node checkSentinals = new Node("Checking Sentinals");
        Node checkTriggerCount = new Node("Checking Overall Trigger Count");
        Node checkNumHeal = new Node("Checking Heal Trigger Count");
        Node deckBuildingError = new Node("Deck is not valid");
        Node endOfScript = new Node("End of Deck Buidling Checks");


        checkDeckSize.giveEffect(() -> System.out.println("Deck Size A-Okay"));
        checkingDeck.giveEffect(() -> System.out.println("Starting Check Deck"));
        checkDeckCardCopies.giveEffect(() -> System.out.println("Not too many copies of any cards"));
        checkSentinals.giveEffect(() -> System.out.println("Good Number of Sentinals"));
        checkTriggerCount.giveEffect(() -> System.out.println("You have 16 Triggers"));
        checkNumHeal.giveEffect(() -> System.out.println("Good Number of Heals"));
        deckBuildingError.giveEffect(() -> System.out.println("Your Deck had an invalid deck rule"));
        endOfScript.giveEffect(() -> System.out.println("End of Deck Building Script"));

        root.add(checkingDeck);
        checkingDeck.add(checkDeckSize);
        checkDeckSize.add(checkDeckCardCopies, deckBuildingError);
        checkDeckCardCopies.add(checkSentinals, deckBuildingError);
        checkSentinals.add(checkTriggerCount, deckBuildingError);
        checkTriggerCount.add(checkNumHeal, deckBuildingError);
        checkNumHeal.add(endOfScript, deckBuildingError);
        deckBuildingError.add(endOfScript);

        return endOfScript;
    }
}
