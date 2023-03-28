/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductormusica;

/**
 *
 * @author Cesar
 */
public class InfoCancion {

    private String nombre;
    private String autor;
    private String rutaCancion;

    public InfoCancion() {
    }

    public InfoCancion(String nombre, String autor, String rutaCancion) {
        this.nombre = nombre;
        this.autor = autor;
        this.rutaCancion = rutaCancion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRutaCancion() {
        return rutaCancion;
    }

    public void setRutaCancion(String rutaCancion) {
        this.rutaCancion = rutaCancion;
    }
    
}
