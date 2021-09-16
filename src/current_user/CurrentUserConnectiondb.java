/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package current_user;

import interfaces.DropAndCreat_table;


/**
 * Class responsaverl por usar as conexoes do banco de dados
 *
 * @author vicente
 */
public class CurrentUserConnectiondb implements DropAndCreat_table{

    private CurrentUser users;
    private CurrentUserdb userdb;

    public void savarUsuario(int idUser) {

        
        userdb = new CurrentUserdb();

        users = new CurrentUser();

        users.setIdUsuario(idUser);

        userdb.create( users );

        // return false;
    }

    @Override
    public void drop_table() {
        
        
             userdb = new CurrentUserdb();

      

        userdb.drop_table();
        
    }

    @Override
    public void create_table() {
    
        
             userdb = new CurrentUserdb();

      

        userdb.create_table();
    
    }

}
