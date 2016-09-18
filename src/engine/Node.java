package engine;
import java.util.ArrayList;

/**
 * Created by Wes on 9/16/2016.
 */
public class Node {
    public static final Node NULL_NODE = new Node("NULL");

    private String name;
    private Callback effect;
    private ArrayList<Node> next;
    private Node parent;

    public Node(String nodeName) {
        name = nodeName;
        effect = null;
        next = new ArrayList<>(10);
        next.add(NULL_NODE);
    }

    public void add(Node child) {
        if(next.get(0).equals(NULL_NODE))
            next.set(0, child);
        else
            next.add(child);
    }

    public void add(Node... children) {
        if(next.get(0).equals(NULL_NODE))
            next.remove(0);

        for(Node child: children) {
            next.add(child);
        }
    }

    public void remove(Node nodeToRemove) {
        next.remove(nodeToRemove);
    }

    public ArrayList<Node> getChildren() {
        return next;
    }

    public void giveEffect(Callback nodeEffect) {
        effect = nodeEffect;
    }

    public void resolveEffect() {
        if(effect != null)
            effect.call();
    }

    public String name() {
        return name;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node parent() {
        if(parent == null)
            return NULL_NODE;
        return this.parent;
    }

    public boolean equals(Object o) {
        if(o instanceof Node) {
            return ((Node)o).name().equals(this.name());
        }
        return false;
    }

    public boolean doesntEqual(Object o) {
        return !equals(o);
    }

    public int hashCode() {
        return name.hashCode();
    }

}
