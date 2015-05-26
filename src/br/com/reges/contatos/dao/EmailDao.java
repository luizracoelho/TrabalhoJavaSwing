/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.dao;

import static br.com.reges.contatos.dao.Dao.getConnection;
import br.com.reges.contatos.models.Contato;
import br.com.reges.contatos.models.Email;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe de Acesso à dados de um E-mail
 *
 * @author luizricardo
 */
public class EmailDao extends Dao {

    /**
     * Método que busca os E-mails de determinado Contato no Banco
     *
     * @param contato Contato
     * @return Lista de E-Mails
     * @throws SQLException
     */
    public ArrayList<Email> select(Contato contato) throws SQLException {
        //Criar a Lista de Emails
        ArrayList<Email> emails = new ArrayList<Email>();

        //Query
        String sql = "select * from Email where idContato = ?";

        //Criar o Statement
        PreparedStatement pst = getConnection().prepareStatement(sql);

        //Setar os Parâmetros
        pst.setInt(1, contato.getId());

        //Criar ResulSet
        ResultSet rs = pst.executeQuery();

        //Exceutar a Leitura
        while (rs.next()) {
            //Instanciar Contato
            Email email = new Email();

            //Preencher Contato
            email.setEmail(rs.getString("email"));
            email.setPrincipal(rs.getBoolean("padrao"));

            //Inserir o Email na LIsta
            emails.add(email);
        }

        //Liberar controles usados
        rs.close();
        pst.close();
        getConnection().close();

        //Retornar a Lista de Emails
        return emails;
    }

    /**
     * Inserir o E-mail de Um determinado Contato
     * @param email E-Mail
     * @param contato Contato
     * @throws SQLException 
     */
    public void insert(Email email, Contato contato) throws SQLException{
         //Query
        String sql = "insert into Email(email, padrao, idContato) values(?, ?, ?)";

        //Criar o Statement
        PreparedStatement pst = getConnection().prepareStatement(sql);

        //Setar os parâmetros
        pst.setString(1, email.getEmail());
        pst.setBoolean(2, email.isPrincipal());
        pst.setInt(3, contato.getId());

        //Executar o comando
        pst.execute();

        //Liberar controles usados
        pst.close();
        getConnection().close();
    }
    
    /**
     * Método que deleta os E-mails de um Determinado Contato
     *
     * @param contato
     * @throws SQLException
     */
    public void delete(Contato contato) throws SQLException {
        //Query
        String sql = "delete from Email where idContato=?";

        //Criar o Statement
        PreparedStatement pst = getConnection().prepareStatement(sql);

        //Setar os parâmetros
        pst.setInt(1, contato.getId());

        //Executar o comando
        pst.execute();

        //Liberar controles usados
        pst.close();
        getConnection().close();
    }
}
