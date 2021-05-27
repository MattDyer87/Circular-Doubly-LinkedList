
/**
 * A node is a position within a doubly linked circular list that stores data,
 * and which node is next and previous
 * 
 *
 * @author Matthew Dyer
 * @version 2021.05.26
 */
public class Node<E>
{
    // The data to be stored in a node.
    private E data;
    // The next node in the linked list.
    private Node<E> next;
    // The previous node in the linked list.
    private Node<E> prev;

    /**
     * Creates a node that stores data.
     * @param data The data to be store in the node.
     */
    public Node(E data)
    {
        this.data = data;
        next = null;
        prev = null;
    }

    /**
     * Sets the next node in the linked list to the param.
     * @param node The node to be set as next in the linked list.
     */
    public void setNext(Node<E> node)
    {
        this.next = node;
    }
    
    /**
     * Sets the previous node in the linked list to the param.
     * @param node The node to be set as previous in the linked list.
     */
    public void setPrev(Node<E> node)
    {
        this.prev = node;
    }
    
    /**
     * Returns the data stored in the node.
     * @return The data stored in the node.
     */
    public E getData()
    {
        return data;
    }
    
    /**
     * Returns the next node in the linked list.
     * @return The next node in the linked list.
     */
    public Node<E> getNext()
    {
        return next;    
    }
    
    /**
     * Returns the previous node in the linked list.
     * @return The previous node in the linked list.
     */
    public Node<E> getPrev()
    {
        return prev;
    }
    
}
