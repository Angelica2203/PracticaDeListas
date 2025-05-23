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
        for (objPc pc : listCompu) 
        {
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
            JOptionPane.showMessageDialog(null, "Todos los computadores ya están prestados. Regresando al menú");
            return listIng; 
        }
        // Valida vacios
        String entrada;
        entrada = JOptionPane.showInputDialog("Ingrese la cedula del estudiante");
        while (!entrada.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Cedula no válida. Solo se permiten números");
            entrada = JOptionPane.showInputDialog("Ingrese la cedula del estudiante");
        }
        ing.setCedula(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Nombre no valido. Solo permite letras");
            entrada = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
        }
        ing.setNombre(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Apellido no valido. Solo permite letras");
            entrada = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
        }
        ing.setApellido(entrada);

        entrada = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
        while (!entrada.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Telefono no valido. Solo permite numeros");
            entrada = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
        }
        ing.setTelefono(entrada);
        // Validar int
        entrada = JOptionPane.showInputDialog("Ingrese el numero de semestre que esta cursando actualmente");
        while (!entrada.matches("\\d+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Numero de semestre no valido. Solo permite numeros");
            entrada = JOptionPane.showInputDialog("Ingrese el numero de semestre que esta cursando actualmente");
        }
        ing.setNumSemestre(Integer.parseInt(entrada));

        //Validar decimal
        entrada = JOptionPane.showInputDialog("Ingrese el promedio acumulado del estudiante");
        while (!entrada.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Promedio acumulado no valido. Solo permite numero");
            entrada = JOptionPane.showInputDialog("Ingrese el promedio acumulado del estudiante");
        }
        ing.setPromAcum(Double.parseDouble(entrada));

        // Validar serial
        do 
        {
            entrada = JOptionPane.showInputDialog("Ingrese serial de la tableta a prestar");
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
                JOptionPane.showMessageDialog(null, "Todos las tabletas ya están prestados Regresando al menú");
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
            JOptionPane.showMessageDialog(null, "Modalidad inválida. Solo se permite: virtual o presencial");
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
        for (objEst_Diseño list : listDis) 
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
            System.out.println("Almacenamiento: " + tab.getAlmacenamiento());
            System.out.println("-----------------------");
        }

    }
    public LinkedList<objPc> IngresarComputador(LinkedList<objPc> listCompu) 
    {
        objPc compu = new objPc();
        String entrada;
        entrada = JOptionPane.showInputDialog("Ingrese el serial del computador");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z0-9]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Serial no valido, solo permite letras y numeros.");
            entrada = JOptionPane.showInputDialog("Ingrese el serial del computador:");
            
        }
        compu.setSerial(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese la marca del computador");
        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Marca no valida, solo permite letras.");
            entrada = JOptionPane.showInputDialog("Ingrese la marca del computador:");
        }
        compu.setMarca(entrada);
        //Validar decimal
        entrada = JOptionPane.showInputDialog("Ingrese el tamaño del computador");
        while (!entrada.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Tamaño no valido, solo permite numero.");
            entrada = JOptionPane.showInputDialog("Ingrese el tamaño del computador:");
        }
        compu.setTamaño(Double.parseDouble(entrada));

        //Validar decimal
        entrada = JOptionPane.showInputDialog("Ingrese el precio del computador");
        while (!entrada.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Precio no valido, solo permite numero.");
            entrada = JOptionPane.showInputDialog("Ingrese el precio del estudiante:");
        }
        compu.setPrecio(Double.parseDouble(entrada));
        compu.setSisOperativo(subMenuSisOperativo());
        compu.setProcesador(subMenuProcesador());
        return ValidarCompu(listCompu, compu);
    }
    public void MostrarCompu(LinkedList<objPc> listCompu) 
    {
        System.out.println("---- COMPUTADOR ---- ");
        for (objPc pc : listCompu) 
        {
            System.out.println("Serial: " + pc.getSerial());
            System.out.println("Marca: " + pc.getMarca());
            System.out.println("Sistema Operativo: " + pc.getSisOperativo());
            System.out.println("Procesador: " + pc.getProcesador());
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
    
    public LinkedList<objTablet> registrarTableta(LinkedList<objTablet> listaTabletas) 
    {
        String ingreso;
        objTablet objTab = new objTablet();
        do {
            ingreso = JOptionPane.showInputDialog(null, "Ingrese el serial de la tableta:");
            if (ingreso == null || !ingreso.matches("^[a-zA-Z0-9]+$")) {
                JOptionPane.showMessageDialog(null, "Serial inválido, solo letras y números sin espacios");
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
        ingreso = JOptionPane.showInputDialog("Ingresa la marca de la tableta");
        while (ingreso == null || ingreso.trim().isEmpty() || !ingreso.matches("[a-zA-Z ]+")) 
        {
            JOptionPane.showMessageDialog(null, "Error: marca no válida, solo se permiten números.");
            ingreso = JOptionPane.showInputDialog("Ingrese la marca del estudiante"); 
        }
        objTab.setMarca(ingreso);
        ingreso = JOptionPane.showInputDialog("Ingrese el tamaño de la tableta:");
        while (!ingreso.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: Tamaño no valido. Solo permite numero.");
            ingreso = JOptionPane.showInputDialog("Ingrese el tamaño de la tableta:");
        }
        objTab.setTamaño(Double.parseDouble(ingreso));
        ingreso = JOptionPane.showInputDialog("Ingrese el precio de la tableta:");
        while (!ingreso.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: precio no valido. Solo permite numero.");
            ingreso = JOptionPane.showInputDialog("Ingrese el precio de la tableta:");
        }
        objTab.setPrecio(Double.parseDouble(ingreso));
        ingreso = JOptionPane.showInputDialog("Ingrese el peso de la tableta:");
        while (!ingreso.matches("\\d+([.,]\\d+)?")) 
        {
            JOptionPane.showMessageDialog(null, "Error: peso no valido. Solo permite numero.");
            ingreso = JOptionPane.showInputDialog("Ingrese el peso de la tableta:");
        }
        objTab.setPeso(Double.parseDouble(ingreso));
        objTab.setAlmacenamiento(subMenuAlmacenamiento());
        return ValidarTableta(listaTabletas, objTab);
    }
    public LinkedList<objTablet> ValidarTableta(LinkedList<objTablet> listTab, objTablet tab) 
    {
        boolean encontrado = false;
        for (objTablet t : listTab) 
        {
            if (t.getSerial().equals(tab.getSerial())) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog(null, "La tableta ya existe");
                break;
            }
        }
        if (!encontrado) 
        {
            listTab.add(tab);
            JOptionPane.showMessageDialog(null, "Tableta ingresado correctamente");
        }
        MostrarTableta(listTab);
        return listTab;
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
    public LinkedList<objEst_Diseño> modificarEstDis (LinkedList<objEst_Diseño> lisDis)
    {
        while (lisDis.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return lisDis;
        }
        String modific = JOptionPane.showInputDialog("Ingresar cedula del estudiante o el serial de la tableta prestada");
        String ingreso ="";
        boolean amodif = false;
        for(objEst_Diseño est : lisDis)
        {
            if(est.getSerial().equals(modific) || est.getCedula().equals(modific))
            {
                amodif = true;
                String opcModif = JOptionPane.showInputDialog("Ingrese la opción a modificar\n" + "1: Nombre\n" + 
                                                            "2: Apellido\n" +"3: Telefono\n" + "4: Modalidad de estudio\n" + "5: Cantidad de asignaturas");                                  
                while ( opcModif == null || !opcModif.matches("[1-5]") ) 
                {
                   JOptionPane.showMessageDialog(null, "Opción inválida, solo entre 1 - 5, intente nuevamente");
                   opcModif = JOptionPane.showInputDialog("Ingrese la opción a modificar\n" + "1: Nombre\n" +
                                                            "2: Apellido\n" +"3: Telefono\n" + "4: Modalidad de estudio\n" + "5: Cantidad de asignaturas");            
                }
                switch (opcModif) 
                {
                    case "1":
                    ingreso = JOptionPane.showInputDialog("Ingrese el nuevo nombre del estudiante");
                    while (ingreso == null || ingreso.trim().isEmpty() || !ingreso.matches("[a-zA-Z ]+")) 
                    {
                        JOptionPane.showMessageDialog(null, "Error: Nombre no valido, solo permite letras");
                        ingreso = JOptionPane.showInputDialog("Ingrese el nombre del estudiante");
                    }
                    est.setNombre(ingreso);
                    break;
                    case "2":
                    ingreso = JOptionPane.showInputDialog("Ingrese el nuevo apellido del estudiante");
                    while (ingreso == null || ingreso.trim().isEmpty() || !ingreso.matches("[a-zA-Z ]+")) 
                    {
                        JOptionPane.showMessageDialog(null, "Error: Nombre no valido, solo permite letras");
                        ingreso = JOptionPane.showInputDialog("Ingrese el apellido del estudiante");
                    }
                    est.setApellido(ingreso);
                    break;
                    case "3":
                    ingreso = JOptionPane.showInputDialog("Ingrese el nuevo telefono del estudiante");
                    while (!ingreso.matches("\\d+")) 
                    {
                        JOptionPane.showMessageDialog(null, "Error: Telefono no válido, solo se permiten números");
                        ingreso = JOptionPane.showInputDialog("Ingrese el telefono del estudiante");
                    }
                    est.setTelefono(ingreso);
                    break;
                    case "4":
                    do 
                    {
                        ingreso = JOptionPane.showInputDialog(null, "Ingrese la nueva modalidad de estudio: presencial / virtual");

                        if (ingreso == null || ingreso.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La modalidad no puede estar vacía.");
                            continue;
                        }
                        ingreso = ingreso.trim().toLowerCase();
                        if (!ingreso.equals("virtual") && !ingreso.equals("presencial")) {
                        JOptionPane.showMessageDialog(null, "Modalidad inválida, solo se permite: virtual o presencial");
                        ingreso = ""; // fuerza repetir el ciclo
                        }
                    }while (ingreso.isEmpty());
                    est.setModalidadEstud(ingreso.substring(0, 1).toUpperCase() + ingreso.substring(1));//mayusc inicial
                    break;
                    case "5":
                    ingreso =  JOptionPane.showInputDialog(null, "Ingrese nueva cantidad de asignaturas matriculas por el estudiante");
                    while (!ingreso.matches("\\d+")) 
                    {
                        JOptionPane.showMessageDialog(null, "Dato no valido, reintente");
                        ingreso =  JOptionPane.showInputDialog(null, "Ingrese número entero valido");
                    }
                    est.setCantAsignat(Integer.parseInt(ingreso));
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "Opción no disponible");
                    break;
                }
                System.out.println("ESTUDIANTE MODIFICADO");
                System.out.println("Nuevo nombre: " + est.getNombre());
                System.out.println("Nuevo apellido: " + est.getApellido());
                System.out.println("Nuevo telefono:" + est.getTelefono());
                System.out.println("Nueva modalidad:" + est.getModalidadEstud());
                System.out.println("Nueva cantidad de asignaturas:" + est.getCantAsignat());
                System.out.println("---------------------------------------------");  
            }
        }
        if(!amodif)
        {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
            return lisDis; 
        }
        return lisDis;
    }
    
    public String subMenuSisOperativo() 
    {
        String opcion = "";
        String sis = "";

        do {
            opcion = JOptionPane.showInputDialog(
                "Sistema Operativo:\n" +
                "1. Windows 7\n" +
                "2. Windows 10\n" +
                "3. Windows 11");

            if (opcion == null || !opcion.matches("[1-3]")) {
                JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente");
            }
        } while (opcion == null || !opcion.matches("[1-3]"));

        switch (opcion) {
            case "1":
                sis = "Windows 7";
                break;
            case "2":
                sis = "Windows 10";
                break;
            case "3":
                sis = "Windows 11";
                break;
        }
        return sis;
    }
    public  String subMenuProcesador() 
    {
        String opcion = "";
        String procesador = "";

        do {
            opcion = JOptionPane.showInputDialog(
                "       Procesador\n" +
                "1. AMD Ryzen\n" +
                "2. Intel® Core™ i5");

            if (opcion == null || !opcion.matches("[1-2]")) {
                JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente");
            }
        } while (opcion == null || !opcion.matches("[1-2]"));

        switch (opcion) 
        {
            case "1":
                procesador = "AMD Ryzen";
                break;
            case "2":
                procesador = "Intel® Core™ i5";
                break;
        }
        return procesador;
        
    }
    public LinkedList<objEst_Ingenieria> modificarIng(LinkedList<objEst_Ingenieria> listIng )
    {
        while (listIng.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return listIng;
        }
        String CCoSerial = JOptionPane.showInputDialog("Ingrese la cédula del estudiante o el serial del computador prestado a modificar");
        boolean encontrado = false;
        String entrada;
        for (objEst_Ingenieria ing : listIng) 
        {
            if (ing.getCedula().equals(CCoSerial) || ing.getSerial().equals(CCoSerial)) 
            {
                encontrado = true;
                String modificar = JOptionPane.showInputDialog("¿Que desea modificar?\n" +
                                                               "1. Nombre\n" +
                                                               "2. Apellido\n" +
                                                               "3. Telefono\n" +
                                                               "4. Semestre\n" +
                                                               "5. Promedio Acumulado\n" );
                while (modificar == null || !modificar.matches("[1-5]")) 
                {
                    JOptionPane.showMessageDialog(null, "Opción no valida, intente nuevamente");
                    modificar = JOptionPane.showInputDialog("¿Que desea modificar?\n" +
                                                            "1. Nombre\n" +
                                                            "2. Apellido\n" +
                                                            "3. Telefono\n" +
                                                            "4. Semestre\n" +
                                                            "5. Promedio Acumulado\n" );    
                }
                switch (modificar) 
                {
                    case "1":
                        entrada = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
                        {
                            JOptionPane.showMessageDialog(null, "Error: Nombre no valido. Solo permite letras");
                            entrada = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                        }
                        ing.setNombre(entrada);
                        break;
                    case "2":
                        entrada = JOptionPane.showInputDialog("Ingrese el nuevo apellido");
                        while (entrada == null || entrada.trim().isEmpty() || !entrada.matches("[a-zA-Z ]+")) 
                        {
                            JOptionPane.showMessageDialog(null, "Error: Apellido no valido. Solo permite letras");
                            entrada = JOptionPane.showInputDialog("Ingrese el nuevo apellido");
                        }
                        ing.setApellido(entrada);
                        break;
                    case "3":
                        entrada = JOptionPane.showInputDialog("Ingrese el nuevo telefono");
                        while (!entrada.matches("\\d+")) 
                        {
                            JOptionPane.showMessageDialog(null, "Error: Telefono no valido. Solo permite numeros");
                            entrada = JOptionPane.showInputDialog("Ingrese el nuevo telefono ");
                        }
                        ing.setTelefono(entrada);
                        break;
                    case "4":
                        entrada = JOptionPane.showInputDialog("Ingrese el nuevo semestre");
                        while (!entrada.matches("\\d+")) 
                        {
                            JOptionPane.showMessageDialog(null, "Error: Numero de semestre no valido. Solo permite numeros");
                            entrada = JOptionPane.showInputDialog("Ingrese el nuevo semestre");
                        }
                        ing.setNumSemestre(Integer.parseInt(entrada));
                        break;
                    case "5":
                        entrada = JOptionPane.showInputDialog("Ingrese el nuevo promedio acumulado");
                        while (!entrada.matches("\\d+([.,]\\d+)?")) 
                        {
                            JOptionPane.showMessageDialog(null, "Error: Promedio acumulado no valido. Solo permite numero");
                            entrada = JOptionPane.showInputDialog("Ingrese el nuevo promedio acumulado");
                        }
                        ing.setPromAcum(Double.parseDouble(entrada));
                        break;
                }
                System.out.println("REGISTRO MODIFICADO" +
                                   "\nNombre: " + ing.getNombre() +
                                   "\nApellido: " + ing.getApellido() +
                                   "\nTelefono: " + ing.getTelefono() +
                                   "\nSemestre: " + ing.getNumSemestre() +
                                   "\nPromedio Acumulado: " + ing.getPromAcum());
                break;

            }
            if (!encontrado) 
            {
                JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
                return listIng; 
            }
        }
        return listIng; 
    }
    public LinkedList<objEst_Diseño> devolverEstDis (LinkedList<objEst_Diseño> lisDis)
    {
        while (lisDis.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return lisDis;
        }
        String devolv = JOptionPane.showInputDialog("Ingresar cedula del estudiante o el serial de la tableta a devolver");
        boolean devolver = false;
        for(objEst_Diseño est : lisDis)
        {
            if(est.getSerial().equals(devolv) || est.getCedula().equals(devolv))
            {
                devolver = true;
                lisDis.remove(est);
                JOptionPane.showMessageDialog(null, "Tableta devuelta correctamente");
                break;
            }  
        }
        if(!devolver)
        {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
            return lisDis; 
        }
        return lisDis;
    }
     public LinkedList<objEst_Diseño> buscarTabPrest (LinkedList<objEst_Diseño> lisDis)
    {
        while (lisDis.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return lisDis;
        }
        String buscar = JOptionPane.showInputDialog("Ingresar cedula del estudiante o el serial de la tableta a buscar");
        boolean encont = false;
        for(objEst_Diseño est : lisDis)
        {
            if(est.getSerial().equals(buscar) || est.getCedula().equals(buscar))
            {
                encont = true;
                JOptionPane.showMessageDialog(null, "DATOS DEL ESTUDIANTE BUSCADO\n"+
                         "Nombre:" + est.getNombre()+"\n" + "Apellido: " + est.getApellido() +"\n" +
                         "Cedula: "+ est.getCedula() + "\n" + "Telefono: " + est.getTelefono() + "\n" +
                         "Modalidad de estudio: " + est.getModalidadEstud() +"\n" + 
                         "Cantidad de asignatura: " + est.getCantAsignat() + "\n" + "Serial de la tableta: " + est.getSerial() ); 
                break;
            }  
        }
        if(!encont)
        {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
            return lisDis; 
        }
        return lisDis;
    }

    
    public LinkedList<objEst_Ingenieria> devolverPC(LinkedList<objEst_Ingenieria> listIng) 
    {
        while (listIng.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return listIng;
        }
        String CCoSerial = JOptionPane.showInputDialog("Ingrese la cédula del estudiante o el serial del computador prestado a devolver");
        boolean encontrado = false;
        for (objEst_Ingenieria ing : listIng) 
        {
            if (ing.getSerial().equals(CCoSerial) || ing.getCedula().equals(CCoSerial)) 
            {
                encontrado = true;
                listIng.remove(ing);
                JOptionPane.showMessageDialog(null, "Computador devuelto correctamente");
                break;
            }
        }
        if (!encontrado) 
        {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
        }
        return listIng;
    }
    public LinkedList<objEst_Ingenieria> buscarPCprestada(LinkedList<objEst_Ingenieria> listIng) 
    {
        while (listIng.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return listIng;
        }
        String CCoSerial = JOptionPane.showInputDialog("Ingrese la cédula del estudiante o el serial del computador prestado a devolver");
        boolean encontrado = false;
        for (objEst_Ingenieria ing : listIng) 
        {
            if (ing.getSerial().equals(CCoSerial) || ing.getCedula().equals(CCoSerial)) 
            {
                encontrado = true;
                JOptionPane.showMessageDialog(null, "DATOS DEL ESTUDIANTE BUSCADO" +
                                                                    "\nNombre: " + ing.getNombre() +
                                                                    "\nApellido: " + ing.getApellido() +
                                                                    "\nTelefono: " + ing.getTelefono() +
                                                                    "\nSemestre: " + ing.getNumSemestre() +
                                                                    "\nPromedio Acumulado: " + ing.getPromAcum() +
                                                                    "\nSerial del computador prestado: " + ing.getSerial());
                break;
            }
        }
        if (!encontrado) 
        {
            JOptionPane.showMessageDialog(null, "Computador no prestado");
        }
        return listIng;
    }
    public void inventarioTotal(LinkedList<objPc> listCompu, LinkedList<objTablet> listTab, LinkedList<objEst_Ingenieria> listIng, LinkedList<objEst_Diseño> listDis) 
    {
        System.out.println("---- INVENTARIO TOTAL ----");
        System.out.println("---- COMPUTADORES ---- ");
        for (objPc pc : listCompu) 
        {
            boolean prestado = false;
            for (objEst_Ingenieria est : listIng) 
            {
                if (est.getSerial().equals(pc.getSerial())) 
                {
                    prestado = true;
                    break;
                }
            }
            System.out.println("Serial: " + pc.getSerial()+
                               "\nMarca: " + pc.getMarca() +
                               "\nTamaño: " + pc.getTamaño() +
                               "\nPrecio: " + pc.getPrecio() +
                               "\nSistema Operativo: " + pc.getSisOperativo() +
                               "\nProcesador: " + pc.getProcesador() +
                               "\nEstado: " + (prestado ? "Prestado" : "Disponible"));
            System.out.println("-----------------------");
        }
        System.out.println("---- TABLETAS ---- ");
        for (objTablet tab : listTab) 
        {
            boolean prestada = false;
            for (objEst_Diseño est : listDis) 
            {
                if (est.getSerial().equals(tab.getSerial())) 
                {
                    prestada = true;
                    break;
                }
            }
            System.out.println("Serial: " + tab.getSerial() + 
                               "\nMarca: " + tab.getMarca() +
                               "\nTamaño: " + tab.getTamaño() +
                               "\nPrecio: " + tab.getPrecio() +
                               "\nPeso: " + tab.getPeso() +
                               "\nAlmacenamiento: " + tab.getAlmacenamiento() +
                               "\nEstado: " + (prestada ? "Prestada" : "Disponible"));
            System.out.println("-----------------------");
        }
    }
    public void exportarArchivoPC(LinkedList<objPc> pc)
    {
        Exportar compu = new Exportar();
        compu.exportarArchivoPC(pc);
    }
    public LinkedList<objPc> importarArchivoPC(LinkedList<objPc> pc)
    {
        Importar compu = new Importar();
        return compu.leerArchivoPC();
    }
    public void exportarArchivoTableta(LinkedList<objTablet> dis)
    {
        Exportar tab = new Exportar();
        tab.exportarArchivoTableta(dis);
    }
    public LinkedList<objTablet> importarArchivoTableta(LinkedList<objTablet> dis)
    {
        Importar tab = new Importar();
        return tab.leerArchivoTableta();
    }
    public void exportarArchivoIng(LinkedList<objEst_Ingenieria> ing)
    {
        Exportar inge = new Exportar();
        inge.exportarArchivoIng(ing);
    }
    public LinkedList<objEst_Ingenieria> importarArchivoIngenierias(LinkedList<objEst_Ingenieria> ing)
    {
        Importar inge = new Importar();
        return inge.leerArchivoIng();
    }
    public void exportarArchivoDis(LinkedList<objEst_Diseño> dis)
    {
        Exportar dise = new Exportar();
        dise.exportarArchivoDis(dis);
    }
    public LinkedList<objEst_Diseño> importarArchivodDis(LinkedList<objEst_Diseño> dis)
    {
        Importar dise = new Importar();
        return dise.leerArchivoDis();
    }
}
