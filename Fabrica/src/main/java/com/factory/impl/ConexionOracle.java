
package com.factory.impl;

import com.factory.interfaz.IConexion;


public class ConexionOracle implements IConexion{
    
    private String host;
    private String puerto;
    private String usuario;
    private String contrasena;
    
    public ConexionOracle(){
        this.host = "localhost";
        this.puerto = "3306";
        this.usuario = "root";
        this.contrasena = "abc";
                
    }

    @Override
    public void conectar() {
        System.out.println("Me conecte de Oracle");
    }

    @Override
    public void desconectar() {
        System.out.println("Me desconecte de Oracle");
    }
    
}
