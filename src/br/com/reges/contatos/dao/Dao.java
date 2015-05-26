/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Genérica de Conexão com o Banco de Dados
 * @author luizricardo
 */
public class Dao {

    private static final String banco = "aulaJava";
    private static final String usuario = "root";
    private static final String senha = "spfc0700";

    /**
     * Método que estabelece uma conexão com o banco de dados
     * @return Conexão
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:mysql://localhost/" + banco, usuario, senha);
    }
}
