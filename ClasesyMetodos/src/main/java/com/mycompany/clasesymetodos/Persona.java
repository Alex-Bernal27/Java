
package com.mycompany.clasesymetodos;


public class Persona {
    
    String nombre;
    int edad;
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    public void mostrarDatos(){
        System.out.println("El nombre es: "+ nombre);
        System.out.println("La edad es: "+ edad);
    }
    
    
    
    
}
