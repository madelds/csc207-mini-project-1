public class VigenereCipher {

  public static void main(String[] args) {
    if (args.length != 3) {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }

    String instruction = args[0];
    String word = args[1];
    String key = args[2];

    if (!instruction.equals("encode") && !instruction.equals("decode")) {
      System.err.println("Valid options are 'encode' or 'decode'");
      System.exit(1);
    }

    if (!isValidInput(word) || !isValidInput(key)) {
      System.out.println("Both word and key must consist only of lowercase characters.");
      System.exit(1);
    }

    if (instruction.equals("encode")) {
      String encodedWord = encode(word, key);
      System.out.println(encodedWord);
    } else {
      String decodedWord = decode(word, key);
      System.out.println(decodedWord);
    }
  }

  private static boolean isValidInput(String input) {
    return input.isEmpty() || input.matches("^[a-z]+$");
  }

  private static String cipher(String word, String key, int instruction) {
    StringBuilder result = new StringBuilder();
    int wordLength = word.length();
    int keywordLength = key.length();

    if (keywordLength == 0) {
      return word;
    }

    for (int i = 0; i < wordLength; i++) {
      char wordChar = word.charAt(i);
      char keyChar = key.charAt(i % keywordLength);
      int shift = keyChar - 'a';

      if (instruction == -1) {
        shift = (26 - shift) % 26;
      }

      char newChar = (char) (((wordChar - 'a' + shift) % 26) + 'a');

      result.append(newChar);
    }

    return result.toString();
  }

  private static String encode(String word, String key) {
    return cipher(word, key, 1);
  }

  private static String decode(String word, String key) {
    return cipher(word, key, -1);
  }

}