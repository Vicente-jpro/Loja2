/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package current_user;

import Connectiondb.ConnectionJDBC;
import interfaces.DropAndCreat_table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class CurrentUserdb implements DropAndCreat_table {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public CurrentUserdb() {

        con = ConnectionJDBC.getConnection();
    }

    //id_current_user, current_user_id
    public void create(CurrentUser user) {

        String sql = "INSERT INTO current_user_tb ( current_user_id )"
                + "VALUES ( ? )";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, user.getIdUsuario());

            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Usuario corrente adicionado com sucesso",
//                    "USUARIO CORRENTE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel criar um novo usuario \n" + ex,
                    "USUARIO CORRENTE", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

    /**
     *
     * @return Pega o id do usuario actual que esta a usar a aplicacao
     */
    public int feachIdCurrentUser() {

        int current_user_id = 0;
        String sql = "SELECT current_user_id FROM current_user_tb WHERE current_user_id > 0";

        try {

            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();
            rs.next();

            current_user_id = rs.getInt("current_user_id");
//
//            JOptionPane.showMessageDialog(null, "Usuario corrente adicionado com sucesso",
//                    "USUARIO CORRENTE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel criar um novo usuario \n" + ex,
                    "USUARIO CORRENTE", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return current_user_id;
    }

    @Override
    public void drop_table() {

        String sql = "DROP TABLE public.current_user_tb";

        try {

            stmt = con.prepareStatement(sql);

            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Lista do antigo usuario eliminado com sucesso",
//                    "USUARIO CORRENTE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel eliminar a lista do antigo usuario \n" + ex,
                    "USUARIO CORRENTE", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

    @Override
    public void create_table() {

        String sql = "CREATE TABLE public.current_user_tb\n"
                + "(\n"
                + "    id_current_user integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),\n"
                + "    current_user_id integer,\n"
                + "    CONSTRAINT current_user_tb_pkey PRIMARY KEY (id_current_user),\n"
                + "    CONSTRAINT current_user_tb_current_user_id_fkey FOREIGN KEY (current_user_id)\n"
                + "        REFERENCES public.usuario_tb (id_usuario) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION\n"
                + ")\n"
                + "WITH (\n"
                + "    OIDS = FALSE\n"
                + ")\n"
                + "TABLESPACE pg_default;\n"
                + "\n"
                + "ALTER TABLE public.current_user_tb\n"
                + "    OWNER to postgres;";

        try {

            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Lista do antigo usuario criada com sucesso",
//                    "USUARIO CORRENTE", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel criar a lista do antigo usuario \n" + ex,
                    "USUARIO CORRENTE", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

}
