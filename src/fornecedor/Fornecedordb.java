package fornecedor;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Fornecedordb {
    
    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;
    private Fornecedor fornecedor;
    
    public Fornecedordb() {
        
        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Fornecedor>();
    }

    //nome_fornecedor, endereco, telemovel1, telemovel2, email, whats_app
    protected void create(Fornecedor fornecedor) {
        
        String sql = "INSERT INTO "
                + " fornecedor_tb ( nome_fornecedor, endereco, telemovel1, telemovel2, email, whats_app ) "
                + " VALUES ( ?, ?, ?, ?, ?, ? )";
        
        try {
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getTelemovel1());
            stmt.setString(4, fornecedor.getTelemovel2());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getWhats_app());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso\n",
                    "CADASTRO DE FORNECEDOR", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o Fornecedor \n",
                    "CADASTRO DE FORNECEDOR ", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            ConnectionJDBC.closeConnection(conn, stmt);
            
        }
        
    }
    
    protected void update(Fornecedor fornecedor) {
        
        int idFornecedor = fornecedor.getIdFornecedor();
        
        String sql = "UPDATE Fornecedor_tb "
                + " SET nome_fornecedor = ?, endereco = ?, telemovel1 =  ?, "
                + " telemovel2 = ?, email = ?, whats_app = ? "
                + " WHERE  id_fornecedor = '" + idFornecedor + "'";
        
        try {
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getEndereco());
            stmt.setString(3, fornecedor.getTelemovel1());
            stmt.setString(4, fornecedor.getTelemovel2());
            stmt.setString(5, fornecedor.getEmail());
            stmt.setString(6, fornecedor.getWhats_app());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor actualizado com sucesso\n ",
                    "ACTUALIZAÇÃO DE FORNECEDOR ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o fornecedor \n",
                    "ACTUALIZAÇÃO DE FORNECEDOR", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            ConnectionJDBC.closeConnection(conn, stmt);
            
        }
        
    }
    
    protected void delete(int idFornecedor) {
        
        String sql = "DELETE FROM Fornecedor_tb "
                + " WHERE id_fornecedor = '" + idFornecedor + "'";
        
        try {
            
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor eliminado com sucesso\n",
                    "ELIMINAR FORNECEDOR", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o fornecedor.\n"
                    + "Este fornecedor tem ligação com vários fornecedors." ,
                    "ELIMINAR FORNECEDOR", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            ConnectionJDBC.closeConnection(conn, stmt);
            
        }
        
    }
    
    public ArrayList<Fornecedor> readCombobox() {
        
        String sql = "SELECT  nome_fornecedor  FROM Fornecedor_tb ORDER BY nome_fornecedor";
        
        try {
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                fornecedor = new Fornecedor(rs.getString("nome_fornecedor"));
                
                listaDeClassificacoes.add(fornecedor);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos fornecedors\n",
                    "LEITURA DOS FORNECEDOR", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            ConnectionJDBC.closeConnection(conn, stmt, rs);
            
        }
        
        return listaDeClassificacoes;
    }
    
    protected ArrayList<Fornecedor> read() {
        
        String sql = "SELECT  *  FROM Fornecedor_tb ORDER BY id_fornecedor";
        
        try {
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                fornecedor = new Fornecedor();
                
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));                
                fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelemovel1(rs.getString("telemovel1"));
                fornecedor.setTelemovel2(rs.getString("telemovel2"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setWhats_app(rs.getString("whats_app"));
                
                listaDeClassificacoes.add(fornecedor);
                
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos fornecedors\n",
                    "LEITURA DOS FORNECEDOR", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            ConnectionJDBC.closeConnection(conn, stmt, rs);
            
        }
        
        return listaDeClassificacoes;
    }
    
    protected boolean contem(Fornecedor fornecedor) {
        
        boolean existe = false;
        
        String novoFornecedor = null;
        
        String nome_fornecedor = fornecedor.getNomeFornecedor();
        String endereco = fornecedor.getEndereco();
        
        String sql = "SELECT nome_fornecedor"
                + " FROM Fornecedor_tb "
                + " WHERE nome_fornecedor = ? AND endereco = ?";
        
        try {
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_fornecedor);
            stmt.setString(2, endereco);
            
            rs = stmt.executeQuery();
            rs.next();
            
            novoFornecedor = rs.getString("nome_fornecedor");
            
            if (novoFornecedor.equals(nome_fornecedor)) {
                existe = true;
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do fornecedor\n " + novoFornecedor + "\n" + ex,
                    "CADASTRO DE FORNECEDOR", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            
            ConnectionJDBC.closeConnection(conn, stmt, rs);
            
        }
        
        return existe;
    }
    
    public int getIdClente(String nomeFornecedor) {
        
        String sql = "SELECT id_fornecedor "
                + " FROM fornecedor_tb"
                + " WHERE nome_fornecedor = ? ";
        
        int idFornecedor = 0;
        
        try {
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeFornecedor);
            
            rs = stmt.executeQuery();
            
            rs.next();
            
            idFornecedor = rs.getInt("id_fornecedor");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa ID do fornecedor\n",
                    "PESQUISA DE FORNECEDOR ", JOptionPane.ERROR_MESSAGE);
        } finally {
            
        }
        
        return idFornecedor;
        
    }
    
    
    
    
    
       private List<Fornecedor> getNumberItemTable() {

        String sql = "SELECT id_fornecedor FROM fornecedor_tb ORDER BY nome_fornecedor ";

        List lista = new ArrayList<Fornecedor>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            fornecedor = null;
            while (rs.next()) {

                fornecedor = new Fornecedor(rs.getInt("id_fornecedor"));

                lista.add(fornecedor);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do fornecedor\n"
                    + "O correu um erro ao ler todos os IDs",
                    "LEITURA DO PRODUTO SALVAR", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lista;

    } 


/**
     * @return Actualiza o número de ordem na lista de PRODUTO para ser
     * impresso.
     *
     * A contagem de número de ordem começa apartir de 1 até n.
     * @param fornecedor
     */
    protected void updateSequenceNumber() {

        String sql = "UPDATE public.fornecedor_tb "
                + "	SET contador = ? "
                + "	WHERE  id_fornecedor = ? ";

        List<Fornecedor> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (Fornecedor produt : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, produt.getIdFornecedor());
                contador++;

                stmt.executeUpdate();

            }
//
//            JOptionPane.showMessageDialog(null, "Fornecedor actualizado com sucesso\n",
//                    "ACTUALIZAÇÃO DE PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o número de sequência\n" ,
//                    "ACTUALIZAÇÃO DO NÚMERO DE SEQUÊNCIA", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    
    
    
    
    
    
}
