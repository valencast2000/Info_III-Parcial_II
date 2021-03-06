package structures;

public class LinkedStackPrueba<AnyType> {
    private LinkedNodePrueba<AnyType> cima;
    private int size;

    public void push(AnyType d) {
        cima = new LinkedNodePrueba<>(cima, d);
        size++;
    }

    public void pop() throws Exception {
        if (cima == null)
            throw new Exception("Stack Empty");
        cima = cima.next;
        size--;
    }

    public AnyType top() throws Exception {
        if (cima == null)
            throw new Exception("Stack Empty");
        return cima.data;
    }

    public AnyType topAndPop() throws Exception {
        AnyType d = top();
        pop();
        return d;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return cima == null;
    }
}
