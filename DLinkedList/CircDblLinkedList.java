import java.util.List;

/**
 * Write a description of class DLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CircDblLinkedList<E> implements ICircDblLinkedList<E>
{
    private Node<E> start;
    private Node<E> end;
    private int size;
    
    /**
     * Constructs an empty cicular doubly linked list.
     */
    public CircDblLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }

    /**
     * Add data to the list. Adds at the back of the list.
     * @param data The data to be added to the list.
     */
    @Override
    public void add(E data)
    {
        Node<E> node = new Node(data);
        if(start == null) {
            start = node;
            end = start;
            node.setPrev(node);
            node.setNext(node);
        }
        else {
            node.setPrev(end);
            end.setNext(node);
            node.setNext(start);
            start.setPrev(node);
            end = node;
        }
        size++;
    }
    
    /**
     * Add data to the list at the specified index.
     * @param index The index at which the data will be added
     * @param data The data to be added to the list.
     */
    public void add(int index, E data)
    {
        Node<E> node = new Node(data);
        Node<E> pointer = start;
        if(index == 0) {
            addFirst(data);
            return;
        }
        for(int i = 1; i <= size; i++) {
            if(i == index) {
                Node<E> temp = pointer.getNext();
                pointer.setNext(node);
                node.setPrev(pointer);
                node.setNext(temp);
                temp.setPrev(node);
            }
            pointer = pointer.getNext();
        }
        size++;
    }
    
    /**
     * Add data to the front of the list.
     * @param data The data to be added to the frond of the list.
     */
    public void addFirst(E data)
    {
        Node<E> node = new Node(data);
        if(start == null) {
            start = node;
            end = start;
            node.setNext(node);
            node.setPrev(node);
        }
        else {
            node.setPrev(end);
            end.setNext(node);
            start.setPrev(node);
            node.setNext(start);
            start = node;
        }
        size++;
    }
    
    /**
     * Add data to the back of the list.
     * @param data The data to be added to the back of the list.
     */
    public void addLast(E data)
    {
        Node<E> node = new Node(data);
        if(start == null) {
            start = node;
            end = start;
            node.setPrev(node);
            node.setNext(node);
        }
        else {
            node.setPrev(end);
            end.setNext(node);
            node.setNext(start);
            start.setPrev(node);
            end = node;
        }
        size++;
    }
    
    /**
     * Delete data from the list at the specified index position.
     * @param index The index at which the data will be deleted from the list.
     * @return The data deleted.
     */
    public E delete(int index)
    {
        E data = null;
        
        if(index == 0) {
            if(size() == 1) {
                start = null;
                end = null;
                size = 0;
                return data;
            }
            start = start.getNext();
            start.setPrev(end);
            end.setNext(start);
            size--;
            return data;
        }
        
        if(index == size()) {
            end = end.getPrev();
            end.setNext(start);
            start.setPrev(end);
            size--;
            return data;
        }
        
        Node<E> pointer = start;
        for(int i = 1; i < size(); i++) {
            if(i  == index + 1) {
                Node<E> prv = pointer.getPrev();
                Node<E> nxt = pointer.getNext();
                nxt.setPrev(prv);
                prv.setNext(nxt);
                size--;
            }
            pointer = pointer.getNext();
        }

        return data;
    }
    
    /**
     * Deletes data from the front of the list.
     * @return The deleted data.
     */
    public E deleteFirst()
    {
        E data = null;
        
        if(size > 1) {
            data = start.getData();
            start = start.getNext();
            start.setPrev(end);
            end.setNext(start);
            size--;
        }
        else if(size == 1) {
            start = null;
            end = null;
            size = 0;
        }
        
        return data;
    }
    
    /**
     * Deletes data from the end of the list.
     * @return The deleted data
     */
    public E deleteLast()
    {
        E data = null;
        
        if(size > 1) {
            data = end.getData();
            end = end.getPrev();
            end.setNext(start);
            start.setPrev(end);
            size--;
        }
        else if(size == 1) {
            start = null;
            end = null;
            size = 0;
        }
        
        return data;
    }
    
    /**
     * Returns the size of the list.
     * @return The size of the list.
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Deletes everything from the list.
     */
    public void clear()
    {
        if(size > 0) {
            for(int i = 0; i <= size(); i++) {
                delete(i);
            }
            size = 0;
            start = null;
            end = null;
        }
    }
    
    /**
     * Checks the list to see if it contains data specified in the param.
     * @param The data to be searched for within the list.
     * @return True if found, False if not.
     */
    public boolean contains(E data)
    {
        Node<E> pointer = start;
        if(size() > 0) {
            for(int i = 0; i <= size(); i++) {
                if(pointer.getData().equals(data)) {
                    return true;
                }
                pointer = pointer.getNext();
            }
        }
        return false;
    }
    
    /**
     * Returns the data at the specified index location in the list.
     * @param index The index location of the data to be returned.
     * @return The data at the specified index location in the list.
     */
    public E get(int index)
    {
        if(index < size() && index >= 0) {
            Node<E> pointer = start;
            for(int i = 0; i <= size(); i++) {
                if(i == index) {
                    return pointer.getData();
                }
                pointer = pointer.getNext();
            }
        }
        return null;
    }
    
    /**
     * Returns the data at the front of the list.
     * @return The data at the front of the list.
     */
    public E getFirst()
    {
        return start.getData();
    }
    
    /**
     * Returns the data at the back of the list.
     * @return The data at the back of the list.
     */
    public E getLast()
    {
        return end.getData();
    }
    
    /**
     * Sets the specified index location within the list to contain the specified data.
     * @param index The index location within the list for the specified data to be stored.
     * @param data The data to be stored within the list at the specified index location.
     */
    public void set(int index, E data)
    {
        Node<E> node = new Node(data);
        Node<E> pointer = start;
        for(int i = 0; i <= size(); i++) {
            if(index == i) {
                Node<E> nxt = pointer.getNext();
                Node<E> prv = pointer.getPrev();
                nxt.setPrev(node);
                prv.setNext(node);
                node.setPrev(prv);
                node.setNext(nxt);
            }
            pointer = pointer.getNext();
        }
    }
    
}
