import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * Write a description of class FileIO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileIO
{
    public static final Random rnd = new Random();
    
    public static void main(String[] args) {
        //readFile("ssss");
        writeText("numbers.txt");
    }
    
    public static void readFile(String name) {
        try {
            Files.lines(new File("input.txt").toPath())
                        .map(s -> s.trim())
                        .filter(s -> !s.isEmpty())
                        .forEach(System.out::println);
        }
        catch(IOException e) { 
            e.printStackTrace();
        }
    }
    
    public static void writeText(String name)
    {
        try {
            FileWriter writer = new FileWriter(name, true);
            for(int i = 0; i < 10; i++) {
                writer.write(rnd.nextInt(100 + 1));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
