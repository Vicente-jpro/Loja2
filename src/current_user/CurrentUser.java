/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package current_user;

import usuario.Usuario;

/**
 *
 * @author vicente
 */
public class CurrentUser extends Usuario{

    public CurrentUser(){  }
    
    public CurrentUser(int idCurrenteUser) {
        super(idCurrenteUser);
    }
    
  public CurrentUser(String nomeCurrentUser){
  super(nomeCurrentUser);
  }
    
}
