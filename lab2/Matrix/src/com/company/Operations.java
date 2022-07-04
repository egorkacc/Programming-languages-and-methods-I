package com.company;

import java.util.Collections;
import java.util.ArrayList;

public class Operations {

    private ArrayList<ArrayList<Integer>> values = new ArrayList<ArrayList<Integer>>();

    public Operations(int lines, int columns) {
        init(lines, columns);
    }

    public void init(int lines, int columns) {

        if(lines < 1) {
            System.err.println("The amount of lines doesn't match the requirements");
            return;
        }

        if(columns < 1) {
            System.err.println("The amount of columns doesn't match the requirements");
            return;
        }

        values.clear();
        for(int i = 0; i < lines; i++)
            values.add(new ArrayList<Integer>(Collections.nCopies(columns, 0)));
    }

    public void show_matrix() {

        for(ArrayList<Integer> line : values) {
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

        System.out.println();
    }

    public void set(int line, int column, int value) {
        values.get(line).set(column, value);
    }

    public int read(int line, int column) {
        return values.get(line).get(column);
    }

    public int getLineNumber() {
        return values.size();
    }

    public int getColumnNumber() {
        if(getLineNumber() == 0)
            return 0;
        return values.get(0).size();
    }

    public void deleteLine(int line) {
        values.remove(line);
    }

    public void deleteColumn(int column) {
        for(ArrayList<Integer> line : values) {
            line.remove(column);
        }
    }

    public void addLine(int line) {
        values.add(line, new ArrayList<Integer>(Collections.nCopies(getColumnNumber(), 0)));
    }

    public void addColumn(int column) {
        for(ArrayList<Integer> line : values)
            line.add(column, 0);
    }
}