package com.factory.fabrica;
import com.factory.interfaz.IConexion;

public class main {


    public static void main(String[] args) {
       
       Fabrica fab = new Fabrica();
        
       IConexion c1 = fab.getConexion("Oracle");
       c1.conectar();
       c1.desconectar();
       
       IConexion c2 = fab.getConexion("MySQL");
       c2.conectar();
       c2.desconectar();
       
       IConexion c3 = fab.getConexion("");
       c3.conectar();
       c3.desconectar();
        
        
    }
    
}
