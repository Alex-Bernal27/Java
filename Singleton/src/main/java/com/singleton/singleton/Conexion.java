
package com.singleton.singleton;

public class Conexion {
    
    private static Conexion instancia;
    
    private Conexion(){
        
    }
    
    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public void conectar(){
        System.out.println("Me conecte a la BD");
    }
    
    public void desconectar(){
        System.out.println("Me desconecte a la BD");
    }
    
}
