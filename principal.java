import java.util.LinkedList;
import javax.swing.JOptionPane;
public class principal 
{
    public int Menu()
    {
        String input;
        int vrUsu = 0; 
        boolean validInput = false;
        do 
        {
            input = JOptionPane.showInputDialog("------ BIENVENIDO ------\n" +
                                                "1.Estudiante de Ingenieria \n" +
                                                "2.Estudiante de Diseño\n" +
                                                "3.Imprimir Inventario Total\n" +
                                                "4.Registrar Computador\n" +
                                                "5.Registrar Tablet\n" +
                                                "6.Exportar Computador\n" +
                                                "7.Importar Computador\n" +
                                                "8.Exportar Tableta\n" +
                                                "9.Importar Tableta\n" +
                                                "10.Exportar Ingenieros\n" +
                                                "11.Importar Ingenieros\n" +
                                                "12.Exportar Diseñadores\n" +
                                                "13.Importar Diseñadores\n" +
                                                "14.Salir");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 14) 
                {
                    validInput = true;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }

        } while (!validInput);

        return vrUsu;
    }
    public static void main(String[] args) 
    {
        LinkedList<objEst_Ingenieria> ingeneria = new LinkedList<>();
        LinkedList<objEst_Diseño> diseño = new LinkedList<>();
        LinkedList<objPc> compu = new LinkedList<>();
        LinkedList<objTablet> tablet = new LinkedList<>();
        int opc;
        do 
        {
            principal m = new principal();
            opc = m.Menu();
            menusDisEIng menus = new menusDisEIng();
            metodo mt = new metodo();
            switch (opc) 
            {
                case 1:
                    if (compu.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay computadores registrados. No se puede realizar el préstamo.");
                    } 
                    else 
                    {
                        ingeneria = menus.menuIngenieria(ingeneria, compu);
                    }
                    break;
                case 2:
                    if (compu.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay tabletas registrados. No se puede realizar el préstamo.");
                    } 
                    else 
                    {
                        diseño = menus.menuDiseño(diseño, tablet);
                    }
                    break;
                    
                case 3:
                    if (compu.isEmpty() && tablet.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "Inventario vacio. No hay equipos registrados");
                    } 
                    else 
                    {
                        mt.inventarioTotal(compu, tablet, ingeneria, diseño);
                    }
                    break;
                case 4:
                    compu = mt.IngresarComputador(compu);
                    break;
                case 5:
                     mt.registrarTableta(tablet);
                    break;
                case 6:
                    if (compu.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para exportar");
                    } 
                    else 
                    {
                        mt.exportarArchivoPC(compu);
                    }
                    break;
                case 7:
                    if (compu.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para importar");
                    } 
                    else 
                    {
                        mt.importarArchivoPC(compu);
                    }
                    break;
                case 8:
                    if (tablet.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para exportar");
                    } 
                    else 
                    {
                        mt.exportarArchivoTableta(tablet);
                    }
                    break;
                case 9:
                    if (tablet.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para importar");
                    } 
                    else 
                    {
                        mt.importarArchivoTableta(tablet);
                    }
                    break;
                case 10:
                    if (ingeneria.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para exportar");
                    } 
                    else 
                    {
                        mt.exportarArchivoIng(ingeneria);
                    }
                    break;
                case 11:
                    if (ingeneria.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para importar");
                    } 
                    else 
                    {
                        mt.importarArchivoIngenierias(ingeneria);
                    }
                    break;
                case 12:
                    if (diseño.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para exportar");
                    } 
                    else 
                    {
                        mt.exportarArchivoDis(diseño);
                    }
                    break;
                case 13:
                    if (diseño.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(null, "No hay registros para importar");
                    } 
                    else 
                    {
                        mt.importarArchivodDis(diseño);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    break;
            }
            
        } while (opc != 14);
    }
}
