import java.util.Scanner;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class metodo 
{
    Scanner sc = new Scanner(System.in);
    public LinkedList<objEst_Ingenieria> IngresarEstIng(LinkedList<objEst_Ingenieria> listIng, LinkedList<objPc> listCompu) 
    {
        objEst_Ingenieria ing = new objEst_Ingenieria(); 
        // Verificar si todos los computadores están prestados
        boolean todosPrestados = true;
        for (objPc pc : listCompu) {
            boolean prestado = false;
            for (objEst_Ingenieria inge : listIng) 
            {
                if (inge.getSerial().equals(pc.getSerial())) 
                {
                    prestado = true;
                    break;
                }
            }
            if (!prestado) 
            {
                todosPrestados = false;
                break;
            }
        }

        if (todosPrestados) 
        {
            JOptionPane.showMessageDialog(null, "Todos los computadores ya están prestados. Regresando al menú principal.");
            return listIng; 
        }
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
            JOptionPane.showMessageDialog(null, "Error: Promedio acumulado no valido. Solo permite numero");
            entrada = JOptionPane.showInputDialog("Ingrese el promedio acumulado del estudiante:");
        }
        ing.setPromAcum(Double.parseDouble(entrada));

        // Validar serial
        do 
        {
            entrada = JOptionPane.showInputDialog("Ingrese serial de la tableta a prestar:");
            if (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z0-9]+")) 
            {
            JOptionPane.showMessageDialog(null, "Error: El serial debe contener solo números");
            entrada = ""; //Para que vuelva a repetir el ciclo 
            continue;
            }
            boolean encontrada = false;

            for (objPc pc : listCompu) {
                if (pc.getSerial().equals(entrada)) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                JOptionPane.showMessageDialog(null, "El serial no existe en el inventario");
                entrada = ""; 
                continue;
            }
            boolean yaPrestada = false;
            for (objEst_Ingenieria inge : listIng) 
            {
                if (inge.getSerial().equals(entrada)) 
                {
                    yaPrestada = true;
                    break;
                }
            }

            if (yaPrestada) 
            {
                JOptionPane.showMessageDialog(null, "Ese computador ya está asignada a otro estudiante");
                entrada = "";
                continue;
            }

        } while (entrada.isEmpty());
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
            JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente");
        }
        Mostrar(listIng);
        return listIng;
    }
    
    public LinkedList<objEst_Diseño> IngresarEstDiseño(LinkedList<objEst_Diseño> lisDis, LinkedList<objTablet> listTablet)
    {
        String ingreso = "";
        objEst_Diseño o = new objEst_Diseño();
          boolean todosPrestados = true;
            for (objTablet tab : listTablet) {
                boolean prestado = false;
                for (objEst_Diseño dis : lisDis) {
                    if (dis.getSerial().equals(tab.getSerial())) {
                        prestado = true;
                        break;
                    }
                }
                if (!prestado) {
                    todosPrestados = false;
                    break;
                }
            }

            if (todosPrestados) {
                JOptionPane.showMessageDialog(null, "Todos las tabletas ya están prestados Regresando al menú.");
                return lisDis; // volviendo al menu
            }
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
        do 
        {
            ingreso = JOptionPane.showInputDialog("Ingrese serial de la tableta a prestar:");
            if (ingreso == null || !ingreso.matches("\\d+")) 
            {
            JOptionPane.showMessageDialog(null, "Error: El serial debe contener solo números");
            ingreso = ""; //Para que vuelva a repetir el ciclo 
            continue;
            }
            boolean encontrada = false;
            for (objTablet t : listTablet) {
                if (t.getSerial().equals(ingreso)) {
                    encontrada = true;
                    break;
                }
            }
            if (!encontrada) {
                JOptionPane.showMessageDialog(null, "El serial no existe en el inventario");
                ingreso = ""; 
                continue;
            }
            boolean yaPrestada = false;
            for (objEst_Diseño e : lisDis) {
                if (e.getSerial().equals(ingreso)) {
                    yaPrestada = true;
                    break;
                }
            }
            if (yaPrestada) {
                JOptionPane.showMessageDialog(null, "Esa tableta ya está asignada a otro estudiante");
                ingreso = "";
                continue;
            }
        } while (ingreso.isEmpty());
        o.setSerial(ingreso);
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
            System.out.println("Serial de tableta prestada: " + list.getSerial());
            
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
                JOptionPane.showMessageDialog( null, "Este estudiante ya tiene un prestamo");
                break;
            }
        }
        if(!encontrado)
        {
            lisDis.add(ingresoEstDis);
            JOptionPane.showMessageDialog(null, "Estudiante ingresado correctamente");
        }
        mostrarEstDis(lisDis);
        return lisDis; 
    } 
    public void MostrarTableta(LinkedList<objTablet> listTab) 
    {
        System.out.println("---- TABLETA ---- ");
        for (objTablet tab : listTab) 
        {
            System.out.println("Serial: " + tab.getSerial());
            System.out.println("Marca: " + tab.getMarca());
            System.out.println("-----------------------");
        }

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
    
    public  void registrarTableta(LinkedList<objTablet> listaTabletas) 
    {
        String ingreso;
        objTablet objTab = new objTablet();
        metodo m = new metodo();

        do {
            ingreso = JOptionPane.showInputDialog(null, "Ingrese el serial de la tableta:");
            if (ingreso == null || !ingreso.matches("^[a-zA-Z0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Serial inválido. Solo letras y números sin espacios.");
                ingreso = "";
                continue;
            }

        boolean existe = false; //Que el serial no exista ya
        for (objTablet t : listaTabletas) {
            if (t.getSerial().equalsIgnoreCase(ingreso)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            JOptionPane.showMessageDialog(null, "Ya existe una tableta con ese serial");
            ingreso = "";
        }

    } while (ingreso.isEmpty());
    objTab.setSerial(ingreso);

    do {
        ingreso = JOptionPane.showInputDialog(null, "Ingrese la marca de la tableta:");
        if (ingreso == null || !ingreso.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Marca inválida");
            ingreso = "";
        }
    } while (ingreso.isEmpty());
    objTab.setMarca(ingreso);
    
    do {
        ingreso = JOptionPane.showInputDialog(null, "Ingrese el tamaño de la pantalla (en pulgadas):");
        try {
            float tam = Float.parseFloat(ingreso);
            objTab.setTamaño(tam);
            break;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tamaño inválido");
        }
    } while (true);

    do {
        ingreso = JOptionPane.showInputDialog(null, "Ingrese el precio de la tableta:");
        try {
            float precio = Float.parseFloat(ingreso);
            objTab.setPrecio(precio);
            break;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Precio inválido");
        }
    } while (true);

    do {
        ingreso = JOptionPane.showInputDialog(null, "Ingrese el peso en kg de la tableta:");
        try {
            float peso = Float.parseFloat(ingreso);
            objTab.setPeso(peso);
            break;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Peso inválido");
        }
    } while (true);
    objTab.setAlmacenamiento(m.subMenuAlmacenamiento());
    listaTabletas.add(objTab);
    JOptionPane.showMessageDialog(null, "Tableta registrada con éxito");
    m.MostrarTableta(listaTabletas);
}
    public  String subMenuAlmacenamiento() 
    {
        String opcion = "";
        String almacenamiento = "";

        do {
            opcion = JOptionPane.showInputDialog(
                "Seleccione el tipo de almacenamiento:\n" +
                "1. 256 GB\n" +
                "2. 512 GB\n" +
                "3. 1 TB"
            );

            if (opcion == null || !opcion.matches("[1-3]")) {
                JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente.");
            }
        } while (opcion == null || !opcion.matches("[1-3]"));

        switch (opcion) {
            case "1":
                almacenamiento = "256 GB";
                break;
            case "2":
                almacenamiento = "512 GB";
                break;
            case "3":
                almacenamiento = "1 TB";
                break;
        }
        return almacenamiento;
    }
}
