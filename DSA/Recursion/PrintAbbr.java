//Write a progam to print abbreviations of a given string
// eg - pep => {pep, pe1, p1p, p2, 1ep, 1e1, 2p, 3} = like 000, 001, 010, 011, 100, 101, 110, 111
public class PrintAbbr {
    public static void main(String[] args) {
        String str = "GFG";
        printComb(str);
    }
    static void printComb(String str)
    {
        // if the string is empty
        if (str.length() == 0)
            return;

        // Stores result strings one by one
        String asf = "";
        printCompRec(str, 0, asf);
    }
    public static void printCompRec(String str, int idx, String asf){
        if(idx == str.length()){
            System.out.println(asf);
            return;
        }
        //include
        asf += str.charAt(idx);
        printCompRec(str, idx+1, asf);

        //not include
        //remove last added character
        asf = asf.substring(0,asf.length()-1);
        int asfLen = asf.length();
        int count = 1;
        if(asfLen > 0){
            char lastCh = asf.charAt(asfLen-1);
            if(lastCh >= '0' && lastCh <= '9'){
                //remove the last integer character
                asf = asf.substring(0, asfLen-1);
                count += (lastCh-'0');
            }
        }
        asf += count;
        printCompRec(str, idx+1, asf);
    }
}
