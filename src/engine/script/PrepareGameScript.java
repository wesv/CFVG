package engine.script;

import engine.Node;

/**
 * Created by Wes on 9/18/2016.
 */
public class PrepareGameScript implements Script {
    @Override
    public Node connect(Node root) {
        Node startPreparations = new Node("Start Preparations");
        Node chooseStartingVanguard = new Node("Choose Starting Vanguard");
        Node openDeck = new Node("Open Deck for Starting Vanguard");
        Node placeOnVGCircle = new Node("Place on VG Cirlce");
        Node[] listOfGradeZeros = new Node[17]; // TEMP NUMBER
        for(int x = 0; x < 17; x++) listOfGradeZeros[x] = new Node("Grade 0 #" +x);
        Node otherChoice = new Node("Invalid Choice");
        Node shuffleDeck = new Node("Shuffling Deck");
        Node shuffleOpponentsDeck = new Node("Shuffling Opponents Deck");
        Node determineFirstTurnPlayer = new Node("Determining First Turn Player");
        Node[] drawHand = new Node[5];
        for(int x=0; x < 5; x++) drawHand[x] = new Node("Drawing Card " + (1+x));
        Node mulligan = new MulliganScript().connect(drawHand[4]);
        Node readyToPlay = new Node("Ready to Play");

        root.add(startPreparations);
        startPreparations.add(chooseStartingVanguard);
        chooseStartingVanguard.add(openDeck);
        openDeck.add(listOfGradeZeros);
        openDeck.add(otherChoice);
        otherChoice.add(openDeck);
        for(int x = 0; x < listOfGradeZeros.length; x++) listOfGradeZeros[x].add(placeOnVGCircle);
        placeOnVGCircle.add(shuffleDeck);
        shuffleDeck.add(shuffleOpponentsDeck);
        shuffleOpponentsDeck.add(determineFirstTurnPlayer);
        determineFirstTurnPlayer.add(drawHand[0]);
        for(int x=0; x < drawHand.length - 1; x++) drawHand[x].add(drawHand[x+1]);

        mulligan.add(readyToPlay);
        return readyToPlay;
    }
}
