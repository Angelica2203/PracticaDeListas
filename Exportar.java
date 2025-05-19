import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;
public class Exportar {

    public void exportarArchivoPC(LinkedList<objPc> p) 
    {
        try (FileWriter escriba = new FileWriter("Computadores.txt")) 
        {
            for (objPc item : p) {
                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("Marca: " + item.getMarca() + "\n");
                escriba.write("Tamaño: " + item.getTamaño() + "\n");
                escriba.write("Precio: " + item.getPrecio() + "\n");
                escriba.write("Sistema Operativo: " + item.getSisOperativo() + "\n");
                escriba.write("Procesador: " + item.getProcesador() + "\n");

                escriba.write("---------------------------------------\n");

            }

            JOptionPane.showMessageDialog(null,"Archivo exportado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exportarArchivoTableta(LinkedList<objTablet> p) 
    {
        try (FileWriter escriba = new FileWriter("Tableta.txt")) 
        {
            for (objTablet item : p) {
                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("Marca: " + item.getMarca() + "\n");
                escriba.write("Tamaño: " + item.getTamaño() + "\n");
                escriba.write("Precio: " + item.getPrecio() + "\n");
                escriba.write("Almacenamiento: " + item.getAlmacenamiento()+ "\n");
                escriba.write("Peso: " + item.getPeso() + "\n");
                escriba.write("---------------------------------------\n");

            }

            JOptionPane.showMessageDialog(null,"Archivo exportado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exportarArchivoIng(LinkedList<objEst_Ingenieria> p) 
    {
        try (FileWriter escriba = new FileWriter("Ingeneria.txt")) 
        {
            for (objEst_Ingenieria item : p) {
                escriba.write("Cedula: " + item.getCedula() + "\n");
                escriba.write("Nombre: " + item.getNombre() + "\n");
                escriba.write("Apellido: " + item.getApellido() + "\n");
                escriba.write("Telefono: " + item.getTelefono() + "\n");
                escriba.write("Numero de Semestre: " + item.getNumSemestre()+ "\n");
                escriba.write("Promedio Acomulado: " + item.getPromAcum() + "\n");
                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("---------------------------------------\n");

            }

            JOptionPane.showMessageDialog(null,"Archivo exportado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exportarArchivoDis(LinkedList<objEst_Diseño> p) 
    {
        try (FileWriter escriba = new FileWriter("Diseño.txt")) 
        {
            for (objEst_Diseño item : p) {
                escriba.write("Cedula: " + item.getCedula() + "\n");
                escriba.write("Nombre: " + item.getNombre() + "\n");
                escriba.write("Apellido: " + item.getApellido() + "\n");
                escriba.write("Telefono: " + item.getTelefono() + "\n");
                escriba.write("Modalidad: " + item.getModalidadEstud()+ "\n");
                escriba.write("Cantidad de Asignatura: " + item.getCantAsignat() + "\n");
                escriba.write("Serial: " + item.getSerial() + "\n");
                escriba.write("---------------------------------------\n");

            }

            JOptionPane.showMessageDialog(null,"Archivo exportado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
