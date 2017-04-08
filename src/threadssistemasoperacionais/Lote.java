package threadssistemasoperacionais;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class Lote {

    private String nomeProduto;
    private int quantidade;
    private float preco;
    private final Semaphore semaforo = new Semaphore(1);

    public Lote(String produto, int quantidade, float preco) {
        this.nomeProduto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    /**
     * Rotina para decrementar a quantidade do produto no estoque
     * 
     * @param qtd quantidade
     * @param nome nome do distribuidor
     * 
     * @return true em caso de sucesso, false em caso de falha
     */
    public boolean decrementar(int qtd, int nome) {

        try {
            //Semáforo
            semaforo.acquire();

            if (this.quantidade >= qtd) {

                int quantidadeAnterior = this.quantidade;

                this.quantidade -= qtd;

                System.out.println("Distribuidor " + nome + " solicita " + qtd + " unidades de " + this.nomeProduto + ".");
                System.out.println("Preço : R$ " + this.preco);
                System.out.println("Quantidade anterior: " + quantidadeAnterior);
                System.out.println("Quantidade atual: " + this.quantidade);
                System.out.println("------------------------------");

                return true;
            } else {
                System.out.println("Distribuidor " + nome + " solicita " + qtd + " unidades de " + this.nomeProduto + ".");
                System.out.println("Preço : R$ " + this.preco);
                System.out.println("Estoque insuficiente");
                System.out.println("------------------------------");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }

        return false;
    }

    /**
     * Este método é um método do tipo get
     * 
     * @param null
     * @return nome do produto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @return Retorna a quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }
}
