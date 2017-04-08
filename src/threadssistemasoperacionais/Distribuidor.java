package threadssistemasoperacionais;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Distribuidor extends Thread {  //ou implements Runnable

    private int id;
    private Lote televisao;
    private Lote notebook;
    private Lote celular;
    private Lote mouse;

    public Distribuidor(Lote notebook) {
        this.notebook = notebook;
    }

    public void setIdent(int id) {
        this.id = id;
    }

    /**
     * Obtém a identificação
     */
    public int getIdent() {
        return this.id;
    }

    @Override
    public void run() { //método principal

        try {
            
            int contNot = 0;
            
            for (int i = 1; i <= 100; i++) {
                int quantidadeAnterior = this.notebook.getQuantidade();
                
                //Sessão Crítica
                if (this.notebook.decrementar(i, this.id)) {
                    contNot += i;
                } else {
                    if (this.notebook.getQuantidade() == 0) {
                        break;
                    } else {
                        contNot += this.notebook.getQuantidade();
                        this.notebook.decrementar(this.notebook.getQuantidade(), this.id);
                    }
                }
                //Fim Sessão Crítica
                
                Thread.sleep(100);
            }
            
            System.out.println("Quantidade de lotes de notebooks adquiridas pelo forncedor "+this.id+" "+contNot);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
