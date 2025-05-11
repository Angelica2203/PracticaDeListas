import java.util.LinkedList;
import javax.swing.JOptionPane;
public class metodo 
{
    public LinkedList<objEst_Diseño> IngresarEstDiseño(LinkedList<objEst_Diseño> lisDis)
    {
        String ingreso = "";
        objEst_Diseño o = new objEst_Diseño();
        ingreso = JOptionPane.showInputDialog("Ingrese el cédula del estudiante");
        while (!ingreso.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Cedula no válida. Solo se permiten números.");
            ingreso = JOptionPane.showInputDialog("Ingrese la cedula del estudiante");
        }
        o.setCedula(ingreso);
        ingreso = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        while (ingreso == null || ingreso.trim().isEmpty() || !ingreso.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Nombre no valido. Solo permite letras.");
            ingreso = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        }
        o.setNombre(ingreso);
        ingreso = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        while (ingreso == null || ingreso.trim().isEmpty() || !ingreso.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Nombre no valido. Solo permite letras.");
            ingreso = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        }
        o.setApellido(ingreso);
        ingreso = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
        while (!ingreso.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Telefono no válido. Solo se permiten números.");
            ingreso = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
        }
        o.setTelefono(ingreso);
        do {
            ingreso = JOptionPane.showInputDialog(null, "Ingrese modalidad de estudio: presencial / virtual");

            if (ingreso == null || ingreso.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La modalidad no puede estar vacía.");
                continue;
            }
            ingreso = ingreso.trim().toLowerCase();
            if (!ingreso.equals("virtual") && !ingreso.equals("presencial")) {
            JOptionPane.showMessageDialog(null, "Modalidad inválida. Solo se permite: virtual o presencial.");
            ingreso = ""; // fuerza repetir el ciclo
            }
        }while (ingreso.isEmpty());
        o.setModalidadEstud(ingreso.substring(0, 1).toUpperCase() + ingreso.substring(1));//mayusc inicial
        ingreso =  JOptionPane.showInputDialog(null, "Ingrese cantidad de asignaturas matriculas por el estudiante");
        while (!ingreso.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
            ingreso =  JOptionPane.showInputDialog(null, "Ingrese número entero valido");
        }
        o.setCantAsignat(Integer.parseInt(ingreso));
        return validarExisteEstDis(lisDis,o);//No vaya a ingresar estudiante exixtente
    }
    public void mostrarEstDis (LinkedList<objEst_Diseño> listDis)
    {
        for (objEst_Diseño list : listDis) //Deshapilando para mostrar(es lo mismo que un for normal)
        {
            System.out.println("Cédula: " + list.getCedula());
            System.out.println("Nombre: " + list.getNombre());
            System.out.println("Apellido: " + list.getApellido());
            System.out.println("Telefono: " + list.getTelefono());
            System.out.println("Modalidad: " + list.getModalidadEstud());
            System.out.println("Cant asignaturas: " + list.getCantAsignat());
        }
    }
    public LinkedList<objEst_Diseño> validarExisteEstDis(LinkedList<objEst_Diseño> lisDis, objEst_Diseño ingresoEstDis )
    {
        boolean encontrado = false;
        for(objEst_Diseño est : lisDis)
        {
            if (est.getCedula().equalsIgnoreCase(ingresoEstDis.getCedula())) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog( null, "El estudiante ya existe");
                break;
            }
        }
        if(!encontrado)
        {
            lisDis.offer(ingresoEstDis);
            JOptionPane.showMessageDialog(null, "Estudiante ingresado correctamente");
        }
        mostrarEstDis(lisDis);
        return lisDis; 
    } 
}
