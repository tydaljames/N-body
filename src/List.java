public interface List<E> { //Interface used for ArrayList and LinkedList

    E get(int pos);
    boolean add(E t);
    void add(int pos, E t);
    E remove(int pos);
    int size();

}
