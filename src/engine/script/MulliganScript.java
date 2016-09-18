package engine.script;

import engine.Node;

/**
 * Created by Wes on 9/18/2016.
 */
public class MulliganScript implements Script {
    @Override
    public Node connect(Node root) {
        Node selectCardsToReturn = new Node("Cards to Return");
        Node returnCard[] = new Node[5];
        for(int x = 0; x < 5; x++) {
            returnCard[x] = new Node("Return card " +(x+1));
            returnCard[x].add(selectCardsToReturn);
        }
        Node noMoreReturns = new Node("No More Returning");
        Node doneReturningCards = new Node("Finished Returning Cards");
        Node doneDrawingCards = new Node("Done Drawing Cards After Mulligan");

        selectCardsToReturn.add(returnCard);
        selectCardsToReturn.add(noMoreReturns);
        noMoreReturns.add(doneReturningCards);
        root.add(selectCardsToReturn);

        returnCard[0].giveEffect(() -> selectCardsToReturn.remove(returnCard[0]));
        returnCard[1].giveEffect(() -> selectCardsToReturn.remove(returnCard[1]));
        returnCard[2].giveEffect(() -> selectCardsToReturn.remove(returnCard[2]));
        returnCard[3].giveEffect(() -> selectCardsToReturn.remove(returnCard[3]));
        returnCard[4].giveEffect(() -> selectCardsToReturn.remove(returnCard[4]));
        noMoreReturns.giveEffect(() -> {
            int numberOfDraws = 6 - selectCardsToReturn.getChildren().size();

            if(numberOfDraws == 0)
            {
                doneReturningCards.add(doneDrawingCards);
                return;
            }

            Node[] drawCards = new Node[numberOfDraws];

            for(int x=0; x < numberOfDraws; x++)
            {
                drawCards[x] = new Node("Drawing "+(x+1)+"/"+numberOfDraws);
            }

            doneReturningCards.add(drawCards[0]);
            for(int x=0; x < numberOfDraws - 1; x++)
            {
                drawCards[x].add(drawCards[x+1]);
            }
            drawCards[numberOfDraws - 1].add(doneDrawingCards);
        });

        return doneDrawingCards;
    }
}
