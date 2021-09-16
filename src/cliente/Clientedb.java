package cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Clientedb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;
    private Cliente cliente;

    public Clientedb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Cliente>();
    }

    protected void create(Cliente cliente) {

        String sql = "INSERT INTO Cliente_tb ( nome_cliente, morada ) VALUES ( ?, ? )";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getMorada());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso\n",
                    "CADASTRO DE CLIENTES", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o Cliente \n" + ex,
                    "CADASTRO DE CLIENTES DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void update(Cliente cliente) {

        int idCliente = cliente.getIdCliente();

        String sql = "UPDATE Cliente_tb "
                + " SET nome_cliente = ?, morada = ? WHERE  id_cliente = '" + idCliente + "'";

        try {
            System.out.println(""+cliente.getNomeCliente()+"\n"+cliente.getMorada()+"\n"+idCliente);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getMorada());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente actualizado com sucesso\n",
                    "ACTUALIZAÇÃO DE CLIENTES ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o cliente \n" + ex,
                    "ACTUALIZAÇÃO DE CLIENTES", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void delete(Cliente cliente) {

        String sql = "DELETE FROM Cliente_tb "
                + " WHERE id_cliente = '" + cliente.getIdCliente() + "'";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente eliminado com sucesso\n",
                    "ELIMINAR CLIENTES", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o cliente\n"
                    + "Este cliente tem ligações com várias compras",
                    "ELIMINAR CLIENTES", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    public ArrayList<Cliente> read() {

        String sql = "SELECT  *  FROM Cliente_tb ORDER BY id_cliente";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nome_cliente"),
                        rs.getString("morada")
                );

                listaDeClassificacoes.add(cliente);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos clientes\n",
                    "LEITURA DOS CLIENTES", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

    protected boolean contem(Cliente cliente) {

        boolean existe = false;

        String novoCliente = null;

        String nome_cliente = cliente.getNomeCliente();

        String sql = "SELECT nome_cliente"
                + " FROM Cliente_tb "
                + " WHERE nome_cliente = ? ";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_cliente);

            rs = stmt.executeQuery();
            rs.next();

            novoCliente = rs.getString("nome_cliente");

            if (novoCliente.equals(nome_cliente)) {
                existe = true;
            }

        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do cliente\n "+novoCliente+"\n" + ex,
//                    "CADASTRO DE CLIENTES DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    public int getIdClente(Cliente cliente) {

        String sql = "SELECT id_cliente "
                + " FROM cliente_tb"
                + " WHERE nome_cliente = ? ";

        int idCliente = 0;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNomeCliente());

            rs = stmt.executeQuery();

            rs.next();

            idCliente = rs.getInt("id_cliente");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa ID do cliente\n",
                    "PESQUISA DE CLIENTES ", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return idCliente;

    }

    private List<Cliente> getNumberItemTable() {

        String sql = "SELECT id_cliente \n"
                + "	FROM cliente_tb \n"
                + "		ORDER BY nome_cliente ";

        List lista = new ArrayList<Cliente>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            cliente = null;
            while (rs.next()) {

                cliente = new Cliente(rs.getInt("id_cliente"));

                lista.add(cliente);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do cliente\n"
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
     * @param cliente
     */
    protected void updateSequenceNumber() {

        String sql = "UPDATE public.cliente_tb "
                + "	SET contador = ? "
                + "	WHERE  id_cliente = ? ";

        List<Cliente> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (Cliente cliente : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, cliente.getIdCliente());
                contador++;

                stmt.executeUpdate();

            }
//
//            JOptionPane.showMessageDialog(null, "Cliente actualizado com sucesso\n",
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
