/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Usuario
 */
public class Plataforma {
    int id;
    String nombre;
    DesarrolladoraFabricante fabricante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DesarrolladoraFabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(DesarrolladoraFabricante fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
    
    
}
