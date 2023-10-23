package Controller;

import java.util.List;

import ReferenceTables.DxcReferenceTable;

/**
 * @author Anthony This class is controls encoder, decoder and uses lookup
 *         table.
 */
public class DxcController {

	private static char SPACEBAR = ' ';
	private char offsetLetter;
	DxcReferenceTable dxcReferenceTable = new DxcReferenceTable();
	DxcReferenceTable dxcReferenceTableRoot = new DxcReferenceTable();

	/**
	 * @Constructor
	 */
	public DxcController() {

	}

	
	/**
	 * @param String input 
	 *  This function encodes the string
	 */
	public String encode(String input) {

		// Get the offset letter from the String - B
		offsetLetter = input.charAt(0);

		// get String to encode - HELLO_WORLD
		String target = input.chars().skip(1) // Skip the first character (index 0)
				.mapToObj(c -> (char) c).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();

		// convert offset Letter into a int index B by using lookup table. 0 - B(1 from
		// lookuptable) = -1(offset)
		int index_offset = dxcReferenceTable.lookup(offsetLetter);
		StringBuilder sb = new StringBuilder();

		// rotate list here
		dxcReferenceTable.RotateList(index_offset);

		// append B into the encoded message
		sb.append(offsetLetter);

		// loop through the String to encode- HELLO WORLD
		for (int i = 0; i < target.length(); i++) {

			// if it is a spacebar we just append and move on
			if (target.charAt(i) == SPACEBAR) {
				sb.append(SPACEBAR);
				continue;
			}

			// gets the index of the letter from the unshifted table
			int letterIndex = dxcReferenceTableRoot.lookup(target.charAt(i));

			// gets the char from the shifted table using the original index
			char inputChar = dxcReferenceTable.lookupViaIndex(letterIndex);
			sb.append(inputChar);
		}
		return sb.toString();
	}

	
	/**
	 * @param String output 
	 *  This function dencodes the string
	 */
	public String decode(String output) {

		// Get the offset letter from the String - B
		offsetLetter = output.charAt(0);

		// get String to dencode - HELLO_WORLD
		String target = output.chars().skip(1) // Skip the first character (index 0)
				.mapToObj(c -> (char) c).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();

		// convert offset Letter into a int index B by using lookup table. 0 - B(1 from
		// lookuptable) = -1(offset)
		int index_offset = dxcReferenceTable.lookup(offsetLetter);
		StringBuilder sb = new StringBuilder();

		// derotate list here
		dxcReferenceTable.unRotateList(index_offset);

		// append B into the dencoded message
		sb.append(offsetLetter);

		// loop through the String to encode- HELLO WORLD
		for (int i = 0; i < target.length(); i++) {

			// if it is a spacebar we just append and move on
			if (target.charAt(i) == SPACEBAR) {
				sb.append(SPACEBAR);
				continue;
			}

			// gets the index of the letter from the unshifted table
			int letterIndex = dxcReferenceTableRoot.lookup(target.charAt(i));

			// gets the char from the shifted table using the original index
			char inputChar = dxcReferenceTable.lookupViaIndex(letterIndex);
			sb.append(inputChar);
		}
		return sb.toString();
	}
}
