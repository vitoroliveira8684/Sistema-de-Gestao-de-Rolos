import repositories.EstoqueRolos;
import repositories.TearesRegistrados;
import services.GerirRolo;
import services.GerirTear;
import services.ServicosTear;

public class Main{

    public static void main(String[] args){

        EstoqueRolos estoque = new EstoqueRolos();
        TearesRegistrados teares = new TearesRegistrados();

        GerirRolo gestaoRolo = new GerirRolo(estoque);
        GerirTear gestaoTear = new GerirTear(teares);
        ServicosTear servicos = new ServicosTear(estoque, teares);


        System.out.println("Estoque antes de adicionar rolos:");
        estoque.listarRolos();
        
        gestaoRolo.adicionarRolo("Algodão", 2, 20.0, 30.5);
        gestaoRolo.adicionarRolo("Poliester", 3, 80.0, 100.2);

        System.out.println("Estoque depois de adicionar rolos:");
        estoque.listarRolos();

        System.out.println("Antes de adicionar os teares:");
        teares.listarTeares();

        gestaoTear.adicionarTear(1);
        gestaoTear.adicionarTear(2);
        gestaoTear.adicionarTear(3);

        System.out.println("Depois de adicionar os teares:");
        teares.listarTeares();

        servicos.colocarRolo(1, 2);
        servicos.colocarRolo(2, 3);

        System.out.println("Estoque depois de adicionar os rolos no tear: ");

        estoque.listarRolos();

        System.out.println("Teares depois de inserir os rolos:");

        teares.listarTeares();

        servicos.transferirRolo(1, 3);

        System.out.println("Teares depois da transferencia:");

        teares.listarTeares();
        

}
}
