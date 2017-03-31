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
    private int preco;
    private final Semaphore semaforo = new Semaphore(1);

    public Lote(String produto, int quantidade) {
        this.nomeProduto = produto;
        this.quantidade = quantidade;
        this.preco = 0;
    }

    public boolean decrementar(int qtd, int nome) {

        try {
            semaforo.acquire();

            if (this.quantidade >= qtd) {

                int quantidadeAnterior = this.quantidade;

                this.quantidade -= qtd;

                System.out.println("Distribuidor " + nome + " solicita " + qtd + " unidades de " + this.nomeProduto + ".");
                System.out.println("Quantidade anterior: " + quantidadeAnterior);
                System.out.println("QUantidade atual: " + this.quantidade);
                System.out.println("------------------------------");

                return true;
            } else {
                System.out.println("Distribuidor " + nome + " solicita " + qtd + " unidades de " + this.nomeProduto + ".");
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}