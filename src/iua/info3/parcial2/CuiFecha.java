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
        return fecha.compareTo(aux.fecha);
    }

    @Override
    public String toString() {
        return ("-" + test.getFechaCuidadoIntensivo() + "");
    }
    /*
     * return (test.getIdEventoCaso() + " - " + test.getEdad() + " - " +
     * test.isEdadTipo() + " - " + test.getSexo() + " - " + test.getResidenciaPais()
     * + " - " + test.getResidenciaProvincia() + " - " +
     * test.getResidenciaDepartamento() + " - " + test.getCargaProvincia() + " - " +
     * test.getFechaInicioSintomas() + " - " + test.getFechaApertura() + " - " +
     * test.getSepiApertura() + " - " + test.getFechaInternacion() + " - " +
     * test.isCuidadoIntensivo() + " - " + test.getFechaCuidadoIntensivo() + " - " +
     * test.isFallecido() + " - " + test.getFechaFallecimiento() + " - " +
     * test.isAsistenciaRespiratoriaMecanica() + " - " + test.getCargaProvinciaId()
     * + " - " + test.isOrigenFinanciamiento() + " - " + test.getClasificacion() +
     * " - " + test.getClasificacionResumen() + " - " +
     * test.getResidenciaProvinciaId() + " - " + test.getFechaDiagnostico() + " - "
     * + test.getResidenciaDepartamentoId() + " - " +
     * test.getUltimaActualizacion()); }
     */

}
