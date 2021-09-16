/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package compra;

import Connectiondb.ConnectionJDBC;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import produto.Produto;

/**
 *
 * @author vicente-jpro
 */
public class Compradb2 {
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection conn;
    
    
    public Compradb2 (){
    
        conn = ConnectionJDBC.getConnection();
    }
    
//    
//    public void create ( Compra compra, Produto produto ){
//    
//                String sql = "INSERT INTO public.cliente_tb(\n"
//                + "	id_compra, nome_cliente_id, nome_produto_id, valor_unitario, \n"
//                + "	sub_total, valor_total, data_compra, hora, usuario_id,\n"
//                + "	quantidadee, troco_cliente, valor_entregar_cliente, iva)\n"
//                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//                
//        try {
//           
//            
//            stmt = conn.prepareStatement(sql);
//        
//        
//            stmt.setInt(1, compra.getCliente().getIdCliente());
//            stmt.setInt(2, produto.getIdProduto());
//            // valorUnitario corresponde ao preço do produto com iva
//            stmt.setDouble(3, produto.getValorPagarCliente()); // valorUnitario com iva
//            stmt.setDouble(4, compra.getSubTotal());
//           
//            stmt.setString(5, compra.getDataCompra());
//            stmt.setString(6, compra.getHora());
//            stmt.setInt(7, produto.getCurrentUser().getIdUsuario());
//            stmt.setInt(8, compra.getQuantidade());
//            stmt.setDouble(9, compra.getIva());
//
//            stmt.executeUpdate();
//        
//        } catch (SQLException ex) {
//            Logger.getLogger(Compradb2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    
//    }
//    
    
    
    
    
    
    
    
}
