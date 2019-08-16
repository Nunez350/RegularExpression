/** 
 @author Roy Nunez 
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExFind {
    private static String INPUT = "ACGGGATTATGTAGCCCCTCGAUAGCCGCCCUCGAG";
    private static String StartCodon = "ATG";
    private static String StopCodon ="(UAG|UAA|UGA)"; 

    //searches for starting sequence
    static String findStart(String StartGene,String DNAInput) {
        String ReplaceP = "MET"; 
        Pattern p = Pattern.compile(StartGene);
        Matcher m = p.matcher(DNAInput);   // get a matcher object
        INPUT = m.replaceAll(ReplaceP);
        Pattern pattern = Pattern.compile(ReplaceP);
        Matcher matcher = pattern.matcher(INPUT);
        while (matcher.find()) {
             System.out.println("Indexes for start: (" + matcher.start()+ " , " + matcher.end()+")");
             }
        return INPUT;
    } 
   
    //searches for termination sequence
    static String findStop(String one, String two){
        String stop ="*";
        String newString = two;
        String gene= newString.replaceAll(one, stop);
        Pattern pattern = Pattern.compile(one);
        Matcher matcher = pattern.matcher(two);
        while (matcher.find()) {
             System.out.println("Indexes for stop: (" + matcher.start()+ " , " + matcher.end()+")");
             }
        return gene;
    }

    public static void main(String[] args) {
        System.out.println("Original DNA string: "+INPUT);      
        String first= findStart(StartCodon, INPUT);
        String gene1=findStop(StopCodon, first);
        System.out.println("Start and Stop labeled sequence: "+gene1);
   }
}

