package com.chadgolden.app;

import com.chadgolden.gates.*;
import com.chadgolden.circuits.*;

/**
 * Simple switch-case factory for 2D arrays representing truth tables for some circuit.
 *
 * Created by Chad on 2/14/2015.
 */
public class TruthTableFactory {

    /**
     * @param circuitName The circuit for which to retrieve the truth table.
     * @return 2D array representing the truth table for some circuit.
     */
    public String[][] createTruthTable(String circuitName) {
        switch(circuitName.toUpperCase()) {
            case "NOT":
                return new Not(0).getTruthTable();
            case "OR":
                return new Or(0, 0).getTruthTable();
            case "AND":
                return new And(0, 0).getTruthTable();
            case "XOR":
                return new Xor(0, 0).getTruthTable();
            case "HALF-ADDER":
                return new HalfAdder(0, 0).getTruthTable();
            case "FULL-ADDER":
                return new FullAdder(0, 0, 0).getTruthTable();
        }
        return new String[][] { {"No valid logic option selected."} };
    }

}
