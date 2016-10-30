import java.io.Writer;
import java.io.IOException;

/**
   A decorator class to Reader to support encrypting.
*/
public class EncryptingWriter extends Writer {
  private Writer writer;

  public EncryptingWriter(Writer writer) { this.writer = writer; }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    CaesarCipher.encrypt(cbuf, off, len);
    writer.write(cbuf, off, len);
  }

  @Override
  public void close() throws IOException {
    writer.close();
  }

  @Override
  public void flush() throws IOException {
    writer.flush();
  }
}
