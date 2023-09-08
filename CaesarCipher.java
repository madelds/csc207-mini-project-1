public class CaesarCipher {

  public static void main(String[] args) {


    if (args.length != 2) {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }

    String instruction = args[0];
    String word = args[1];

    if (!instruction.equals("encode") && !instruction.equals("decode")) {
      System.err.println("Valid options are 'encode' or 'decode'");
      System.exit(1);
    }

    if (!word.matches("[a-z]+")) {
      System.err.println("Error: Input must ONLY contain lowercase letters.");
      System.exit(1);
    }

    if (instruction.equals("encode")) {
      encode(word);
    } else {
      decode(word);
    }

  }

  public static void encode(String word) {
    for (int i = 0; i < 26; i++) {
      String encodedWord = cipher(word, i);
      System.out.println("n = " + i + ": " + encodedWord);
    }
  }

  public static void decode(String word) {
    for (int i = 0; i < 26; i++) {
      String decodedWord = cipher(word, 26 - i);
      System.out.println("n = " + i + ": " + decodedWord);
    }
  }

  public static String cipher(String word, int n) {
    StringBuilder newWord = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      c = (char) (c + n);
      if (c > 'z') {
        c = (char) (c - 26);
      }
      newWord.append(c);
    }
    return newWord.toString();
  }
}
