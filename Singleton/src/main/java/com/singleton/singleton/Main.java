
package com.singleton.singleton;

public class Main {

 
    public static void main(String[] args) {
        
        Conexion x = Conexion.getInstancia();
        x.conectar();
        x.desconectar();
        
        
        boolean rpta = x instanceof Conexion;
        System.out.println(rpta);
    }
    
}
