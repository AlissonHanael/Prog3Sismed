/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.bsi.sismed.dao;

import br.edu.ifpr.bsi.sismed.bean.Estado;
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
public class EstadoDAO {
    public static void inserir(Estado estado) throws SQLException {
        //captura a conexão com o banco de dados
        Connection con = Conexao.getConexao();
        //criação do SQL
        String sql = "insert into estados (nomeEstado, siglaEstado) "
                + "values (?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, estado.getNomeEstado());
        stmt.setString(2, estado.getSiglaEstado());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public static void alterar(Estado estado) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "update estados set nomeEstado =?, siglaEstado=?"
                + "where idestado= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, estado.getNomeEstado());
        stmt.setString(2, estado.getSiglaEstado());
        stmt.setInt(3, estado.getIdEstado());
        stmt.executeUpdate();
        //fecha o statement
        stmt.close();
        //fecha a conexão
        con.close();

    }

    public static void excluir(Estado estado) throws SQLException {
        Connection con = Conexao.getConexao();
        String sql = "delete from estados where idestado=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, estado.getIdEstado());
        stmt.executeUpdate();
        //fecha o statement
        stmt.close();
        //fecha a conexão
        con.close();

    }

    public static List<Estado> listar() throws SQLException {
        //criação da lista de estados
        List<Estado> listaEstados = new ArrayList<Estado>();
        
        
        Connection con = Conexao.getConexao();
        //retorna uma seleção da tabela ordenada pelo nome do estado
        String sql = "select * from estados order by nomeEstado";
       
        PreparedStatement stmt = con.prepareStatement(sql);
        //recebe o resultado da seleção da tabela
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Estado estado = new Estado();
            estado.setIdEstado(rs.getInt("idEstado"));
            estado.setNomeEstado(rs.getString("nomeEstado"));
            estado.setSiglaEstado(rs.getString("siglaEstado"));
            listaEstados.add(estado);
        }
        stmt.close();
        //fecha a conexão
        rs.close();
        con.close();
        return listaEstados;

    }
    
     public static List<Estado> pesquisar(Estado estadoPesq) throws SQLException {
        //criação da lista de estados
        List<Estado> listaEstados = new ArrayList<Estado>();
        
        
        Connection con = Conexao.getConexao();
        //retorna uma seleção da tabela ordenada pelo nome do estado
        String sql = "select * from estados where nomeEstado like '" + estadoPesq.getNomeEstado()+ "%' order by nomeEstado";
       
        PreparedStatement stmt = con.prepareStatement(sql);
        //recebe o resultado da seleção da tabela
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Estado estado = new Estado();
            estado.setIdEstado(rs.getInt("idestado"));
            estado.setNomeEstado(rs.getString("nomeEstado"));
            estado.setSiglaEstado(rs.getString("siglaEstado"));
            listaEstados.add(estado);
        }
        stmt.close();
        //fecha a conexão
        rs.close();
        con.close();
        return listaEstados;

    }
}
