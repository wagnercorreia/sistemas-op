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

    public int getIdent() {
        return this.id;
    }

    @Override
    public void run() { //método principal

        try {

            for (int i = 1; i <= 100; i++) {
                int quantidadeAnterior = this.notebook.getQuantidade();
                this.notebook.decrementar(i, this.id);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
