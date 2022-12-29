package com.company;

import java.util.ArrayList;
import java.util.List;


public class Node<String> {
    private String data;
    private List<Node<String>> children;
    private Node<String> parent;

    public Node(String data) {
        this.data = data;
        this.children = new ArrayList<Node<String>>();
    }


    public Node(Node<String> node) {
        this.data = node.getData();
        children = new ArrayList<Node<String>>();
    }

    public void addChild(Node<String> child) {
        child.setParent(this);
        children.add(child);
    }


    public List<Node<String>> getChildren() {
        return this.children;
    }


    public String getData() {
        return this.data;
    }


    public void setParent(Node<String> parent) {
        this.parent = parent;
    }


    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof Node) {
            if (((Node<?>) obj).getData().equals(this.data))
                return true;
        }

        return false;
    }

}
