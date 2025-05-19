import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JOptionPane;
public class Importar 
{
    public LinkedList<objPc> leerArchivoPC() 
    {
        String rutaArchivo = "Computadores.txt";
        LinkedList<objPc> compu = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            objPc pc = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Serial: ")) {
                    if (pc != null) {
                        compu.add(pc);
                    }
                    pc = new objPc();
                    pc.setSerial(line.substring(7)); 
                } else if (line.startsWith("Marca: ")) {
                    if (pc != null) {
                        pc.setMarca(line.substring(7)); // Remover ": "
                    }
                } else if (line.startsWith("Tamaño: ")) {
                    if (pc != null) {
                        pc.setTamaño(Double.parseDouble(line.substring(8)));

                    }
                }
                else if (line.startsWith("Precio: ")) {
                    if (pc != null) 
                    {
                        pc.setPrecio(Double.parseDouble(line.substring(8)));
                    }
                } 
                else if (line.startsWith("Sistema Operativo: ")) {
                    if (pc != null) 
                    {
                        pc.setSisOperativo(line.substring(19));
                    }
                }
                else if (line.startsWith("Procesador: ")) 
                {
                    if (pc!= null) {
                        pc.setProcesador(line.substring(12)); 
                        compu.add(pc);
                        pc = null; 
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Archivo importado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compu;
    }
    public LinkedList<objTablet> leerArchivoTableta() 
    {
        String rutaArchivo = "Tableta.txt";
        LinkedList<objTablet> tablet = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            objTablet tab = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Serial: ")) {
                    if (tab != null) {
                        tablet.add(tab);
                    }
                    tab = new objTablet();
                    tab.setSerial(line.substring(7)); 
                } else if (line.startsWith("Marca: ")) {
                    if (tab != null) {
                        tab.setMarca(line.substring(7)); // Remover ": "
                    }
                } else if (line.startsWith("Tamaño: ")) {
                    if (tab != null) {
                        tab.setTamaño(Double.parseDouble(line.substring(8)));

                    }
                }
                else if (line.startsWith("Precio: ")) {
                    if (tab != null) {
                        tab.setPrecio(Double.parseDouble(line.substring(8)));

                    }
                } 
                else if (line.startsWith("Peso: ")) {
                    if (tab != null) {
                        tab.setPeso(Double.parseDouble(line.substring(6)));

                    }
                }
                else if (line.startsWith("Almacenamiento: ")) 
                {
                    if (tab!= null) {
                        tab.setAlmacenamiento(line.substring(16)); 
                        tablet.add(tab);
                        tab = null; 
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Archivo importado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tablet;
    }
    public LinkedList<objEst_Ingenieria> leerArchivoIng() 
    {
        String rutaArchivo = "Ingenieria.txt";
        LinkedList<objEst_Ingenieria> ingenieria = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            objEst_Ingenieria ing = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Cedula: ")) {
                    if (ing != null) {
                        ingenieria.add(ing);
                    }
                    ing = new objEst_Ingenieria();
                    ing.setCedula(line.substring(8)); 
                } else if (line.startsWith("Nombre: ")) {
                    if (ing != null) {
                        ing.setNombre(line.substring(8)); 
                    }
                } else if (line.startsWith("Apellido: ")) {
                    if (ing != null) {
                        ing.setApellido(line.substring(10));

                    }
                }
                else if (line.startsWith("Telefono: ")) {
                    if (ing != null) {
                        ing.setTelefono(line.substring(10));

                    }
                } 
                else if (line.startsWith("Numero de Semestre: ")) {
                    if (ing != null) {
                        ing.setNumSemestre(Integer.parseInt(line.substring(20)));

                    }
                }
                else if (line.startsWith("Promedio Acumulado: ")) {
                    if (ing != null) {
                        ing.setPromAcum(Double.parseDouble(line.substring(20)));

                    }
                }
                else if (line.startsWith("Serial: ")) 
                {
                    if (ing!= null) {
                        ing.setSerial(line.substring(8)); 
                        ingenieria.add(ing);
                        ing = null; 
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Archivo importado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingenieria;
    }
    public LinkedList<objEst_Diseño> leerArchivoDis() 
    {
        String rutaArchivo = "Diseño.txt";
        LinkedList<objEst_Diseño> diseño = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            objEst_Diseño dis = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Cedula: ")) {
                    if (dis != null) {
                        diseño.add(dis);
                    }
                    dis = new objEst_Diseño();
                    dis.setCedula(line.substring(8)); 
                } else if (line.startsWith("Nombre: ")) {
                    if (dis != null) {
                        dis.setNombre(line.substring(8)); 
                    }
                } else if (line.startsWith("Apellido: ")) {
                    if (dis != null) {
                        dis.setApellido(line.substring(10));
                    }
                }
                else if (line.startsWith("Telefono: ")) {
                    if (dis != null) {
                        dis.setTelefono(line.substring(10));
                    }
                } 
                else if (line.startsWith("Modalidad de Estudio: ")) {
                    if (dis != null) {
                        dis.setModalidadEstud(line.substring(22));

                    }
                }
                else if (line.startsWith("Cantidad de Asignatura: ")) {
                    if (dis != null) {
                        dis.setCantAsignat(Integer.parseInt(line.substring(20)));

                    }
                }
                else if (line.startsWith("Serial: ")) 
                {
                    if (dis!= null) {
                        dis.setSerial(line.substring(8)); 
                        diseño.add(dis);
                        dis = null; 
                    }
                }
            }

            JOptionPane.showMessageDialog(null,"Archivo importado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diseño;
    }
}
