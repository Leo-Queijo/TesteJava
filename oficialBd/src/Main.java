import br.com.ecommerce.dao.CupomDAO;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.model.Cupom;
import br.com.ecommerce.model.Produto;

public class Main {
    public static void main(String[] args) {

        try {

            // 🏷️ TESTE CUPOM
            CupomDAO cupomDAO = new CupomDAO();

            Cupom cupom = cupomDAO.buscarPorCodigo("DESCONTO10");

            if (cupom != null) {
                System.out.println("Cupom: " + cupom.getCodigo());
                System.out.println("Desconto: " + cupom.getValorDesconto());
            } else {
                System.out.println("Cupom não encontrado");
            }

            System.out.println("---------------------");

            // 🛍️ TESTE PRODUTO
            ProdutoDAO produtoDAO = new ProdutoDAO();

            Produto produto = produtoDAO.buscarPorId(1);

            if (produto != null) {
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Valor: " + produto.getValor());
            } else {
                System.out.println("Produto não encontrado");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}