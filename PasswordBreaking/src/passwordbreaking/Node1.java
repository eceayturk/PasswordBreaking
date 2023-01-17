package passwordbreaking;

import java.util.ArrayList;
import java.util.List;


public class Node1<String> {
    private String data;
    private List<Node1<String>> children;
    private Node1<String> parent;

    public Node1(String data) {
        this.data = data;
        this.children = new ArrayList<Node1<String>>();
    }


    public Node1(Node1<String> node) {
        this.data = node.getData();
        children = new ArrayList<Node1<String>>();
    }

    public void addChild(Node1<String> child) {
        child.setParent(this);
        children.add(child);
    }


    public List<Node1<String>> getChildren() {
        return this.children;
    }


    public String getData() {
        return this.data;
    }


    public void setParent(Node1<String> parent) {
        this.parent = parent;
    }


    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof Node1) {
            if (((Node1<?>) obj).getData().equals(this.data))
                return true;
        }

        return false;
    }

}
