package passwordbreaking;

import java.util.*;

public class Tree {

    Node root = new Node("root");

    Tree(int maxLength) {
        Node.maxNrOfChildren = maxLength;
        root.parent = null;
    }

    void traverseMTree(Node root) { //traverse all tree
        System.out.println(root.name);
        int childSize = root.children.size();
        if (childSize != 0)
            for (Node ch : root.children)
                traverseMTree(ch); //recursive
    }

}
