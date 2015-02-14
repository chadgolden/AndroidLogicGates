package com.chadgolden.gates;

public class Not extends Gate {

	public Not(int inputA) {
		super(inputA);
	}
	
	@Override
	public int execute() {
		return (!input[0]) ? 1 : 0;
	}


//    @Override
//    public int[] getTruthTable() {
//        Not notGate;
//        int[] retVal = new int[4];
//        for (int i = 0; i <= input.length; i++) {
//            notGate = new Not(i);
//            for (int j = 0; j <= input.length; j++) {
//                if (j == 0) {
//                    retVal[input.length*i + j] = i;
//                } else {
//                    retVal[input.length*i + j] = notGate.execute();
//                }
//            }
//        }
//        return retVal;
//    }

    @Override
    public String[][] getTruthTable() {
        String[][] retVal = new String[3][2];
        retVal[0] = new String[] {"Input", "="};
        Gate gate;
        for (int i = 0; i <= 1; i++) {
            gate = new Not(i);
            retVal[1 + i][0] = String.valueOf(i);
            retVal[1 + i][1] = String.valueOf(gate.execute());
        }
        return retVal;
    }
}
