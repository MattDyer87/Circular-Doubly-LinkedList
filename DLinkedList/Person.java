
/**
 * A simple person class for testing a doubly linked circular list. The person does nothing but
 * contains a first name, a last name, and a 9 digit ID number.
 *
 * @author Matthew Dyer
 * @version 2021.05.26
 */
public class Person
{
    // The first name of the Person
    private String firstName;
    // The last name of the Person
    private String lastName;
    // The 9 digit ID number of the Person.
    private int IDNumber;

    /**
     * Creates a Person object for use in testing a doubly linked circular list. The Person
     * does nothing but contain information.
     * @param firstName The first name of the Person.
     * @param lastName The last name of the Person.
     * @param IDNumber The 9 digit ID number of the Person.
     */
    public Person(String firstName, String lastName, int IDNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.IDNumber = IDNumber;
    }

    /**
     * Returns the first name of the Person.
     * @return The first name of the Person.
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Returns the last name of the Person.
     * @return The last name of the Person.
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Returns the ID number of the Person.
     * @return The ID number of the Person.
     */
    public int getIDNumber()
    {
        return IDNumber;
    }
    
    @Override
    public boolean equals(Object p) {
        if(this == p) {
            return true;
        }
        if(!(p instanceof Person)) {
            return false;
        }
        Person person = (Person) p;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName) && 
                                        Integer.compare(IDNumber, person.IDNumber) == 0;
    }
    
}
