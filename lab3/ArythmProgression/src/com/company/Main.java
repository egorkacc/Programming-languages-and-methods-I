package com.company;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        Polygamy progression = new Polygamy();

        int n = in.nextInt();
        int[][] triplet = new int[n][3];

        int first, difference;
        for(int i = 0; i < n; i++) {
            first = in.nextInt();
            triplet[i][0] = first;

            difference = in.nextInt();
            triplet[i][1] = difference;

            triplet[i][2] = progression.ElemArrayCount(first, difference);
        }

        int[] keys = new int[n];
        for(int i = 0; i < n; i++)
            keys[i] = triplet[i][2];

        Arrays.sort(keys);

        int[] deleted_keys = new int[n];
        for(int i = 0; i < n; i++) {
            deleted_keys[i] = keys[i];
        }

        int current = 0, next = 0;
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {
                if(keys[i] == triplet[j][2] && deleted_keys[j] != 0) {
                    current = triplet[j][0];
                    next = triplet[j][1];

                    deleted_keys[j] = 0;

                    break;
                }
            }

            for(int k = 0; k < 20; k++) {
                System.out.print(current + " ");
                current += next;
            }

            System.out.println("");
        }
    }
}
