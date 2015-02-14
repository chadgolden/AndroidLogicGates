package com.chadgolden.gates;

/**
 * Created by Chad on 2/11/2015.
 */
public class Xor extends Gate {

    public Xor(int inputA, int inputB) {
        super(inputA, inputB);
    }

    @Override
    public int execute() {
        return (input[0] ^ input[1]) ? 1 : 0;
    }

    @Override
    public String[][] getTruthTable() {
        String[][] retVal = new String[5][3];
        retVal[0] = new String[] {"InputA", "InputB", "="};
        Gate gate;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                gate = new Xor(i, j);
                retVal[1 + (2*i + j)][0] = String.valueOf(i);
                retVal[1 + (2*i + j)][1] = String.valueOf(j);
                retVal[1 + (2*i + j)][2] = String.valueOf(gate.execute());
            }
        }
        return retVal;
    }
}
