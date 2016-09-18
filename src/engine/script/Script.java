package engine.script;
import engine.Node;

/**
 * Created by Wes on 9/18/2016.
 */
public interface Script {
    /**
     * This method will take the starting point and connect it through a path of this script and return the last node of this script
     *
     * @param startingPoint the node that the script will attach itself to.
     * @return The last node of the script
     */
    Node connect(Node startingPoint);
}
