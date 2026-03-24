package br.com.ecommerce.dao;

import br.com.ecommerce.model.Cupom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CupomDAO {

    public Cupom buscarPorCodigo(String codigo) throws Exception {

        String sql = "SELECT * FROM CUPOM WHERE CODIGO = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    Cupom cupom = new Cupom();
                    cupom.setCodigo(rs.getString("CODIGO"));
                    cupom.setValorDesconto(rs.getDouble("VALOR_DESCONTO"));
                    return cupom;
                }
            }
        }

        return null;
    }

    public void inserir(Cupom cupom) throws Exception {

        Connection conn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO CUPOM (CODIGO, VALOR_DESCONTO) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cupom.getCodigo());
        stmt.setDouble(2, cupom.getValorDesconto());

        stmt.executeUpdate();
    }

    // 📋 LISTAR TODOS
    public List<Cupom> listarTodos() throws Exception {

        Connection conn = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM CUPOM";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Cupom> lista = new ArrayList<>();

        while (rs.next()) {
            Cupom cupom = new Cupom();
            cupom.setCodigo(rs.getString("CODIGO"));
            cupom.setValorDesconto(rs.getDouble("VALOR_DESCONTO"));
            lista.add(cupom);
        }

        return lista;
    }
}