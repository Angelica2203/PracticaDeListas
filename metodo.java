import java.util.Scanner;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class metodo 
{
    Scanner sc = new Scanner(System.in);
    public LinkedList<objEst_Ingenieria> IngresarEstIng(LinkedList<objEst_Ingenieria> listIng) 
    {
        objEst_Ingenieria ing = new objEst_Ingenieria(); 
        // Valida vacios
        String entrada;
        entrada = JOptionPane.showInputDialog("Ingrese la cedula del estudiante:");
        while (!entrada.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Cedula no válida. Solo se permiten números.");
            entrada = JOptionPane.showInputDialog("Ingrese la cedula del estudiante");
        }
        ing.setCedula(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Nombre no valido. Solo permite letras.");
            entrada = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        }
        ing.setNombre(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Apellido no valido. Solo permite letras.");
            entrada = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        }
        ing.setApellido(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
        while (!entrada.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Telefono no valido. Solo permite numeros.");
            entrada = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
        }
        ing.setTelefono(entrada);
        // Validar int
        entrada = JOptionPane.showInputDialog("Ingrese el numero de semestre que esta cursando actualmente:");
        while (!entrada.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Numero de semestre no valido. Solo permite numeros.");
            entrada = JOptionPane.showInputDialog("Ingrese el numero de semestre que esta cursando actualmente");
        }
        ing.setNumSemestre(Integer.parseInt(entrada));

        //Validar decimal
        entrada = JOptionPane.showInputDialog("Ingrese el promedio acumulado del estudiante:");
        while (!entrada.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Promedio acumulado no valido. Solo permite numero.");
            entrada = JOptionPane.showInputDialog("Ingrese el promedio acumulado del estudiante:");
        }
        ing.setPromAcum(Double.parseDouble(entrada));
        return ValidarEstIng(listIng, ing);
    }
    public void Mostrar(LinkedList<objEst_Ingenieria> listIng) 
    {
        for (objEst_Ingenieria inge : listIng) 
        {
            System.out.println("Cedula: " + inge.getCedula());
            System.out.println("Nombre: " + inge.getNombre());
            System.out.println("Apellido: " + inge.getApellido());
            System.out.println("Telefono: " + inge.getTelefono());
            System.out.println("Semestre: " + inge.getNumSemestre());
            System.out.println("Promedio: " + inge.getPromAcum());
            System.out.println("-----------------------");
        }

    }
    public LinkedList<objEst_Ingenieria> ValidarEstIng(LinkedList<objEst_Ingenieria> listIng, objEst_Ingenieria ObjIng) 
    {
        boolean encontrado = false;
        for (objEst_Ingenieria ing : listIng) 
        {
            if (ing.getCedula().equalsIgnoreCase(ObjIng.getCedula())) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog(null, "El estudiante ya existe");
                break;
            }
        }
        if (!encontrado) 
        {
            listIng.add(ObjIng);
            JOptionPane.showMessageDialog(null, "Estudiante ingresado correctamente");
        }
        Mostrar(listIng);
        return listIng;
    }
    
}
