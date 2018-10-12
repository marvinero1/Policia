/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.java.ucatec;

/**
 *
 * @author Marvinero
 */
public class Persona {
    private String nombre;
    private Ticket ficha1;
    private Ticket ficha2;
    private int especialidad1;
    private int especialidad2;

    public Persona(String nombre, int especialidad1, int especialidad2) {
        this.nombre = nombre;
        this.especialidad1 = especialidad1;
        this.especialidad2 = especialidad2;
        this.ficha1 = null;
        this.ficha2 = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ticket getFicha1() {
        return ficha1;
    }

    public void setFicha1(Ticket ficha1) {
        this.ficha1 = ficha1;
    }

    public Ticket getFicha2() {
        return ficha2;
    }

    public void setFicha2(Ticket ficha2) {
        this.ficha2 = ficha2;
    }

    public int getCategoria1() {
        return especialidad1;
    }

    public void setEspecialidad1(int especialidad1) {
        this.especialidad1 = especialidad1;
    }

    public int getCategoria2() {
        return especialidad2;
    }

    public void setEspecialidad2(int especialidad2) {
        this.especialidad2 = especialidad2;
    }
}