package services;


import models.Tear;
import repositories.TearesRegistrados;

//Esta classe é responsável por adicionar e remover teares
public class GerirTear {

    TearesRegistrados teares;

    public GerirTear(TearesRegistrados teares){
        this.teares = teares;
    }


    public void adicionarTear(int numeracao){
        Tear tear = teares.buscarTearPorNumero(numeracao);

        if(tear != null)
            throw new RuntimeException("Tear já existente");

        Tear tearNovo = new Tear(numeracao);

        teares.adicionarTear(tearNovo);
    }

    public Tear removerTear(int numeracao){
        return teares.removerTear(numeracao);

        //Depois adicionar outras lógicas de negócio.

        //Se o  tear estiver em produção não pode remover.

        //Se o tear conter rolo, não pode remover.

        //Se não encontrar o tear retornar erro.
    }
}
