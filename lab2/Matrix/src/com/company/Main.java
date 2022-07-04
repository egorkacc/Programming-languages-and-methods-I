package com.company;

public class Main {

    public static void main(String[] args) {

        Operations matrix = new Operations(2, 2);

        matrix.set(0,0, 7);
        matrix.set(1,1, 5);
        matrix.set(0,1, 1);

        matrix.show_matrix();

        matrix.addColumn(0);
        matrix.show_matrix();

        matrix.addLine(0);
        matrix.show_matrix();

        matrix.addColumn(3);
        matrix.show_matrix();

        matrix.addLine(3);
        matrix.show_matrix();

        matrix.deleteColumn(0);
        matrix.deleteLine(1);
        matrix.show_matrix();
    }
}