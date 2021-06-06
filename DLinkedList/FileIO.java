import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

/**
 * Write a description of class FileIO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileIO
{
    public static void main(String[] args) {
        readFile("ssss");
    }
    
    public static void readFile(String name) {
        Files.lines(new File("input.txt").toPath())
                    .map(s -> s.trim())
                    .filter(s -> !s.isEmpty())
                    .forEach(System.out::println);
    }
}
