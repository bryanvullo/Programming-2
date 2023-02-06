import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.ConcatenateJavaFiles;

public class JavaFileUtil implements ConcatenateJavaFiles {

  public void concatenateJavaFiles(String dirName, String fileName) throws IOException {
    File dir;
    File concatenatedFile;
    FileWriter writer;

    try {
      dir = new File(dirName);
      concatenatedFile = new File(dirName + "/" + fileName);
      writer = new FileWriter(concatenatedFile);
    } catch (Exception e) {
      throw new IllegalArgumentException(e + "\n" + "First Parameter needs to be a Directory");
    }

    //checks if the directory given exists and is a directory
    if (!dir.exists() || !dir.isDirectory()) {
      throw new IllegalArgumentException("First Parameter needs to be a Directory");
    }

    //gets each file in the directory, checks if it ends with .java and
      // writes each line to the concatenated file
    for (File file : dir.listFiles()) {
      if (file.getName().endsWith(".java")) {
        Scanner reader = new Scanner(new FileReader(file));
        while (reader.hasNextLine()) {
          writer.write(reader.nextLine() + "\n");
        }
        reader.close();
      }
    }
    writer.close();
  }

}
