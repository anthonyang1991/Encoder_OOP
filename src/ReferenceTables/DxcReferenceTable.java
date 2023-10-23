package ReferenceTables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anthony This class acts as the reference table as per question
 *         given. @ index 0 = 'A' and @ index 43 = '/'
 */

public class DxcReferenceTable {

	private List<Character> characterList = new ArrayList<>();

	public DxcReferenceTable() {

		// inserting alphe A to Z into the list
		for (char i = 'A'; i <= 'Z'; i++)
			characterList.add(i);

		// inserting numerical into the list
		for (char i = '0'; i <= '9'; i++)
			characterList.add(i);

		// inserting special char in to the list
		for (char i = '('; i <= '/'; i++)
			characterList.add(i);
	}

	/**
	 * @author Anthony This function return the index via Char. Eg: if B was
	 *         inserted the return value will be 1.
	 */
	public int lookup(char letter) {
		return characterList.indexOf(letter);
	}

	/**
	 * @author Anthony This function return the char via index. Eg: if B was
	 *         inserted the return value will be 1.
	 */
	public char lookupViaIndex(int index) {
		return characterList.get(index);
	}

	/**
	 * @author Anthony This function rotates the list via input position
	 */
	public void RotateList(int rotateNumber) {
		Collections.rotate(characterList, rotateNumber);
	}
	
	public void unRotateList(int rotateNumber) {
		Collections.rotate(characterList, -rotateNumber);
	}
	
	

	/**
	 * @author Anthony This function returns the default list with 44 values. 0-43
	 */
	public List returnTable() {

		return characterList;

	}
}
