/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.dao;

import br.com.reges.contatos.models.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe de Acesso à Dados referente ao Contato
 *
 * @author luizricardo
 */
public class ContatoDao extends Dao {

    /**
     * Método responsável por preencher um contato com os dados do banco
     *
     * @param idContato Id do Contato
     * @return Contato
     * @throws SQLException
     */
    public Contato getContato(int idContato) throws SQLException {
        //Query
        String sql = "select * from Contato where idContato = ?";

        //Criar o Statement
        PreparedStatement pst = getConnection().prepareStatement(sql);

        //Setar os Parâmetros
        pst.setInt(1, idContato);

        //Criar ResulSet
        ResultSet rs = pst.executeQuery();

        //Exceutar a Leitura
        rs.next();

        //Instanciar Contato
        Contato contato = new Contato();

        //Preencher Contato
        contato.setId(rs.getInt("idContato"));
        contato.setNome(rs.getString("nome"));
        contato.setSobrenome(rs.getString("sobrenome"));
        contato.setApelido(rs.getString("apelido"));
        contato.setGenero(rs.getString("genero"));
        contato.setTitulo(rs.getString("titulo"));

        //Instanciar Classe de Acesso à Dados do Emails
        EmailDao emailDao = new EmailDao();
        
        //Adicionar os E-mails do Contato
        contato.emails  = emailDao.select(contato);
        
        //Liberar controles usados
        rs.close();
        pst.close();
        getConnection().close();

        //Retornar o contato
        return contato;
    }

    /**
     * Método que busca os dados no banco
     *
     * @return Lista de Contatos
     * @throws SQLException
     */
    public ArrayList<Contato> select() throws SQLException {
        //Criar lista de Contatos
        ArrayList<Contato> contatos = new ArrayList<Contato>();

        //Query
        String sql = "select * from Contato";

        //Criar o Statement
        Statement pst = getConnection().createStatement();

        //Criar ResulSet
        ResultSet rs = pst.executeQuery(sql);

        //Iterar ResultSet
        while (rs.next()) {
            //Instanciar Contato
            Contato contato = new Contato();

            //Preencher Contato
            contato.setId(rs.getInt("idContato"));
            contato.setNome(rs.getString("nome"));
            contato.setSobrenome(rs.getString("sobrenome"));
            contato.setApelido(rs.getString("apelido"));
            contato.setGenero(rs.getString("genero"));
            contato.setTitulo(rs.getString("titulo"));

            //Adicionar contato à Lista
            contatos.add(contato);
        }

        //Liberar controles usados
        rs.close();
        pst.close();
        getConnection().close();

        //Retornar a lista
        return contatos;
    }

    /**
     * Método que insere um novo registro no banco de dados
     *
     * @param contato Contato
     * @throws SQLException
     */
    public void insert(Contato contato) throws SQLException {
        //Query
        String sql = "insert into Contato(nome, sobrenome, apelido, genero, titulo) values(?, ?, ?, ?, ?)";

        //Criar o Statement
        PreparedStatement pst = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        //Setar os parâmetros
        pst.setString(1, contato.getNome());
        pst.setString(2, contato.getSobrenome());
        pst.setString(3, contato.getApelido());
        pst.setString(4, contato.getGenero());
        pst.setString(5, contato.getTitulo());

        //Executar o comando
        pst.execute();
        
        //Criar ResultSet
        ResultSet rs = pst.getGeneratedKeys();
        rs.next();
        
        //Preencher o Id Gerado
        contato.setId(rs.getInt(1));

        //Liberar controles usados
        pst.close();
        getConnection().close();
    }

    /**
     * Método responsável por atualizar um contato no banco
     *
     * @param contato Contato
     * @throws SQLException
     */
    public void update(Contato contato) throws SQLException {
        //Query
        String sql = "update Contato set nome = ?, sobrenome = ?, apelido = ?, genero = ?, titulo = ? where idContato=?";

        //Criar o Statement
        PreparedStatement pst = getConnection().prepareStatement(sql);

        //Setar os parâmetros
        pst.setString(1, contato.getNome());
        pst.setString(2, contato.getSobrenome());
        pst.setString(3, contato.getApelido());
        pst.setString(4, contato.getGenero());
        pst.setString(5, contato.getTitulo());
        pst.setInt(6, contato.getId());

        //Executar o comando
        pst.execute();

        //Liberar controles usados
        pst.close();
        getConnection().close();
    }

    /**
     * Método que deleta um registro no banco de dados
     *
     * @param contato Cotação
     * @throws java.sql.SQLException
     */
    public void delete(Contato contato) throws SQLException {
        //Query
        String sql = "delete from Contato where idContato=?";

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
