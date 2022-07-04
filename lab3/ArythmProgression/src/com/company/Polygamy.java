package com.company;

public class Polygamy implements Comparable<Polygamy> {

    private int digit_count;

    public Polygamy() {}

    public int ElemArrayCount(int first, int difference) {
        int calc = first;
        while(calc < 1)
            calc += difference;
        first = calc;

        return (99 - first)/difference + 1;
    }

    public int getInteger(){
        return this.digit_count;
    }

    public int compareTo(Polygamy obj) {
        if(getInteger() > obj.getInteger())
            return -1;
        if(getInteger()  == obj.getInteger())
            return 0;
        return 1;
    }
}
