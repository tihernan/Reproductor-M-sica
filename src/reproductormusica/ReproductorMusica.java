/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reproductormusica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Cesar
 */
public class ReproductorMusica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JavaLayerException {
        Scanner scanner = new Scanner(System.in);
        int menu;
        LinkedList<InfoCancion> generadas = mostrarLinkedlist(3);

        String nombreCancionActual = generadas.getFirst().getNombre();
        String nombreAutorActual = generadas.getFirst().getNombre();
        int index = 0;

        do {
            System.out.println("\nBienvenido al menu del reproducto que desea hacer\n 1. Ver lista de canciones\n 2. Elegir cancion\n 3. Siguiente cancion\n 4. Cancion anterior\n 5. Eliminar cancion\n 6. Agregar cancion\n 7. Salir");
            System.out.print("Mediante el numero del menu indique que desea hacer: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("\"Las canciones actuales son: \"");
                    for (int i = 0; i < generadas.size(); i++) {
                        System.out.println("Nombre de la cancion: " + generadas.get(i).getNombre() + ", autor: " + generadas.get(i).getAutor());
                    }
                    break;
                    
                case 2:
                    try {
                    FileInputStream fis = new FileInputStream(generadas.element().getRutaCancion());
                    Player player = new Player(fis);
                    player.play();
                } catch (FileNotFoundException | JavaLayerException e) {
                    e.printStackTrace();
                }
                System.out.println("Reproduciendo " + nombreCancionActual + ", " + nombreAutorActual);
                index = 0;
                break;

                case 3:
                    try{
                    if (index <= generadas.size()) {
                        index++;
                        String siguienteCancion = generadas.get(index).getNombre();
                        System.out.println("Cambio realizado con exito, reproduciendo: " + siguienteCancion);
                    }
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("No hay más canciones en cola");
                    }
                    break;

                case 4:
                    try{
                    if (index <= generadas.size()) {
                        index--;
                        String siguienteCancion = generadas.get(index).getNombre();
                        System.out.println("Cambio realizado con exito, reproduciendo: " + siguienteCancion);
                    }
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("No hay más canciones previas");
                    }
                    break;

                case 5:
                    System.out.print("Digite la posicion de la cancion que desea eliminar: ");
                    int eliminar = scanner.nextInt();
                    generadas.remove(eliminar - 1);
                    System.out.println("Cancion eliminada con exito!");
                    break;

                case 6:
                    generadas = cancionDesdeConsola(generadas, scanner);
                    System.out.println("Cancion agregada exitosamente!");
                    break;
            }
        } while (menu != 7);
    }

    private static LinkedList mostrarLinkedlist(int c) {
        LinkedList generadas = new LinkedList();
        generadas.add(new InfoCancion("Saludo", "Cesar", "C:\\Users\\Cesar\\OneDrive\\Escritorio\\Primer semestre 2023\\Progra II\\Proyectos\\ReproductorMusica\\Llamado1.mp3"));
        generadas.add(new InfoCancion("Grito", "Cesar", "C:\\Users\\Cesar\\OneDrive\\Escritorio\\Primer semestre 2023\\Progra II\\Proyectos\\ReproductorMusica\\Llamado2.mp3"));
        generadas.add(new InfoCancion("Givenvhi", "Duko", "C:\\Users\\Cesar\\OneDrive\\Escritorio\\Primer semestre 2023\\Progra II\\Proyectos\\ReproductorMusica\\Givenchi.mp3"));
        return generadas;
    }

    public static LinkedList cancionDesdeConsola(LinkedList generadas, Scanner scanner) {
        System.out.println("Digite el nombre de la cancion: ");
        String nombre = scanner.next();
        System.out.println("Digite el nombre del autor: ");
        String autor = scanner.next();
        System.out.print("Digite la ruta de la cancion: ");
        String rutaCancion = scanner.next();
        generadas.add(new InfoCancion(nombre + " ", autor + " ", rutaCancion));
        return generadas;
    }

}
