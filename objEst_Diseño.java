public class objEst_Diseño 
{
    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String modalidadEstud; 
    private int cantAsignat;
    private String serial;
    public objEst_Diseño() {
    }
    public objEst_Diseño(String cedula, String nombre, String apellido, String telefono, String modalidadEstud,
            int cantAsignat, String serial) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.modalidadEstud = modalidadEstud;
        this.cantAsignat = cantAsignat;
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
    public String getModalidadEstud() {
        return modalidadEstud;
    }
    public void setModalidadEstud(String modalidadEstud) {
        this.modalidadEstud = modalidadEstud;
    }
    public int getCantAsignat() {
        return cantAsignat;
    }
    public void setCantAsignat(int cantAsignat) {
        this.cantAsignat = cantAsignat;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    
}
