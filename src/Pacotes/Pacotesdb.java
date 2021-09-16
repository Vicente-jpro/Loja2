/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacotes;

import Connectiondb.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class Pacotesdb {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public Pacotesdb() {

        con = ConnectionJDBC.getConnection();

    }

//    Table: Pacotestb
//Columns:
//idPacote	int(11) AI PK
//descricao	varchar(15)
//duracaoEmHoras	
    public int getIdPacoteEscolhido( Pacotes pacote ) {

        int idPacote = 0;

        String sql = "SELECT idPacote FROM Pacotestb WHERE descricao = ? ";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, pacote.getDescricao());
            rs = stmt.executeQuery();
             
            rs.next();
            idPacote = rs.getInt("idPacote");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel obter o id do Pacote \n" ,
                    "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return idPacote;

    }
    
 

    public List<Pacotes> readPacotes() {

        List lista = new ArrayList<>();

        String sql = "SELECT descricao FROM Pacotestb";

        try {

            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            while ( rs.next() ) {

                Pacotes pacotes = new Pacotes();

                pacotes.setDescricao(rs.getString("descricao"));

                lista.add(pacotes);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel obter a leitura dos Pacotes \n" + ex,
                    "ERRO NA LEITURA DO PACOTE ", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return lista;
    }

    
    /*
    
CREATE TABLE IF NOT EXISTS public.pacotestb
(
    idpacote integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    descricao character varying(15) COLLATE pg_catalog."default" NOT NULL,
    duracaoemhoras real NOT NULL,
    CONSTRAINT pacotestb_pkey PRIMARY KEY (idpacote)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pacotestb
    OWNER to postgres;
    
    
    
    
INSERT INTO pacotestb (descricao, duracaoemhoras) VALUES ('1 mês', 744);
INSERT INTO pacotestb (descricao, duracaoemhoras) VALUES ('3 meses', 2232);
INSERT INTO pacotestb (descricao, duracaoemhoras) VALUES ('6 meses', 4464);
INSERT INTO pacotestb (descricao, duracaoemhoras) VALUES ('1 ano', 8928);
    
    */
    
}
