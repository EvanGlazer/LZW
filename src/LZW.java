
import java.util.*;

/**
 *
 * @author Evan Glazer
 */
public class LZW {
    
 public static int dictionSize = 256;
 
    public static List<Integer> compression(String str)
    {
     //local var
     int dSize = dictionSize;
     Hashtable<String, Integer> dictionary = new Hashtable<String,Integer>();
     List<Integer> outputCode = new ArrayList<Integer>();
     // build dictionary
     for(int i=0; i<dSize; i++)
     {
         dictionary.put(""+(char)(i), i);
     }
     
     // start the compression
     String compress = "";
     for(char c: str.toCharArray())
     {
         String check = compress + c;
         if(dictionary.containsKey(check))
             compress = check;
         else
             outputCode.add(dictionary.get(compress));
             // now add to the dictionary
             dictionary.put(check, dSize++);
             compress = "" + c;
     }
     
     // print the output code
     if(!compress.equals(""))
         outputCode.add(dictionary.get(compress));
     return outputCode;
    }
    
    public static String decompression(List<Integer> compressed)
    {
      //local var
     int dSize = dictionSize;
     Hashtable<Integer, String> dictionary = new Hashtable<Integer, String>();
     
     // build dictionary
     for(int i=0; i<dSize; i++)
     {
         dictionary.put(i, ""+(char)(i));
     }
     
     // start the decompression
     String decompress = "" + (char)(int)compressed.remove(0);
     String output = decompress;
     for(int k: compressed)
     {
         String check = "";
         if(dictionary.containsKey(k))
             check = dictionary.get(k);
         else if (k == dSize)
             check = decompress + decompress.charAt(0);
         else
             output += check;
              dictionary.put(dSize++, decompress + check.charAt(0));
              decompress = check;
     }
     return output;
    }

    public static void main (String[] args)
    {
        System.out.println(compression("ABBABBBABBA"));
        // Answer: [256, 66, 66, 256]
        
        System.out.println(decompression(outputCode));
        // Answer: ABBABBBABBA
    }
}
