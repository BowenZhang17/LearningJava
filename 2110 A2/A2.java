/* NetIds: Bowen Zhang, bz223. Time  spent: hh hours, mm minutes. */

/** A collection of static String utility functions. All methods assume that
 * String parameters are non-null.
 *
 * If any method is called with arguments that do not satisfy the preconditions,
 * the behavior is undefined (it can do anything you want). You can,
 * (but do not have to) use assert statements to test preconditions. */
public class A2 {
    /* Implementation notes:
     *
     * Wherever possible, prefer library functions to writing your own loops.
     *
     * The more complicated your loops become, the more important it is to
     * explain the logic in comments.
     *
     * See the JavaHyperText entries for if-statement, while-loop, for-loop,
     * switch, break, and continue if you think you need them.
 *
 *   Look at pinned Piazza note "A2 FAQs" regularly for updates.*/

    /**Return either s1 + s2 or s1 - s2, depending on b. If b is true, return
     * the sum, otherwise return the difference. */
    public static int sumDif(boolean b, int s1, int s2) {
        // This method is already implemented; it is here to give you something
        // to test, and to show you different ways of writing return statements.
        if (b) {
            int s;
            s = s1 + s2;
            return s;

            // equivalently:
            // int s = s1 + s2;
            // return s;

            // or simply: return s1 + s2;
        }

        // b is false;
        return s1 - s2;
    }
    /** Return true iff the first half of s is the same as the second half of s.
     * Examples: For s = "" return true
     * For s = "xxx" return false (if the length is odd, it's false)
     * For s = "xxxx" return true
     * For s = "hellohello" return true
     * For s = "helloolleh" return false */
    public static boolean isDoubled(String s) {
        // TODO 1. There is no need for a loop. Do not use a loop.
        // In all methods, use s1.equals(s2) and NOT s1 == s2 to test
        // equality of s1 and s2.
    	String s1 = s.substring(0,s.length()/2);
    	String s2 = s.substring(s.length()/2, s.length());
    	if (!s1.equals(s2) || s.length()%2 == 1){
    		return false;
    	}
        return true;
    }
    /** Return s with adjacent equal characters removed.
     * Examples: for s = "", return ""
     * For s = "b", return "b"
     * For s = "aaaabaccc", return "abac" */
    public static String removeDups(String s) {
    	String deDuped = s;
    	int tracker = 0;
    	while (tracker < deDuped.length()-1) {
    		//set deDuped equal to values directly before and after repeate char
    	      if (deDuped.charAt(tracker) == deDuped.charAt(tracker+1)) {
    	       deDuped = deDuped.substring(0,tracker) 
    	         + deDuped.substring(tracker+1,deDuped.length());}
    	      else tracker = tracker+1;
    	}
        return deDuped;
    }
    /** Return s but with each occurrence of a character in input replaced by the
     * corresponding character in output. A character of s that does not appear in
     * input is unchanged.
     *
     * Precondition: input and output are the same length. No character in input
     * appears in output (otherwise, the idea of replacement might be ambiguous,
     * depending on the order in which replacements are done).
     *
     * Examples: replace("hello world", "", "") = "hello world"
     * replace("hello world", "abc", "lmn") = "hello world"
     * replace("hello world", "hod", "xyz") = "xelly wyrlz"
     * replace("hello world", "helowrd", ".......") = "..... ....."   */
    public static String replace(String s, String input, String output) {
        // TODO 3 This needs only ONE for-loop with a single statement in the
        // loop body. Look for a suitable String method!
    	String inBase = s;
    	for (int tracker = 0; tracker < input.length(); tracker++) {
    		inBase = inBase.replace(input.charAt(tracker), output.charAt(tracker));
    	}
    	return inBase; 
    }
    /** Return the shortest substring x of s such that s = x + x + ⋯ + x.
     * Examples:
     * For s = "" return ""
     * For s = "xxxxxxxxx" return "x"
     * For s = "xyxyxyxy" return "xy"
     * For s = "hellohellohello" return "hello"
     * For s = "hellohelloworld" return "hellohelloworld"
     * For s = "hellohel" return "hellohel" */
    public static String makeShort(String s) {
        // TODO 4. This can be written using nested loops. But it is better
        // to add a helper function, with a suitable specification,
        // in order to remove the need for nested loops. It is easier
        // to write and easier to read/understand.
    	   String inBase = s;
    	     String shortString = inBase.substring(0,0);
    	     int tracker = 0;
    	       while (!inBase.replace(shortString,"").isEmpty()) {
    	         tracker++;
                 shortString = s.substring(0,tracker);}
        return shortString;
    }

    /** Return the value of the expression given by s.
     *  Precondition: s consists of a series of (at least one) integers
     *  separated by the operators '+' or '-'. The expression may contain
     *  any number space characters between the integers and operators.
     *
     * Examples: eval("3")                returns 3
     *           eval("3 +    4")         returns 7
     *           eval("100 + 4-2  ")      returns 102
     *           eval("0-9")              returns -9
     *           eval("   7   +   7   +    7  ") returns 21
     */
    public static int eval(String s) {
        // TODO 5. You can use Integer.parseInt to convert a string
        // (like "12345") to the corresponding integer (12345).
    	String inBase = s.replace(" ","");
        //Return integer value if there is no + or -
    	try {
          return(Integer.parseInt(inBase));}
        catch (NumberFormatException e){
        	//Split string into arrayS based on + and - operators
          String[] arrayS = inBase.split("\\+|-");
          int totalSum = Integer.parseInt(arrayS[0]);
          int arrayTracker = 1;
          for (int loopTracker = 0; loopTracker < inBase.length(); loopTracker ++) {
            //Add next integer from arrayS when a + sign is recognized
        	  if (inBase.charAt(loopTracker) == '+') {
              totalSum  = totalSum + Integer.parseInt(arrayS[arrayTracker]);
            arrayTracker++; }
        	//Subtract next integer from arrayS when a - sign is recognized
            if (inBase.charAt(loopTracker) == '-') {
              totalSum  = totalSum - Integer.parseInt(arrayS[arrayTracker]);
              arrayTracker++;}}
        return totalSum;}
    }

}
