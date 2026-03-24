package br.com.ecommerce.dao;

import br.com.ecommerce.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public Produto buscarPorId(int id) throws Exception {

        String sql = "SELECT * FROM PRODUTO WHERE ID = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("ID"));
                    produto.setNome(rs.getString("NOME"));
                    produto.setValor(rs.getDouble("VALOR"));
                    return produto;
                }
            }
        }

        return null;
    }

    public void inserir(Produto produto) throws Exception {

        String sql = "INSERT INTO PRODUTO (ID, NOME, VALOR) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getValor());

            stmt.executeUpdate();
        }
    }

    public List<Produto> listarTodos() throws Exception {

        String sql = "SELECT * FROM PRODUTO";

        List<Produto> lista = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setValor(rs.getDouble("VALOR"));
                lista.add(produto);
            }
        }

        return lista;
    }

    public void deletar(int id) throws Exception {

        String sql = "DELETE FROM PRODUTO WHERE ID = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}