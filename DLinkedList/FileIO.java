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
        writeNumbersTxt("numbers.txt");
        List<Integer> nums = readFile("numbers.txt");
        System.out.println(nums);
        listToCDLinkList();
        doubleThenWriteFile("newNumbers.txt");
        List<Integer> newNums = readFile("newNumbers.txt");
        System.out.println(newNums);
    }
    
    /**
     * Takes a file and reads it and stores the integers in a List.
     * @param name The name of the file to be read.
     * @return The list of numbers read from the file.
     */
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
    
    /**
     * Adds all the contents of the numbers list to the custom made circular doubly linked list.
     */
    public static void listToCDLinkList()
    {
        for (int i = 0; i < numbers.size(); i++) {
            cdll.add(numbers.get(i));
        }
    }
    
    /**
     * Writes 10 random numbers into a text file.
     * @param name The name of the file to be created and written into.
     */
    public static void writeNumbersTxt(String name)
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
    
    /**
     * Doubles and writes the contents of the custom made circular doubly linked list to a txt file.
     * @param name The name of the file to written.
     */
    public static void doubleThenWriteFile(String name)
    {
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter(name));
            for(int i = 0; i < 10; i++) {
                fileout.println(cdll.get(i) * 2);
            }
            fileout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
