import java.util.LinkedList;
import javax.swing.JOptionPane;
public class metodo 
{
    public LinkedList<objEst_Diseño> IngresarEstDiseño(LinkedList<objEst_Diseño> lisDis)
    {
        String ingreso = "";
        objEst_Diseño o = new objEst_Diseño();
        do {
            ingreso = JOptionPane.showInputDialog("Ingrese la cédula del estudiante");
            
            if (ingreso == null) {
                JOptionPane.showMessageDialog(null, "Debe ingresar la cédula del estudiante");
            } else if (ingreso.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La cédula no puede estar vacía");
            }
            
        } while (ingreso == null || ingreso.trim().isEmpty());
        o.setCedula(ingreso);
        do {
            ingreso = JOptionPane.showInputDialog("Ingrese la nombre del estudiante");
            
            if (ingreso == null || ingreso.trim().isEmpty())  {
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre, no puede estar vacio");
            } else if (!ingreso.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
                JOptionPane.showMessageDialog(null, "El nombre no puede contener números ni letras especiales");
                ingreso = ""; //para que el ciclo vuelva a repetirse 
            }
            
        } while (ingreso == null || ingreso.trim().isEmpty());
        o.setNombre(ingreso);
        do {
            ingreso = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
            
            if (ingreso == null) {
                JOptionPane.showMessageDialog(null, "Debe ingresar el apellido del estudiante");
            } else if (ingreso.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El apellido no puede estar vacío");
            }
            
        } while (ingreso == null || ingreso.trim().isEmpty());
        o.setApellido(ingreso);
        


    }
}
