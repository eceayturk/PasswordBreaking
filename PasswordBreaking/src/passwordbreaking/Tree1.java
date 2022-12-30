package com.company;


public class Tree1<String> {

    private Node1<String> root;

    public Tree1(Node1<String> root) {
        this.root = root;
    }


    public boolean exists(String key) {
        return find(root, key);
    }

    private boolean find(Node1<String> node, String keyNode) {
        boolean res = false;
        if (node.getData().equals(keyNode))
            return true;

        else {
            for (Node1<String> child : node.getChildren())
                if (find(child, keyNode))
                    res = true;
        }

        return res;
    }


}
