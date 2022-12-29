package passwordbreaking;

import java.util.*;

class Node {

    int id;
    String name;
    String data;
    Node parent;
    List<Node> children = new ArrayList<>();

    static int maxNrOfChildren;

    Node(String node) {
        name = node;
    }

    Node(String data, int id) {
        this.data = data;
        this.id = id;

    }


    void addChild(Node child) { // add child as node
        int limit = this.children.size();
        if (limit < maxNrOfChildren) {
            child.parent = this;
            this.children.add(child);
        }
    }
}