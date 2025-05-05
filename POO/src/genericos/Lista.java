package genericos;

public class Lista <T> {
    private Object[] data;
    private int count;

    public Lista() {
        data = new Object[10];
    }

    public void add(T value) {
        //System.out.println(value.getClass());
        data[count] = value;
        count++;
    }

    public T get(int index) {
        return (T)data[index];
    }
}
