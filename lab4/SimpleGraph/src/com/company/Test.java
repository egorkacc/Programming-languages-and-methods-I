package com.company;

import java.util.Iterator;

public class Test {

    public static void main(String[] args) {
        int fieldArea = 7;

        SimpleGraph graph = new SimpleGraph(fieldArea);

        graph.showGraph();

        graph.addNode(0, 5);
        graph.addNode(1, 7);
        graph.addNode(2, 2);
        graph.addNode(2, 4);
        graph.addNode(2, 8);
        graph.addNode(3, 7);
        graph.addNode(3, 1);
        graph.addNode(4, 3);
        graph.addNode(5, 7);

        graph.showGraph();

        StringBuilder index = new StringBuilder("0 1 2 3 4 5 6 7 8 9");
        StringBuilder depth = new StringBuilder("0 1 2 3 3 3 4 4 4 4");

        SimpleGraph container = new SimpleGraph(index);
        SimpleGraph depth_container = new SimpleGraph(depth);

        Iterator<String> it = container.iterator();
        Iterator<String> IT = depth_container.iterator();

        while(it.hasNext()) {
            String depthIdx = IT.next();
            if(!it.hasNext())
                break;

            System.out.println("The node's depth of index " + it.next() + " is: " + depthIdx);
        }

        index.insert(1, 'x');

        while(it.hasNext()) {
            String depthIdx = it.next();
            if(!it.hasNext())
                break;
            System.out.println("The node's depth of index " + it.next() + " is: " + depthIdx);
        }
    }
}