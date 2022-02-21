package Controller;
import ReferenceTables.DxcReferenceTable;

public class DxcController {

    private static DxcReferenceTable dxcReferenceTable;
    private static char SPACEBAR = ' ';
    private  char offsetLetter;

    public DxcController() {
        this.dxcReferenceTable = new DxcReferenceTable();
    }

    public void setCode(char offsetLetter)
    {
        this.offsetLetter = offsetLetter;

    }

    public  String encode(String target) {
        int index_offset = 0 - dxcReferenceTable.lookup(offsetLetter);
        StringBuilder sb = new StringBuilder();
        sb.append(offsetLetter);

        for (char i : target.toCharArray()) {
            if (i == SPACEBAR) {
                sb.append(i);
                continue;
            }
            int letterIndex = dxcReferenceTable.lookup(i) + index_offset;
            //  System.out.println(letterIndex);
            if (letterIndex < 0) letterIndex = dxcReferenceTable.returnTable().size() + letterIndex ;
            sb.append(dxcReferenceTable.returnTable().get(letterIndex));
        }
        return sb.toString();
    }


    public String decode(String target) {

        char offSetLetter = target.charAt(0);
        // System.out.println(offSetLetter);

        int index_offset = dxcReferenceTable.lookup(offSetLetter);
        // System.out.println(index_offset);

        StringBuilder sb = new StringBuilder();
        for (char i : target.toCharArray()) {
            if (i == SPACEBAR) {
                sb.append(i);
                continue;
            }

            int letterIndex = dxcReferenceTable.lookup(i)+index_offset ;
            if (letterIndex > 43) letterIndex = letterIndex-44 ;
            sb.append(dxcReferenceTable.returnTable().get(letterIndex));
        }
        sb.deleteCharAt(0);
        return sb.toString();

    }


}
