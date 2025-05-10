public class objPc 
{
    private String serial;
    private String marca;
    private double tamaño;
    private double precio;
    private String sisOperativo;
    private String procesador;
    public objPc() 
    {
    }
    public objPc(String serial, String marca, double tamaño, double precio, String sisOperativo, String procesador) 
    {
        this.serial = serial;
        this.marca = marca;
        this.tamaño = tamaño;
        this.precio = precio;
        this.sisOperativo = sisOperativo;
        this.procesador = procesador;
    }
    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getTamaño() {
        return tamaño;
    }
    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getSisOperativo() {
        return sisOperativo;
    }
    public void setSisOperativo(String sisOperativo) {
        this.sisOperativo = sisOperativo;
    }
    public String getProcesador() {
        return procesador;
    }
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }
    
    

    
    
}
