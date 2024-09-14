public interface ListInterface<T>{
    void add(T element);
    T remove(int index);
    T get(int index);
    int size();
    boolean isEmpty();
}