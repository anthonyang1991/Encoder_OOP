package ReferenceTables;

import java.util.ArrayList;
import java.util.List;

public class DxcReferenceTable {

    private static List<Character> characterList = new ArrayList<>();

    public DxcReferenceTable() {
        for (char i = 'A'; i <= 'Z'; ++i) characterList.add(i);
        for (char i = '0'; i <= '9'; ++i) characterList.add(i);
        for (char i = '('; i <= '/'; ++i) characterList.add(i);
    }

    public int lookup(char letter) {
        return characterList.indexOf(letter);
    }

    public List returnTable()
    {

        return characterList;

    }
}
