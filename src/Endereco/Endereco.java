/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Endereco;

/**
 *
 * @author vicente-jpro
 */
public class Endereco {

  private String endereco ,
            telemovel1,
            telemovel2,
            email,
            whats_app;

  public Endereco(){
  
  }
  
    public Endereco(String endereco, String telemovel1, String telemovel2, String email, String whats_app) {
        this.endereco = endereco;
        this.telemovel1 = telemovel1;
        this.telemovel2 = telemovel2;
        this.email = email;
        this.whats_app = whats_app;
        
        defaultSetters( endereco, telemovel1,
                telemovel2, email, whats_app);
    }
    
    
    
    private void defaultSetters( String endereco, String telemovel1,
            String telemovel2, String email, String whats_app) {

        if (telemovel1.equals("Telemóvel 1") || telemovel1.equals("")) {
            this.telemovel1 = "Nenhum tel1";
        } else {
            this.telemovel1 = telemovel1;
        }

        if (telemovel2.equals("Telemóvel 2") || telemovel2.equals("")) {
            this.telemovel2 = "Nenhum tel2";
        } else {
            this.telemovel2 = telemovel2;
        }

        if (email.equals("Email") || email.equals("")) {
            this.email = "Nenhum email";
        } else {
            this.email = email;
        }

        if (whats_app.equals("WhatsApp") || whats_app.equals("")) {
            this.whats_app = "Nenhum WhatsApp";
        } else {
            this.whats_app = whats_app;
        }

    }
    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelemovel1() {
        return telemovel1;
    }

    public void setTelemovel1(String telemovel1) {
        this.telemovel1 = telemovel1;
    }

    public String getTelemovel2() {
        return telemovel2;
    }

    public void setTelemovel2(String telemovel2) {
        this.telemovel2 = telemovel2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhats_app() {
        return whats_app;
    }

    public void setWhats_app(String whats_app) {
        this.whats_app = whats_app;
    }
  
  
  
}
