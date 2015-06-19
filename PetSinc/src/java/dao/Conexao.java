/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author ad
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost/petsoftware";
    private static final String USUARIO="root";
    private static final String SENHA="123";
    
    public  static Connection abreConexao() throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
    
           
    
}
