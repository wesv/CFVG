package engine.ui.element;

import engine.Node;
import engine.script.Script;

/**
 * Created by Wes on 9/18/2016.
 */
public class TriggerIcon implements Script {

    public static final int NO_TRIGGER = 0;
    public static final int CRITICAL_TRIGGER = 1;
    public static final int STAND_TRIGGER = 2;
    public static final int DRAW_TRIGGER = 3;
    public static final int HEAL_TRIGGER = 4;

    private int trigger;

    public TriggerIcon(int triggerNumber)
    {
        if(triggerNumber < 0 || triggerNumber > 4)
            throw new IllegalArgumentException("Trigger number (" + triggerNumber + ") given is not a valid trigger.");

        this.trigger = triggerNumber;
    }

    @Override
    public Node connect(Node startingPoint) {
        Node triggerEffect = new Node("Activating Trigger Effect");
        Node gainPower = new Node("Power +5000");
          Node selectedUnit = new Node("Unit Selected");  //TODO add a list of all possible units to select
        Node resolveTrigger = new Node("Resolving Trigger Effect");
        Node addCrit = new Node("Adding a Crit");
        Node addStand = new Node("Standing a Unit");
        Node addDraw = new Node("Add Draw");
        Node addHeal = new Node("Add Heal");

        switch(trigger) {
            //TODO connect and resolve trigger effects. Return the onde with the action
        }

        //TODO connect triggers so that I can resolve the power OR the trigger effect first

        return addCrit;
    }

    public String toString() {
        switch(trigger) {
            case NO_TRIGGER:
                return "";
            case CRITICAL_TRIGGER:
                return "Critical Trigger";
            case STAND_TRIGGER:
                return "Stand Trigger";
            case DRAW_TRIGGER:
                return "Draw Trigger";
            case HEAL_TRIGGER:
                return "Heal Trigger";
            default:
                return "TRIGGER NOT RECOGNIZED";
        }
    }
}
