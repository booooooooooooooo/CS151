import java.io.Reader;
import java.io.IOException;

/**
   A decorator class of Reader to support decrypting.
*/
public class DecryptingReader extends Reader {
  private Reader reader;

  public DecryptingReader(Reader reader) { this.reader = reader; }

  @Override
  public int read(char[] cbuf, int off, int len) throws IOException {
    int result = reader.read(cbuf, off, len);
    CaesarCipher.decrypt(cbuf, off, len);
    return result;
  }

  @Override
  public void close() throws IOException {
    reader.close();
  }
}
