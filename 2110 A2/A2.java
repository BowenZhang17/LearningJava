/* NetIds: Bowen Zhang, bz223. Time  spent: hh hours, mm minutes. */ /// jingyu is doing comments this way so I'll stay consistent, also don't forget ur hours

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
     * the sum, otherwise return the difference. */ /// this looks like a pre-made comment, but like jingyu said it's usually preferred to start comments below ** line
    public static int sumDif(boolean b, int s1, int s2) { /// also the comment could be more concise (return x if b is true, else y if b is false)
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
    	String s1 = s.substring(0,s.length()/2); /// I like to space things out a bit for readability, i.e. s.sub(0, s.len() / 2, s.len())
    	String s2 = s.substring(s.length()/2, s.length()); /// s.length() 2nd argument is not required, but maybe good for readability
    	if (!s1.equals(s2) || s.length()%2 == 1){ /// even/odd length check is redundant since you already handle that case by comparing s1 to s2
                                                  /// if it were odd, there is no way s1.equals(s2) is true because one will be longer than the other
                                                  /// a small optimization you could do is to do the length check in the beginning to short circuit early
                                                  /// so you wouldn't have to substring at all on odd len strings (copying strings may be a heavy operation)
    		return false;                     /// <-- any time you return true/false in an if statement, you could instead just return the boolean in the if statement
                                                  /// in this case, `return s1.equals(s2)` (and then remove the length check), so you wouldn't need two return statements
    	}
        return true;
    }
    /** Return s with adjacent equal characters removed.
     * Examples: for s = "", return ""
     * For s = "b", return "b"
     * For s = "aaaabaccc", return "abac" */
    public static String removeDups(String s) {
    	String deDuped = s; /// I believe in Java this is passed by reference, so it is no different than operating directly on s
    	int tracker = 0;
    	while (tracker < deDuped.length()-1) {
    		//set deDuped equal to values directly before and after repeate char
    	      if (deDuped.charAt(tracker) == deDuped.charAt(tracker+1)) {
    	       deDuped = deDuped.substring(0,tracker) 
    	         + deDuped.substring(tracker+1,deDuped.length());}
    	      else tracker = tracker+1;
    	}
        return deDuped;
        /// while I have no doubt all of this works, it is generally pretty hard & not recommended to mutate a string while iterating over it
        /// this leads to complex logic like incrementing `tracker` sometimes but not other times which can lead to out of bounds errors
        /// also, the worst case time complexity for this would be if you had a string like "aaaaaaaaaa...", in which you would have to call substring 2*length(s) times
        /// modifying strings can be a heavy task, so in this case I think it would be better to build an entirely new string as you go along
        /// you could keep track of the previous seen char as you iterate through s, and append the current char to a new string/stringbuilder if the current char is different
        /// this way no more substring calls and the loop would be a simple forEach char in s loop
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
     * replace("hello world", "helowrd", ".......") = "..... ....."   */ /// just use a hashmap lol
    public static String replace(String s, String input, String output) {
        // TODO 3 This needs only ONE for-loop with a single statement in the
        // loop body. Look for a suitable String method!
    	String inBase = s;
    	for (int tracker = 0; tracker < input.length(); tracker++) {
    		inBase = inBase.replace(input.charAt(tracker), output.charAt(tracker)); /// codewise this is actually quite elegant if you disregard performance :P
    	}
    	return inBase; 
    } /// pref add some spaces between functions for readability
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
    	       while (!inBase.replace(shortString,"").isEmpty()) { /// that's clever lol
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
        catch (NumberFormatException e){ /// typically not what catch is used for lol but this would be a pretty pythonic way of doing it
        	//Split string into arrayS based on + and - operators /// this assumes the string is well formatted and will not throw any other errors when parsing
          String[] arrayS = inBase.split("\\+|-");
          int totalSum = Integer.parseInt(arrayS[0]);
          int arrayTracker = 1;
          for (int loopTracker = 0; loopTracker < inBase.length(); loopTracker ++) {
            //Add next integer from arrayS when a + sign is recognized
        	  if (inBase.charAt(loopTracker) == '+') {
              totalSum  = totalSum + Integer.parseInt(arrayS[arrayTracker]);
            arrayTracker++; } /// all of these } typically go on a new line according to most styles
        	//Subtract next integer from arrayS when a - sign is recognized
            if (inBase.charAt(loopTracker) == '-') {
              totalSum  = totalSum - Integer.parseInt(arrayS[arrayTracker]);
              arrayTracker++;}}
        return totalSum;}
    }

}
