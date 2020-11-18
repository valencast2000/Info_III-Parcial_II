import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

    private int idEventoCaso;
    private char sexo;
    private int edad;
    private String edadTipo; // 1 -> meses //// 0 -> anios
    private String residenciaPais;
    private String residenciaProvincia;
    private String residenciaDepartamento;
    private String cargaProvincia;
    private String fechaInicioSintomas;
    private String fechaApertura;
    private String sepiApertura;
    private String fechaInternacion;
    private boolean cuidadoIntensivo; // Verdadero -> "SI"
    private Date fechaCuidadoIntensivo;
    private String fallecido;
    private String fechaFallecimiento;
    private boolean asistenciaRespiratoriaMecanica; // Verdadero-> "SI"
    private int cargaProvinciaId;
    private boolean origenFinanciamiento; // Verdadero-> Privado, Falso-> Publico
    private String clasificacion;
    private String clasificacionResumen;
    private int residenciaProvinciaId;
    private String fechaDiagnostico;
    private int residenciaDepartamentoId;
    private String ultimaActualizacion; // Fecha

    // ************************** INICIO GETTERS
    // **************************************

    public int getIdEventoCaso() {
        return idEventoCaso;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String isEdadTipo() {
        return edadTipo;
    }

    public String getResidenciaPais() {
        return residenciaPais;
    }

    public String getResidenciaProvincia() {
        return residenciaProvincia;
    }

    public String getResidenciaDepartamento() {
        return residenciaDepartamento;
    }

    public String getCargaProvincia() {
        return cargaProvincia;
    }

    public String getFechaInicioSintomas() {
        return fechaInicioSintomas;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public String getSepiApertura() {
        return sepiApertura;
    }

    public String getFechaInternacion() {
        return fechaInternacion;
    }

    public boolean isCuidadoIntensivo() {
        return cuidadoIntensivo;
    }

    public Date getFechaCuidadoIntensivo() {
        return fechaCuidadoIntensivo;
    }

    public String isFallecido() {
        return fallecido;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public boolean isAsistenciaRespiratoriaMecanica() {
        return asistenciaRespiratoriaMecanica;
    }

    public int getCargaProvinciaId() {
        return cargaProvinciaId;
    }

    public boolean isOrigenFinanciamiento() {
        return origenFinanciamiento;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getClasificacionResumen() {
        return clasificacionResumen;
    }

    public int getResidenciaProvinciaId() {
        return residenciaProvinciaId;
    }

    public String getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public int getResidenciaDepartamentoId() {
        return residenciaDepartamentoId;
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public String getFallecido() {
        return fallecido;
    }

    // **************************FIN GETTERS **************************************

    public void setIdEventoCaso(String idEventoCaso) {
        this.idEventoCaso = Integer.parseInt(idEventoCaso);
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.charAt(0);
    }

    public void setEdad(String edad) {
        this.edad = Integer.parseInt(edad);
    }

    public void setEdadTipo(String edadTipo) {
        this.edadTipo = edadTipo;
    }

    public void setResidenciaPais(String residenciaPais) {
        this.residenciaPais = residenciaPais;
    }

    public void setResidenciaProvincia(String residenciaProvincia) {
        this.residenciaProvincia = residenciaProvincia;
    }

    public void setResidenciaDepartamento(String residenciaDepartamento) {
        this.residenciaDepartamento = residenciaDepartamento;
    }

    public void setCargaProvincia(String cargaProvincia) {
        this.cargaProvincia = cargaProvincia;
    }

    public void setFechaInicioSintomas(String fechaInicioSintomas) {
        this.fechaInicioSintomas = fechaInicioSintomas;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public void setSepiApertura(String sepiApertura) {
        this.sepiApertura = sepiApertura;
    }

    public void setFechaInternacion(String fechaInternacion) {
        this.fechaInternacion = fechaInternacion;
    }

    public void setCuidadoIntensivo(String cuidadoIntensivo) {
        if (cuidadoIntensivo.equals("SI"))
            this.cuidadoIntensivo = true;
        else {
            this.cuidadoIntensivo = false;
        }
    }

    public void setFechaCuidadoIntensivo(String fechaCuidadoIntensivo) throws ParseException {
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaCuidadoIntensivo = null;
        try {
            if (!fechaCuidadoIntensivo.equals("0")) {
                this.fechaCuidadoIntensivo = fecha.parse(fechaCuidadoIntensivo);
            }
        } catch (ParseException e) {

            System.out.println(e);
        }
    }

    public void setFallecido(String fallecido) {
        this.fallecido = fallecido;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public void setAsistenciaRespiratoriaMecanica(String asistenciaRespiratoriaMecanica) {
        if (asistenciaRespiratoriaMecanica.equals("SI"))
            this.asistenciaRespiratoriaMecanica = true;
        else {
            this.asistenciaRespiratoriaMecanica = false;
        }
    }

    public void setCargaProvinciaId(String cargaProvinciaId) {
        this.cargaProvinciaId = Integer.parseInt(cargaProvinciaId);
    }

    public void setOrigenFinanciamiento(String origenFinanciamiento) {
        if (origenFinanciamiento.equals("Privado"))
            this.asistenciaRespiratoriaMecanica = true;
        else {
            this.asistenciaRespiratoriaMecanica = false;
        }
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setClasificacionResumen(String clasificacionResumen) {
        this.clasificacionResumen = clasificacionResumen;
    }

    public void setResidenciaProvinciaId(String residenciaProvinciaId) {
        this.residenciaProvinciaId = Integer.parseInt(residenciaProvinciaId);
    }

    public void setFechaDiagnostico(String fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public void setResidenciaDepartamentoId(String residenciaDepartamentoId) {
        this.residenciaDepartamentoId = Integer.parseInt(residenciaDepartamentoId);
    }

    public void setUltimaActualizacion(String ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
}