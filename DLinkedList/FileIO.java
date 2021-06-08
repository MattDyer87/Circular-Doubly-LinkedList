import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Iterator;

/**
 * A class built for simple file reading and writing using integers and a custom
 * circular doubly linked list class.
 *
 * @author Matthew Dyer
 * @version 2021.06.06
 */
public class FileIO
{
    private static final Random rnd = new Random();
    private static CircDblLinkedList<Integer> cdll = new CircDblLinkedList<>();
    private static List<Integer> numbers = null;
    
    public static void main(String[] args) {
        List<Integer> nums = readFile("numbers.txt");
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);
    }
    
    public static List<Integer> readFile(String name) {
        try {
            numbers = Files.lines(new File(name).toPath())
                        .map(s -> s.trim())
                        .filter(s -> !s.isEmpty())
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList());
        }
        catch(IOException e) { 
            e.printStackTrace();
        }
        return numbers;
    }
    
    public void listToCDLinkList()
    {
        Iterator it = numbers.iterator();
        while(it.hasNext()) {
            cdll.add(it.next());
        }
    }
    
    public static void writeText(String name)
    {
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter(name));
            for(int i = 0; i < 10; i++) {
                fileout.println(rnd.nextInt(100) + 1);
            }
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
