
package com.factory.impl;

import com.factory.interfaz.IConexion;

public class ConexionVacia implements IConexion{

    @Override
    public void conectar() {
        System.out.println("No se especifico bien el motor o no existe");
    }

    @Override
    public void desconectar() {
        System.out.println("No se especifico bien el motor o no existe");
    }
    
    
    
}
