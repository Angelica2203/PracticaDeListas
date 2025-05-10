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
                                                "4.Salir");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 4) 
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
        int opc;
        do 
        {
            principal m = new principal();
            opc = m.Menu();
            menusDisEIng menus = new menusDisEIng();
            switch (opc) 
            {
                case 1:
                    ingeneria = menus.menuIngenieria(ingeneria);
                    break;
                case 2:
                    diseño = menus.menuDiseño(diseño);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    break;
            }
            
        } while (opc != 4);
    }//angelicaaaaaaaaaa 
}
