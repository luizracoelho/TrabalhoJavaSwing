/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.models;

/**
 *
 * @author luizricardo
 */
public class Email {

    String email;
    boolean principal;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        String strPrincipal = this.principal ? " (Principal)" : "";
        return this.email + strPrincipal;
    }

}
