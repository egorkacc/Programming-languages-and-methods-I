package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SimpleGraph implements Iterable {
//=========================================================================================
    private StringBuilder depth;

    public SimpleGraph(StringBuilder depth) {
        this.depth = depth;
    }

    public Iterator iterator() {
        return new DepthIterator();
    }

    private class DepthIterator implements Iterator {
        private int pos = 0, t = 0;

        public DepthIterator() {
            pos = 0;
        }

        public boolean hasNext() {
            return pos < depth.length();
        }

        public String next() {
            return depth.substring(pos++, pos++);
        }
    }

//=========================================================================================
    private int nodeCount = 0;

    public SimpleGraph(int nodes) {
        init(nodes, nodes);
        nodeCount = nodes;
    }

    private final ArrayList<ArrayList<Integer>> values = new ArrayList<>();

    public void init(int lines, int columns) {

        if(lines < 1) {
            System.err.println("The amount of lines or columns is either negative or trivial");
            return;
        }

        values.clear();

        for(int i = 0; i < lines; i++)
            values.add(new ArrayList<>(Collections.nCopies(columns, 0)));
    }

    private int nodes_used = 1;
    private int temp = 0;

    public void addNode(int index, int distance) {
        if(temp != index)
            nodes_used = 1;
        temp = index;

        if(index == nodeCount - 1)
            System.err.println("The node's index is out of reach of the given field");
        else if(index < 0)
            System.err.println("The input index must be either trivial or positive");
        else {
            setPath(index, index + nodes_used, distance);
            setPath(index + nodes_used, index, distance);

            nodes_used++;
        }
    }

    private int readValue(int line, int column) {
        return values.get(line).get(column);
    }

    public void setPath(int line, int column, int distance) {
        values.get(line).set(column, readValue(line, column) + distance);
    }

    public void showGraph() {

        for (ArrayList<Integer> line : values) {
            System.out.print('|');

            int i = 0;
            for(Integer element : line) {
                ++i;

                System.out.print(element);
                if(i == values.size())
                    break;

                System.out.print(" ");
            }

            System.out.println('|');
        }

        System.out.println("===================================");
    }
}