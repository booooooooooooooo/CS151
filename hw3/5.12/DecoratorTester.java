import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
   Testor.
*/
class DecoratorTester {

  public static void main(String[] args) throws IOException {
    EncryptingWriter encryptW = new EncryptingWriter(new FileWriter("output"));
    encryptW.write("abcdefghijklmnopqrstuvwxyz123456789!@#$%^&*ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 69);
    encryptW.flush();
    encryptW.close();
    System.out.println("\nInitial String :");
    System.out.println("abcdefghijklmnopqrstuvwxyz123456789!@#$%^&*ABCDEFGHIJKLMNOPQRSTUVWXYZ");


    char[] input = new char[100];
    FileReader r = new FileReader("output");
    r.read(input, 0, 69);
    System.out.println("\nString stored in file:");
    System.out.println(input);


    char[] decryptedInput = new char[100];
    DecryptingReader decryptR = new DecryptingReader(new FileReader("output"));
    decryptR.read(decryptedInput, 0, 69);
    System.out.println("\nString from file after decrypting:");
    System.out.println(decryptedInput);

  }
}
