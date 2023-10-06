/**
 * Encodes or decodes a string given by the user according to the Caesar Cipher.
 * 
 * @author Madel Sibal September 7, 2023
 */

public class CaesarCipher {

    // Main Function

    public static void main(String[] args) {

        // Error Checking & Argument Assignment

        // Checks if user entered 2 parameters
        if (args.length != 2) {
            System.err.println("Incorrect number of parameters");
            System.exit(2);
        }

        // Argument assignment
        String instruction = args[0];
        String word = args[1];

        // Checks if user entered proper instruction
        if (!instruction.equals("encode") && !instruction.equals("decode")) {
            System.err.println("Valid options are 'encode' or 'decode'");
            System.exit(1);
        }

        // Handles the case when the input string is empty
        if (word.isEmpty()) {
            // Handle empty input gracefully
            System.out.println("n = 0: " + word);
            for (int i = 1; i < 26; i++) {
                System.out.println("n = " + i + ": " + word);
            }
            System.exit(1);
        }

        // Checks if user entered only lowercase letters
        if (!word.matches("[a-z]+")) {
            System.err.println("Error: Input must ONLY contain lowercase letters.");
            System.exit(1);
        }

        // Applies "encode" or "decode" function depending on given instruction
        if (instruction.equals("encode")) {
            encode(word);
        } else {
            decode(word);
        }

    }

    // Helper Functions

    /*
     * Function: Encode Pre-condition: Takes in a string. Post-condition: Prints the encoded version
     * of the string for each letter of the alphabet.
     */
    public static void encode(String word) {
        for (int i = 0; i < 26; i++) {
            String encodedWord = cipher(word, i);
            System.out.println("n = " + i + ": " + encodedWord);
        }
    }

    /*
     * Function: Decode Pre-condition: Takes in a string. Post-condition: Prints the decoded version
     * of the string for each letter of the alphabet.
     */
    public static void decode(String word) {
        for (int i = 0; i < 26; i++) {
            String decodedWord = cipher(word, 26 - i);
            System.out.println("n = " + i + ": " + decodedWord);
        }
    }

    /*
     * Function: Cipher Pre-condition: Takes in a string and an integer (key). Post-condition:
     * Outputs a string that is the encoded/decoded version of the original string.
     */
    public static String cipher(String word, int n) {
        StringBuilder newWord = new StringBuilder();
        // Converts each letter of the word to the corresponding cipher
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c = (char) (c + n);
            // Calculation done to wrap around 26
            if (c > 'z') {
                c = (char) (c - 26);
            }
            /*
             * Appends each character to newWord until the new word is formed at the end of the for
             * loop
             */
            newWord.append(c);
        }
        // Returns newWord as a string instead of a stringBuilder
        return newWord.toString();
    }
}
