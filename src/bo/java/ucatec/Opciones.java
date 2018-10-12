/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.java.ucatec;

import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Marvinero
 */
public class Opciones {
    
    public static void atender(Persona persona, Stack<Ticket> o, Stack<Ticket> p, Stack<Ticket> n){
        
        if (persona.getCategoria1() == Categoria.AntecedenesFELCN) {
            Ticket fi = persona.getFicha1();
            o.push(fi);
            // reseteo
            persona.setFicha1(null);
            persona.setEspecialidad1(Categoria.SIN_ESPECIALIDAD);
        } else if (persona.getCategoria1() == Categoria.AntecedentesFELCC) {
            Ticket fi = persona.getFicha1();
            n.push(fi);
            // reseteo
            persona.setFicha1(null);
            persona.setEspecialidad1(Categoria.SIN_ESPECIALIDAD);
        } else if (persona.getCategoria1() == Categoria.AntecedenesFELCN) {
            Ticket fi = persona.getFicha1();
            n.push(fi);
            // reseteo
            persona.setFicha1(null);
            persona.setEspecialidad1(Categoria.SIN_ESPECIALIDAD);
        }
        if (persona.getCategoria2() != Categoria.SIN_ESPECIALIDAD) {
            switch (persona.getCategoria2()) {
                case Categoria.TransitoPolicia:
                    {
                        Ticket fi = persona.getFicha2();
                        o.push(fi);
                        // reseteo
                        persona.setFicha2(null);
                        persona.setEspecialidad2(Categoria.SIN_ESPECIALIDAD);
                        break;
                    }
                case Categoria.AntecedenesFELCN:
                    {
                        Ticket fi = persona.getFicha2();
                        p.push(fi);
                        // reseteo
                        persona.setFicha2(null);
                        persona.setEspecialidad2(Categoria.SIN_ESPECIALIDAD);
                        break;
                    }
                case Categoria.AntecedentesFELCC:
                    {
                        Ticket fi = persona.getFicha2();
                        n.push(fi);
                        // reseteo
                        persona.setFicha2(null);
                        persona.setEspecialidad2(Categoria.SIN_ESPECIALIDAD);
                        break;
                    }
                default:
                    break;
            }
        }
    }
    
    public static void calcularCategoriaMasRequerida(Stack<Ticket> o, Stack<Ticket> n, Stack<Ticket> p) {

        int no = o.size();
        int np = p.size();
        int nn = n.size();

        if (no < np && no < nn) {
            System.out.println("FELCN es más requerido");
        }
        if (np < no && np < nn) {
            System.out.println("FELCC es más requerido");
        }
        if (nn < no && nn < np) {
            System.out.println("PoliciaTransito es más requerido");
        }
    }
    
    public static void asignarFichas(Stack<Ticket> o, Stack<Ticket> n, Stack<Ticket> p, Queue<Persona> persona){
        int m = persona.size();
        for (int i = 0; i < m; i++) {
            Persona pa = persona.remove();

            if (pa.getCategoria1() == Categoria.AntecedenesFELCN) {
                Ticket fi = n.pop();
                pa.setFicha1(fi);
            } else if (pa.getCategoria1() == Categoria.AntecedentesFELCC) {
                Ticket fi = o.pop();
                pa.setFicha1(fi);
            } else if (pa.getCategoria1() == Categoria.TransitoPolicia) {
                Ticket fi = p.pop();
                pa.setFicha1(fi);
            }
            if (pa.getCategoria2() != Categoria.SIN_ESPECIALIDAD) {
                if (pa.getCategoria2() == Categoria.AntecedenesFELCN) {
                    Ticket fi = n.pop();
                    pa.setFicha2(fi);
                } else if (pa.getCategoria2() == Categoria.AntecedentesFELCC) {
                    Ticket fi = o.pop();
                    pa.setFicha2(fi);
                } else if (pa.getCategoria2() == Categoria.TransitoPolicia) {
                    Ticket fi = p.pop();
                    pa.setFicha2(fi);
                }
            }
            persona.add(pa);
        }
    }
    
    public static void mostrar(Stack<Ticket> o) {

        Stack<Ticket> temp = new Stack<>();

        while (!o.isEmpty()) {
            Ticket fi = o.pop();
            System.out.println(" Ficha: " + fi.getCategoria() + " " + fi.getCodigo());
            temp.push(fi);
        }
        while (!temp.isEmpty()) {
            Ticket fi = temp.pop();
            o.push(fi);
        }
    }
    
    public static void mostrar(Queue<Persona> cola) {
        int n = cola.size();
        for (int i = 0; i < n; i++) {
            Persona pa = cola.remove();
            System.out.println(" Paciente: " + pa.getNombre() + " Especialidades: " + pa.getCategoria1()+ ", " + pa.getCategoria2());
            cola.add(pa);
    }
  }
}
