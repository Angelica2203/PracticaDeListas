import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class menusDisEIng 
{
    public LinkedList<objEst_Ingenieria> menuIngenieria(LinkedList<objEst_Ingenieria> lisIng, LinkedList<objPc> lisCompu) 
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
                    lisIng = m.IngresarEstIng(lisIng, lisCompu);
                    break;
                case 2:
                    lisIng = m.modificarIng(lisIng);
                    break;
                case 3:
                    lisIng = m.devolverPC(lisIng);
                    break;
                case 4:
                    lisIng = m.buscarPCprestada(lisIng);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Devuelta al menú principal");
                    bandera = false;
                    break;
            }
        }
        return lisIng;
    }
    public LinkedList<objEst_Diseño> menuDiseño(LinkedList<objEst_Diseño> lisDis, LinkedList<objTablet> lisTab) 
    {
        boolean bandera = true;
        String rpta = "";
        metodo m = new metodo();
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
                   lisDis = m.IngresarEstDiseño(lisDis, lisTab);
                   break;
                case 2:
                   lisDis = m.modificarEstDis(lisDis);
                    break;
                case 3:
                    lisDis = m.devolverEstDis(lisDis);
                    break;
                case 4:
                    lisDis = m.buscarTabPrest(lisDis);
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
