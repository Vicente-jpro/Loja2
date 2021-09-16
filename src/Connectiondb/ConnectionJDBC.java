/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectiondb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
// Inicio da classe conexao 
public class ConnectionJDBC {
    //com.mysql.jdbc.Driver
    //com.mysql.cj.jdbc.Driver
    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/Loja19793";
    private static final String user = "postgres";
    private static final String password = "vicente0301" ; //"vicente0301"
    
    
    public static Connection getConnection() 
    {
        try {
                Class.forName(driver);
                return DriverManager.getConnection(url, user, password);


        } 

        catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException ("Erro na conexao: O driver nao foi "
                            + "encontrado (Verifica o nome do banco de dados) ", ex);

        }
    }
    
    public static void closeConnection (Connection con)
    {
       
            try {
                
                 if (con != null)
                     con.close();
                
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possivel fechar a "
                        + "conecção\n ConnectionJDBC -> closeConnection(Connection)"
                        + "", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
        
        public static void closeConnection (Connection con, PreparedStatement stmt)
    {
            closeConnection(con);
       
            try {
                
                 if (stmt != null)
                     stmt.close();
                 
                } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar a "
                        + "conecção\n ConnectionJDBC -> closeConnection(Connection, PreparedStatement)"
                        + "", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }
      
        
        
    public static void closeConnection (Connection con, PreparedStatement stmt, ResultSet rs)
    {
            closeConnection(con, stmt);
       
            try {
                
                 if (rs != null)
                     rs.close();
                 
                } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar a "
                        + "conecção\n ConnectionJDBC -> closeConnection(Connection, PreparedStatement, ResultSet)"
                        + "", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
        
}
    
    // Metodo construtor da classe
 
    
    // Metodo de conexao
  
    
    
    

