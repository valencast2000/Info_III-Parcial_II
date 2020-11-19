import java.util.Date;

public class CuiFecha implements Comparable<CuiFecha> {

    private Date fecha;
    private Test t;

    public CuiFecha(Date fecha, Test test) {
        this.fecha = fecha;
        t = test;
    }

    @Override
    public int compareTo(CuiFecha aux) {
        return fecha.compareTo(aux.fecha);
    }

    @Override
    public String toString() {
        return t.getIdEventoCaso() + "-" + t.getEdad() + "-" + t.isEdadTipo() + "-" + t.getSexo() + "-"
                + t.getResidenciaPais() + "-" + t.getResidenciaProvincia() + "-" + t.getResidenciaDepartamento() + "-"
                + t.getCargaProvincia() + "-" + t.getFechaInicioSintomas() + "-" + t.getFechaApertura() + "-"
                + t.getSepiApertura() + "-" + t.getFechaInternacion() + "-" + t.isCuidadoIntensivo() + "-" // IMPRIME
                                                                                                           // TODOS LOS
                                                                                                           // // DATOS
                + t.getFechaCuidadoIntensivo() + "-" + t.isFallecido() + "-" + t.getFechaFallecimiento() + "-"
                + t.isAsistenciaRespiratoriaMecanica() + "-" + t.getCargaProvinciaId() + "-"
                + t.isOrigenFinanciamiento() + "-" + t.getClasificacionResumen() + "-" + t.getResidenciaProvinciaId()
                + "-" + t.getFechaDiagnostico() + "-" + t.getResidenciaDepartamentoId() + "-"
                + t.getUltimaActualizacion();
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
