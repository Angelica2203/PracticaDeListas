import java.util.Scanner;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class metodo 
{
    Scanner sc = new Scanner(System.in);
    public LinkedList<objEst_Ingenieria> IngresarEstIng(LinkedList<objEst_Ingenieria> listIng, LinkedList<objPc> listCompu) 
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

        // Validar serial
        entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z0-9]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Serial no valido. Solo permite letras y numeros.");
            entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
        }
        for (objEst_Ingenieria ingen : listIng) 
        {
            if (ingen.getSerial().equals(entrada)) 
            {
                JOptionPane.showMessageDialog(null, "Este serial ya existe");
                entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
            }
        }
        // Validar que el serial no exista en la lista de computadores
        for (objPc compu : listCompu) 
        {
            if (compu.getSerial().equals(entrada)) 
            {
                JOptionPane.showMessageDialog(null, "El serial no existe en la lista de computadores");
                entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
            }
        }
        ing.setSerial(entrada);
        return ValidarEstIng(listIng, ing);

    }
    public void Mostrar(LinkedList<objEst_Ingenieria> listIng) 
    {
        System.out.println("---- ESTUDIANTES INGENIERIA ---- ");
        for (objEst_Ingenieria inge : listIng) 
        {
            System.out.println("Cedula: " + inge.getCedula());
            System.out.println("Nombre: " + inge.getNombre());
            System.out.println("Semestre: " + inge.getNumSemestre());
            System.out.println("Serial Prestado: " + inge.getSerial());
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
                JOptionPane.showMessageDialog(null, "Este estudiante ya tiene un prestamo");
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
    public LinkedList<objPc> IngresarComputador(LinkedList<objPc> listCompu) 
    {
        objPc compu = new objPc();
        String entrada;
        entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z0-9]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Serial no valido. Solo permite letras y numeros.");
            entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
        }
        compu.setSerial(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese la marca del computador:");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Marca no valida. Solo permite letras.");
            entrada = JOptionPane.showInputDialog("Ingrese la marca del computador:");
        }
        compu.setMarca(entrada);
        //Validar decimal
        entrada = JOptionPane.showInputDialog("Ingrese el tamaño del computador:");
        while (!entrada.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Tamaño no valido. Solo permite numero.");
            entrada = JOptionPane.showInputDialog("Ingrese el tamaño del computador:");
        }
        compu.setTamaño(Double.parseDouble(entrada));

        //Validar decimal
        entrada = JOptionPane.showInputDialog("Ingrese el precio del computador:");
        while (!entrada.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Precio no valido. Solo permite numero.");
            entrada = JOptionPane.showInputDialog("Ingrese el precio del estudiante:");
        }
        compu.setPrecio(Double.parseDouble(entrada));
        return ValidarCompu(listCompu, compu);
    }
    public void MostrarCompu(LinkedList<objPc> listCompu) 
    {
        System.out.println("---- COMPUTADOR ---- ");
        for (objPc pc : listCompu) 
        {
            System.out.println("Serial: " + pc.getSerial());
            System.out.println("Marca: " + pc.getMarca());
            System.out.println("-----------------------");
        }

    }
    public LinkedList<objPc> ValidarCompu(LinkedList<objPc> listCompu, objPc pc) 
    {
        boolean encontrado = false;
        for (objPc compu : listCompu) 
        {
            if (compu.getSerial().equals(pc.getSerial())) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog(null, "El computador ya existe");
                break;
            }
        }
        if (!encontrado) 
        {
            listCompu.add(pc);
            JOptionPane.showMessageDialog(null, "Computador ingresado correctamente");
        }
        MostrarCompu(listCompu);
        return listCompu;
    }
    
}
