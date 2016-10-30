/**
   Caesar Cipher.
*/
public class CaesarCipher {

  static final int SHIFT = 3; // positive means right shift.
  static final int RANGE = 26;

  public  static void encrypt(char[] arr, int start, int len) {
    for (int i = start; i < start + len; i++) {
      if (Character.isLetter(arr[i])) {
        arr[i] = Character.isLetter((char)((int)arr[i] + SHIFT))
                     ? (char)((int)arr[i] + SHIFT)
                     : (char)((int)arr[i] + SHIFT - RANGE);
      }
    }
  }

  public  static void decrypt(char[] arr, int start, int len) {
    for (int i = start; i < start + len; i++) {
      if (Character.isLetter(arr[i])) {
        arr[i] = Character.isLetter((char)((int)arr[i] - SHIFT))
                     ? (char)((int)arr[i] - SHIFT)
                     : (char)((int)arr[i] - SHIFT + RANGE);
      }
    }
  }
}
