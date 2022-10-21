/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.bsi.sismed.dao;

import br.edu.ifpr.bsi.sismed.bean.Convenio;
import br.edu.ifpr.sismed.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alisson
 */
public class ConvenioDAO {
    public static void inserir(Convenio convenio) throws SQLException {
        //captura a conexão com o banco de dados
        Connection con = Conexao.getConexao();
        //criação do SQL
        String sql = "insert into convenios (nomeConvenio) "
                + "values (?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, convenio.getNomeConvenio());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void alterar(Convenio convenio) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "update convenios set nomeConvenio =?"
                + "where idConvenio= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, convenio.getNomeConvenio());
        stmt.setInt(2, convenio.getIdConvenio());
        stmt.executeUpdate();
        //fecha o statement
        stmt.close();
        //fecha a conexão
        con.close();

    }

    public static void excluir(Convenio convenio) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "delete from convenios where idConvenio=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, convenio.getIdConvenio());
        stmt.executeUpdate();
        //fecha o statement
        stmt.close();
        //fecha a conexão
        con.close();

    }

    public static List<Convenio> listar() throws SQLException {
        //criação da lista de convenios
        List<Convenio> listaConvenios = new ArrayList<Convenio>();
        
        
        Connection con = Conexao.getConexao();
        //retorna uma seleção da tabela ordenada pelo nome do convenio
        String sql = "select * from convenios order by nomeConvenio";
       
        PreparedStatement stmt = con.prepareStatement(sql);
        //recebe o resultado da seleção da tabela
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Convenio convenio = new Convenio();
            convenio.setIdConvenio(rs.getInt("idConvenio"));
            convenio.setNomeConvenio(rs.getString("nomeConvenio"));
            
            listaConvenios.add(convenio);
        }
        stmt.close();
        //fecha a conexão
        rs.close();
        con.close();
        return listaConvenios;

    }
    
     public static List<Convenio> pesquisar(Convenio convenioPesq) throws SQLException {
        //criação da lista de convenios
        List<Convenio> listaConvenios = new ArrayList<Convenio>();
        
        
        Connection con = Conexao.getConexao();
        //retorna uma seleção da tabela ordenada pelo nome do convenio
        String sql = "select * from convenios where nomeConvenio like '" + convenioPesq.getNomeConvenio()+ "%' order by nomeConvenio";
       
        PreparedStatement stmt = con.prepareStatement(sql);
        //recebe o resultado da seleção da tabela
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Convenio convenio = new Convenio();
            convenio.setIdConvenio(rs.getInt("idConvenio"));
            convenio.setNomeConvenio(rs.getString("nomeConvenio"));
            listaConvenios.add(convenio);
        }
        stmt.close();
        //fecha a conexão
        rs.close();
        con.close();
        return listaConvenios;

    }
}
