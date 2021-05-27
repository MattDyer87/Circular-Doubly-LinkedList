

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DLinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CircDblLinkedListTest
{
    private CircDblLinkedList<Person> people;
    
    /**
     * Default constructor for test class DLinkedListTest
     */
    public CircDblLinkedListTest()
    {
        people = new CircDblLinkedList<>();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        people.add(new Person("Matt", "Dyer", 206582984));
        people.add(new Person("Hannah", "Dieffenthaller", 251346798));
        people.add(new Person("Jon", "Dennis", 164973852));
        people.add(new Person("Ryan", "Flesch", 774689133));
        people.add(new Person("Amanda", "Dailey", 855491668));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        people.clear();
    }
    
    @Test
    public void testAdd()
    {
        assertTrue(people.size() == 5);
    }
    
    @Test
    public void testAddIndex()
    {
        Person x = new Person("Billy", "Joel", 987654321);
        people.add(2, x);
        assertTrue(people.get(2) == x);
        assertTrue(people.size() == 6);
    }
    
    @Test
    public void testAddFirst()
    {
        Person x = new Person("Billy", "Joel", 987654321);
        people.addFirst(x);
        assertTrue(people.getFirst() == x);
        assertTrue(people.size() == 6);
    }
    
    @Test
    public void testAddLast()
    {
        Person x = new Person("Billy", "Joel", 987654321);
        people.addLast(x);
        assertTrue(people.getLast() == x);
        assertTrue(people.size() == 6);
    }
    
    @Test
    public void testDeleteIndex()
    {
        Person x = people.get(3);
        people.delete(3);
        assertFalse(people.contains(x));
        assertTrue(people.size() == 4);
    }
    
    @Test
    public void testDeleteFirst()
    {
        Person x = people.getFirst();
        people.deleteFirst();
        assertFalse(people.contains(x));
        assertTrue(people.size() == 4);
    }
    
    @Test
    public void testDeleteLast()
    {
        Person x = people.getLast();
        people.deleteLast();
        assertFalse(people.contains(x));
        assertTrue(people.size() == 4);
    }
    
    @Test
    public void testSize()
    {
        assertTrue(people.size() == 5);
    }
    
    @Test
    public void testClear()
    {
        Person x = people.get(0);
        people.clear();
        assertTrue(people.size() == 0);
        assertFalse(people.contains(x));
    }
    
    @Test
    public void testContains()
    {
        Person x = people.get(0);
        assertTrue(people.contains(x));
    }
    
    @Test
    public void testGet()
    {
        Person x = people.get(2);
        assertTrue(x.getFirstName() == "Jon");
        assertTrue(x.getLastName() == "Dennis");
        assertTrue(x.getIDNumber() == 164973852);
    }
    
    @Test
    public void testGetFirst()
    {
        Person x = people.getFirst();
        assertTrue(people.get(0) == x);
    }
    
    @Test
    public void testGetLast()
    {
        Person x = people.getLast();
        assertTrue(people.get(4) == x);
    }
    
    @Test
    public void testSet()
    {
        Person x = new Person("John", "Lennon", 254165898);
        people.set(2, x);
        assertTrue(people.get(2) == x);
    }
}
