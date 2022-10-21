/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.sismed.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author Alisson
 */
public class Conexao {
    public static Connection getConexao() throws SQLException{
       try{
        //definiÃ§Ã£o do driver de conexÃ£o com o banco de dados MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        //definiÃ§Ã£os dos  parametros de conexÃ£o
        return DriverManager.getConnection("jdbc:mysql://localhost/sismed?useTimezone=true&serverTimezone=UTC", "root", "159357486");
    }catch (ClassNotFoundException e){
        throw new SQLDataException(e.getMessage()); 
      }
    }
       public static void main(String[] args) {
        try{
           getConexao();
           System.out.println("Conexão realizada com sucesso.");
        }catch (SQLException e){
            System.out.println("Conexão não realizada, verificar log.");
            e.printStackTrace();
        }    
    }
}
