/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatepg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mariano
 */
public class Fabricante {
    private int id;
    private String name;
    private String cidade;
    private String estado;
    private String email;
    
    public static ArrayList<Fabricante> getList() throws Exception {
    ArrayList<Fabricante> list = new ArrayList<> ();
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String url = "jdbc:derby://localhost:1527/sample";
    String user = "app";
    String pass = "app";
    Connection con = DriverManager.getConnection(url, user, pass);
    Statement stmt = con.createStatement();
    String sql = "SELECT FABRICANTE_ID, NAME, CIDADE, ESTADO, EMAIL FROM CUSTOMER";
    ResultSet rs = stmt.executeQuery(sql);
    while (rs.next()){
        Fabricante f = new Fabricante (
            rs.getInt("FABRICANTE_ID")
                    , rs.getString("NAME")
                    , rs.getString("CIDADE")
                    , rs.getString("ESTADO")
                    , rs.getString("EMAIL")
        
        );
            list.add(f);
    }
    return list;
    
    }

    public Fabricante(int id, String name, String cidade, String estado, String email) {
        this.id = id;
        this.name = name;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

