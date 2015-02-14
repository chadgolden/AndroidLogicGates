package com.chadgolden.circuits;

import com.chadgolden.gates.*;

/**
 * A Full Adder as defined in the homework page.
 * Created by Chad on 2/11/2015.
 */
public class FullAdder implements Circuit {

    private HalfAdder halfAdder1;
    private HalfAdder halfAdder2;
    private Or orGate;

    /**
     * Class constructor for FullAdder that takes three inputs.
     * @param inputA
     * @param inputB
     * @param inputC
     */
    public FullAdder(int inputA, int inputB, int inputC) {
        halfAdder1 = new HalfAdder(inputB, inputC);
        halfAdder2 = new HalfAdder(inputA, halfAdder1.s());
        orGate = new Or(halfAdder2.c(), halfAdder1.c());
    }

    /**
     * @return Output "S" as defined in the homework page.
     */
    public int s() { return halfAdder2.s(); }

    /**
     * @return Output "T" as defined in the homework page.
     */
    public int t() { return orGate.execute(); }

    /**
     * @return The truth table for this structure.
     */
    public static int[][] truthTable() {
        FullAdder fullAdder;
        int[][] retVal = new int[8][5];
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c <= 1; c++) {
                }
            }
        }
        return retVal;
    }

    /**
     * Prints the truth table for this Full Adder to the console.
     */
    public static void printTruthTable() {
        FullAdder fullAdder;
        System.out.println("-----------------------------");
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c <= 1; c++) {
                    fullAdder = new FullAdder(a, b, c);
                    System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", s = " + fullAdder.s() + ", t = " + fullAdder.t());
                }
            }
        }
        System.out.println("-----------------------------");
    }

    @Override
    public String[][] getTruthTable() {
        String[][] retVal = new String[(int)Math.pow(2, 3) + 1][5];
        retVal[0] = new String[] {"InputA", "InputB", "InputC", "S", "T"};
        FullAdder fullAdder;
        for (int a = 0; a <= 1; a++) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c <= 1; c++) {
                    fullAdder = new FullAdder(a, b, c);
                    retVal[1 + ((4*a) + (2*b) + (1*c))][0] = String.valueOf(a);
                    retVal[1 + ((4*a) + (2*b) + (1*c))][1] = String.valueOf(b);
                    retVal[1 + ((4*a) + (2*b) + (1*c))][2] = String.valueOf(c);
                    retVal[1 + ((4*a) + (2*b) + (1*c))][3] = String.valueOf(fullAdder.s());
                    retVal[1 + ((4*a) + (2*b) + (1*c))][4] = String.valueOf(fullAdder.t());

                }
            }
        }
        return retVal;
    }
}
