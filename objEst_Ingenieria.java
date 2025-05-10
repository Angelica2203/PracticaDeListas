public class objEst_Ingenieria 
{
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private int numSemestre; 
    private Double promAcum;
    private String serial;
    public objEst_Ingenieria() {
    }
    public objEst_Ingenieria(String cedula, String nombre, String apellido, String telefono, int numSemestre,
            Double promAcum, String serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.numSemestre = numSemestre;
        this.promAcum = promAcum;
        this.serial = serial;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getNumSemestre() {
        return numSemestre;
    }
    public void setNumSemestre(int numSemestre) {
        this.numSemestre = numSemestre;
    }
    public Double getPromAcum() {
        return promAcum;
    }
    public void setPromAcum(Double promAcum) {
        this.promAcum = promAcum;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    
    
}
