import java.util.Date;

public class CuiFecha implements Comparable<CuiFecha> {

    private Date fecha;
    private Test test;

    public CuiFecha(Date fecha, Test test) {
        this.fecha = fecha;
        this.test = test;
    }

    @Override
    public int compareTo(CuiFecha aux) {
        if (fecha.compareTo(aux.fecha) < 0) {
            return -1; // mayor
        } else if (fecha.compareTo(aux.fecha) > 0) {
            return 1; // menor
        } else {
            return 0; // iguales
        }
    }
}
