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
                                                "6.Salir");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 6) 
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
                    diseño = menus.menuDiseño(diseño, tablet);
                    break;
                case 3:
                    //compu = mt.menuDiseño(compu);
                    break;
                case 4:
                    compu = mt.IngresarComputador(compu);
                    break;
                case 5:
                     mt.registrarTableta(tablet);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    break;
            }
            
        } while (opc != 6);
    }
}
