
/**
 * Write a description of interface IDLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ICircDblLinkedList<E>
{
    public void add(E e);
    public void add(int index, E e);
    public void addFirst(E data);
    public void addLast(E data);
    public E delete(int index);
    public E deleteFirst();
    public E deleteLast();
    public int size();
    public void clear();
    public boolean contains(E e);
    public E get(int index);
    public E getFirst();
    public E getLast();
    public void set(int index, E e);
}
