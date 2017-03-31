package threadssistemasoperacionais;

public class Executar {
    public static void main(String[] args) {
        
        Lote notebook = new Lote("Notebook", 500);
        
        //Distribuidor 1
        Distribuidor d1 = new Distribuidor(notebook); //objeto 1
        d1.setIdent(1);

        Thread t1 = new Thread(d1); //cria thread do objeto 1
        t1.start();  //inicia

        //Distribuidor 2
        Distribuidor d2 = new Distribuidor(notebook);  //objeto 2
        d2.setIdent(2);

        Thread t2 = new Thread(d2); //cria thread do objeto 2
        t2.start();   //inicia
        
        //Distribuidor 3
        Distribuidor d3 = new Distribuidor(notebook);  //objeto 3
        d3.setIdent(3);

        Thread t3 = new Thread(d3); //cria thread do objeto 3
        t3.start();   //inicia

        //Distribuidor 4
        Distribuidor d4 = new Distribuidor(notebook);  //objeto 4
        d4.setIdent(4);

        Thread t4 = new Thread(d4); //cria thread do objeto 3
        t4.start();   //inicia
        
    }
}
