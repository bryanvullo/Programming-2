import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.RandomIO;

public class RandomNumberWriter implements RandomIO {

  Random random;

  public RandomNumberWriter(long seed) {
    random = new Random(seed);
  }

  public void writeRandomChars(String path) throws IOException {
    File file = new File(path);
    FileWriter writer = new FileWriter(file);
    for (int i = 0; i < 10000; i++) {
      int randomNumber = random.nextInt(100000);
      writer.write(randomNumber + "\n");
    }
    writer.close();
  }

  public void writeRandomByte(String path) throws IOException {
    File file = new File(path);
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    ByteBuffer byteBuffer = ByteBuffer.allocate(4);

    for (int i = 0; i < 10000; i++) {
      int randomInteger = random.nextInt(100000);
      byteBuffer.putInt(randomInteger);
      fileOutputStream.write(byteBuffer.array());
      byteBuffer.clear();
    }
    fileOutputStream.close();
  }
}
