package usuario;

import usuario.*;
import javax.swing.JOptionPane;

public class UsuarioConnectiondb {

    private Usuariodb usuariodb;
    private Usuario usuario;

    protected void actualizar(Usuario usuario, String opcao) {

        usuariodb = new Usuariodb();

//        boolean existeClassificacao = usuariodb.contem(usuario);
//
//        if ( !existeClassificacao ) {
//
//            JOptionPane.showMessageDialog(null, "Impossível actualizar esse usuario.\n "
//                    + "O usuario {"+usuario.getNomeUsuario()+"} já existe no banco de dados",
//                    "ACTUALIZAR FORNECEDOR", JOptionPane.ERROR_MESSAGE);
//        } else {

            usuariodb = new Usuariodb();

            usuariodb.update(usuario, opcao);

//        }
    }

    protected void eliminar(int idUsuario) {

        usuariodb = new Usuariodb();

        usuariodb.delete(idUsuario);

    }

    protected void salvar(Usuario usuario) {

        usuariodb = new Usuariodb();

        boolean existeClassificacao = usuariodb.contem(usuario);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível salvar esse usuario.\nEsse usuario já existe",
                    "SALVAR FORNECEDOR", JOptionPane.ERROR_MESSAGE);
        } else {

            usuariodb = new Usuariodb();

            usuariodb.create(usuario);

        }

    }

   public int validarUsuario( Usuario usuario ) {
        
        
            usuariodb = new Usuariodb();

            int idUsuario = usuariodb.getIdUsuario( usuario );
            
        return idUsuario;
    }
   
   public boolean validarAdmininistrador( Usuario usuario ){

       usuariodb = new Usuariodb();

       return usuariodb.isAdministrador( usuario ) ; // true if is Aministrator
   
   }

}
