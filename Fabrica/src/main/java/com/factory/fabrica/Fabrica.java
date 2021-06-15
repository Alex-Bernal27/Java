
package com.factory.fabrica;

import com.factory.impl.ConexionMySQL;
import com.factory.impl.ConexionOracle;
import com.factory.impl.ConexionVacia;
import com.factory.interfaz.IConexion;


public class Fabrica {
    
    public IConexion getConexion(String base){
        
        switch (base) {
            case "MySQL":
                return new ConexionMySQL();
            case "Oracle":
                return new ConexionOracle();
            default:
                return new ConexionVacia();
        }
    }
    
}
