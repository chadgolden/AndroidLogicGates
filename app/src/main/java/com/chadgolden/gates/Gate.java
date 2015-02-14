package com.chadgolden.gates;

import com.chadgolden.circuits.Circuit;

/**
 * An abstract logic gate implementation. Constructs a Gate when passed a series of
 * inputted 1s and 0s. If the inputs are not a 1 or 0, an exception will be thrown.
 * Otherwise, the 1s and 0s will be processed as boolean values to perform the logic.
 */
public abstract class Gate implements Circuit {
	
	protected boolean[] input;

    /**
     * Class constructor for Gate. Checks if input contains only 1s and 0s. Converts
     * integer values to boolean values.
     * @param input 1 to n input of 1s and 0s.
     */
	public Gate(int... input) {
		for (int i : input) {
			if (i > 1 || i < 0)
				throw new UnsupportedOperationException("Input must be 0 or 1.");
		}
		
		this.input = new boolean[input.length];
		
		for (int i = 0; i < input.length; i++) {
			this.input[i] = (input[i] == 0) ? false : true;
		}
	}

    /**
     * @return A 0 or 1 value that reflects the correct logic based on the inputs
     * and gate.
     */
	public abstract int execute();
	
}
