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

    public static void main(String[] args) throws JavaLayerException {
        Scanner scanner = new Scanner(System.in);
        int menu;

        LinkedList<InfoCancion> generadas = mostrarLinkedlist(3);
        int index = 0;

        do {
            System.out.println("\nBienvenido al menu del reproducto que desea hacer\n 1. Ver lista de canciones\n 2. Elegir cancion\n 3. Siguiente cancion\n 4. Cancion anterior\n 5. Eliminar cancion\n 6. Agregar cancion\n 7. Salir");
            System.out.print("Mediante el numero del menu indique que desea hacer: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("\"Las canciones actuales son: \"");
                    for (int i = 0; i < generadas.size(); i++) {
                        System.out.println("Posicion " + (i + 1) + " Nombre de la cancion: " + generadas.get(i).getNombre() + ", autor: " + generadas.get(i).getAutor());
                    }
                    break;

                case 2:
                    System.out.print("Mediante el numero de cancion indique cual desea escuchar: ");
                    index = scanner.nextInt() - 1;
                    System.out.println("Reproduciendo " + generadas.get(index).getNombre() + ", " + generadas.get(index).getAutor());
                    try {
                        FileInputStream fis = new FileInputStream(generadas.get(index).getRutaCancion());
                        Player player = new Player(fis);
                        player.play();
                    } catch (FileNotFoundException | JavaLayerException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                    if (index <= generadas.size()) {
                        index++;
                        System.out.println("Cambio realizado con exito, reproduciendo: " + generadas.get(index).getNombre());
                        try {
                            FileInputStream fis = new FileInputStream(generadas.get(index).getRutaCancion());
                            Player player = new Player(fis);
                            player.play();
                        } catch (FileNotFoundException | JavaLayerException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("No hay más canciones en cola");
                }
                break;

                case 4:
                    try {
                    if (index <= generadas.size()) {
                        index--;
                        System.out.println("Cambio realizado con exito, reproduciendo: " + generadas.get(index).getNombre());
                        try {
                            FileInputStream fis = new FileInputStream(generadas.get(index).getRutaCancion());
                            Player player = new Player(fis);
                            player.play();
                        } catch (FileNotFoundException | JavaLayerException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
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
        generadas.add(new InfoCancion("Givenchi", "Duko", "C:\\Users\\Cesar\\OneDrive\\Escritorio\\Primer semestre 2023\\Progra II\\Proyectos\\ReproductorMusica\\Givenchi.mp3"));
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
