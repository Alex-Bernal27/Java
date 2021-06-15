/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factory.impl;

import com.factory.interfaz.IConexion;


public class ConexionMySQL implements IConexion{
    
    
    private String host;
    private String puerto;
    private String usuario;
    private String contrasena;
    
    public ConexionMySQL(){
        this.host = "localhost";
        this.puerto = "3306";
        this.usuario = "root";
        this.contrasena = "abc";
                
    }

    @Override
    public void conectar() {
        System.out.println("Me conecte de MySQL");
    }

    @Override
    public void desconectar() {
        System.out.println("Me desconecte de MySQL");
    }
    
    
}
