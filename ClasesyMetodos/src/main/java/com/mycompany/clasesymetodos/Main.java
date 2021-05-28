package com.mycompany.clasesymetodos;


public class Main {


    public static void main(String[] args) {
        
        Persona persona = new Persona();
        
        persona.setEdad(5);
        System.out.println(persona.getEdad());
        
        
        Persona personaq = new Persona();
        
        personaq.mostrarDatos();
        
    }
    
}
