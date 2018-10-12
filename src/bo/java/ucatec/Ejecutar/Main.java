/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.java.ucatec.Ejecutar;

import bo.java.ucatec.Categoria;
import bo.java.ucatec.Opciones;
import bo.java.ucatec.Persona;
import bo.java.ucatec.Ticket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Marvinero
 */
public class Main {

    public static void main(String[] args) {

        Opciones opciones = new Opciones();
        
        Stack<Ticket> o = new Stack<>();
        Stack<Ticket> n = new Stack<>();
        Stack<Ticket> p = new Stack<>();

        for (int i = 1; i <= 20; i++) {
            o.push(new Ticket(Categoria.AntecedenesFELCN, i));
            n.push(new Ticket(Categoria.AntecedentesFELCC, i));
            p.push(new Ticket(Categoria.TransitoPolicia, i));
        }

        System.out.println("FELCN");
        Opciones.mostrar(o);
        System.out.println("FELCC");
        Opciones.mostrar(n);
        System.out.println("PoliciaTransito");
        Opciones.mostrar(p);

        Queue<Persona> pacientes = new LinkedList<>();

        pacientes.add(new Persona("Persona1", Categoria.AntecedenesFELCN, Categoria.TransitoPolicia));
        pacientes.add(new Persona("Persona2", Categoria.AntecedentesFELCC, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona3", Categoria.AntecedentesFELCC, Categoria.AntecedenesFELCN));
        pacientes.add(new Persona("Persona4", Categoria.AntecedenesFELCN, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona5", Categoria.AntecedenesFELCN, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona6", Categoria.TransitoPolicia, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona7", Categoria.AntecedentesFELCC, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona8", Categoria.AntecedentesFELCC, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona9", Categoria.AntecedentesFELCC, Categoria.SIN_ESPECIALIDAD));
        pacientes.add(new Persona("Persona10",Categoria.AntecedentesFELCC, Categoria.SIN_ESPECIALIDAD));

        System.out.println("Persona");
        Opciones.mostrar(pacientes);

        // Solución 1
        Opciones.asignarFichas(o, n, p, pacientes);


        System.out.println("FELCN");
        Opciones.mostrar(o);
        System.out.println("FELCC");
        Opciones.mostrar(n);
        System.out.println("PoliciaTransito");
        Opciones.mostrar(p);

        Opciones.calcularCategoriaMasRequerida(o, n, p);
       
        Persona pa = new Persona("Juan", 1, 3);
        System.out.println("> persona: " + pa.getNombre());
        Opciones.atender(pa,o,p,n);
                
        Opciones.atender(pa, o, p, n);
        Opciones.calcularCategoriaMasRequerida(o, n, p);
        Opciones.asignarFichas(o, n, p, pacientes);    
    }
}
