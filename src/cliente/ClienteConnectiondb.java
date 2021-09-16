package cliente;

import javax.swing.JOptionPane;

public class ClienteConnectiondb {

    private Clientedb clientedb;
    

    protected void actualizar(Cliente cliente) {
//
//        clientedb = new Clientedb();
//
//        boolean existeClassificacao = clientedb.contem(cliente);
//
//        if ( existeClassificacao ) {
//
//            JOptionPane.showMessageDialog(null, "Impossível actualizar esse cliente.\n "
//                    + "O cliente {"+cliente.getNomeCliente()+"} já existe no banco de dados",
//                    "ACTUALIZAR CLASSE", JOptionPane.ERROR_MESSAGE);
//        } else {

            clientedb = new Clientedb();

            clientedb.update(cliente);

//        }
    }

    protected void eliminar(Cliente cliente) {

        clientedb = new Clientedb();

        clientedb.delete(cliente);

    }

    protected void salvar(Cliente cliente) {

        clientedb = new Clientedb();

        boolean existeClassificacao = clientedb.contem(cliente);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível salvar esse cliente.\nEsse cliente já existe",
                    "SALVAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        } else {

            clientedb = new Clientedb();

            clientedb.create(cliente);

        }

    }

}
