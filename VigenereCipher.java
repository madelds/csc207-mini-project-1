/**
 * Encodes or decodes a string given by the user using 
 * a keyword (also given by the user) to shift the text.javac
 * @author Madel Sibal
 * September 7, 2023
 */

public class VigenereCipher {

    // Main Function

    public static void main(String[] args) {
      
      // Error Checking & Argument Assignment

      // Checks if user entered 3 parameters
      if (args.length != 3) {
        System.err.println("Incorrect number of parameters"); 
        System.exit(2);
      }
      
      // Argument Assignment
      String instruction = args[0];
      String word = args[1];
      String key = args[2];

      
      // Checks if user entered proper instruction
      if (!instruction.equals("encode") && !instruction.equals("decode")) {
        System.err.println("Valid options are 'encode' or 'decode'");
        System.exit(1); 
      }
      
      // Checks if user entered only lowercase letters
      if (!isValidInput(word) || !isValidInput(key)) {
        System.out.println("Both word and key must consist only of lowercase characters.");
        System.exit(1);
      }
      
    // Applies "encode" or "decode" function depending on given instruction
      if (instruction.equals("encode")) {
        String encodedWord = encode(word, key);
        System.out.println(encodedWord);
      } else { 
        String decodedWord = decode(word, key);
        System.out.println(decodedWord);
      }
  
    }
    
    // Helper Functions

    /* Function: isValidInput
     * Pre-condition: Takes in a string.
     * Post-condition: Returns True if all the characters in the string are lowercase
     * letters or if the string is empty. Otherwise, returns False.
     */
    private static boolean isValidInput(String input) {
      return input.isEmpty() || input.matches("^[a-z]+$");
  }
  
    /* Function: cipher
     * Pre-condition: Takes in two strings (a word and a key) and an integer representing
     * the instruction (1 = encode, -1 = decode).
     * Post-condition: Outputs a string that is the encoded/decoded
     * version of the original string.
     */
      private static String cipher(String word, String key, int instruction) {
          StringBuilder result = new StringBuilder();
          int wordLength = word.length();
          int keywordLength = key.length();

          // Checks if the key is an empty string
          if (keywordLength == 0) {
            // Returns the word itself if the above if-statement is true
            return word;
          }
  
          /* Calculates the letter of the keyword by which each individual 
             letter of the original word should shift by. */
          for (int i = 0; i < wordLength; i++) {
              char wordChar = word.charAt(i);
              char keyChar = key.charAt(i % keywordLength);
              int shift = keyChar - 'a';
  
              // Subtracts the shift value from 26 to adjust the shift value for decoding
              if (instruction == -1) {
                  shift = (26 - shift) % 26;
              }
  
              // Calculates the letter of the new character
              char newChar = (char) (((wordChar - 'a' + shift) % 26) + 'a');
              /* Appends each character to newWord until the new word is formed 
                 at the end of the for loop */
              result.append(newChar);
          }
          
          // Returns newWord as a string instead of a stringBuilder
          return result.toString();
      }
  
    /* Function: Encode
     * Pre-condition: Takes in two strings (a word and a key).
     * Post-condition: Outputs a string that is the encoded version 
     * of the original string.
     */
    private static String encode(String word, String key) {
      return cipher(word, key, 1); 
    }
  
    /* Function: Decode
     * Pre-condition: Takes in two strings (a word and a key).
     * Post-condition: Outputs a string that is the decoded version 
     * of the original string.
     */
    private static String decode(String word, String key) {
      return cipher(word, key, -1);
    }
  
  }