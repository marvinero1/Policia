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
public class Ticket {

    private int Division;
    private int codigo;

    public Ticket(int especialidad, int codigo) {
        this.Division = especialidad;
        this.codigo = codigo;
    }

    public int getCategoria() {
        return Division;
    }

    public void setCategoria(int especialidad) {
        this.Division = especialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
