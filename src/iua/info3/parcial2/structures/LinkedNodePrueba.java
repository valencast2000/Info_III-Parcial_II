package structures;

public class LinkedNodePrueba<AnyType> {
    public LinkedNodePrueba<AnyType> next;
    public AnyType data;

    public LinkedNodePrueba(LinkedNodePrueba<AnyType> next, AnyType data) {
        this.next = next;
        this.data = data;
    }
}