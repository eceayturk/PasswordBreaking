package passwordbreaking;

import java.util.*;

class Function {
    Node root;

    public int insert(Node root, ArrayList<Node> nodeAdd, int parentIdentity) { //inserting Nodes to m-Arr Tree
        if (root == null) {
            return 0;
        } else if (root.children == null) {
            root.children = new ArrayList<Node>();
        } else if (root.id == parentIdentity) {
            int size = nodeAdd.size();
            for (int i = 0; i < size; i++) {
                Node node = nodeAdd.get(i);
                node.parent = root;
                root.children.add(node);
            }
            return 1;
        } else {
            int size = root.children.size();
            for (int j = 0; j < size; j++) {
                int flag = insert(root.children.get(j), nodeAdd, parentIdentity);
                if (flag == 1) {
                    return 1;
                }

            }
        }
        return -1;
    }

    public void treeTraverse(Node root) { //this part traversing tree
        if (root == null) {
            return;
        }

        System.out.println(root.data + " " + root.id);
        for (Node child : root.children) {
            treeTraverse(child); //recursion
        }

    }


}

