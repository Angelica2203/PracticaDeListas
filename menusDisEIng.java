import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class menusDisEIng 
{
    public LinkedList<objEst_Ingenieria> menuIngenieria(LinkedList<objEst_Ingenieria> lisIng) 
    {
        boolean bandera = true;
        String rpta = "";
        metodo m = new metodo();
        int opt = 0;
        while (bandera) 
        {
            do {
                rpta = JOptionPane.showInputDialog("      MENÚ INGENERIA \n" +
                                                   "1.Registrar prestamo equipo\n" +
                                                   "2.Modificar prestamo equipo\n" +
                                                   "3.Devolución equipo\n" +
                                                   "4.Buscar equipo\n" + 
                                                   "5.Volver al menú principal \n");
            
                if (rpta == null || !rpta.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Dato incorrecto, reintente por favor");
                }
            } while (rpta == null || !rpta.matches("\\d+"));
            opt = Integer.parseInt(rpta);
            if (opt < 1 || opt > 5) 
            {
                JOptionPane.showMessageDialog(null, "Opción no valida, reintente por favor");
                continue;
            }
            switch (opt) 
            {
                case 1:
                    lisIng = m.IngresarEstIng(lisIng);
                    break;
                case 2:
                   // c = m.PrestarComputador(c);
                    break;
                case 3:
                    //c = m.modificarComp(c);
                    break;
                case 4:
                    //c = m.devolverComp(c);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Devuelta al menú principal");
                    bandera = false;
                    break;
            }
        }
        return lisIng;
    }
    public LinkedList<objEst_Diseño> menuDiseño(LinkedList<objEst_Diseño> lisDis) 
    {
        boolean bandera = true;
        String rpta = "";
        //metodos m = new metodos();
        int opt = 0;
        while (bandera) 
        {
            do {
                rpta = JOptionPane.showInputDialog("      MENÚ DISEÑO \n" +
                                                   "1.Registrar prestamo equipo\n" +
                                                   "2.Modificar prestamo equipo\n" +
                                                   "3.Devolución equipo\n" +
                                                   "4.Buscar equipo\n" + 
                                                   "5.Volver al menú principal \n");
            
                if (rpta == null || !rpta.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Dato incorrecto, reintente por favor");
                }
            } while (rpta == null || !rpta.matches("\\d+"));
            opt = Integer.parseInt(rpta);
            if (opt < 1 || opt > 5) 
            {
                JOptionPane.showMessageDialog(null, "Opción no valida, reintente por favor");
                continue;
            }
            switch (opt) 
            {
                case 1:
                    //lisIng = m.IngresarComputador(c);
                    break;
                case 2:
                   // c = m.PrestarComputador(c);
                    break;
                case 3:
                    //c = m.modificarComp(c);
                    break;
                case 4:
                    //c = m.devolverComp(c);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Devuelta al menú principal");
                    bandera = false;
                    break;
            }
        }
        return lisDis;
    }

    
}
