package services;

import models.*;
import models.Tear.StatusTear;
import repositories.EstoqueRolos;
import repositories.TearesRegistrados;

public class ServicosTear {

    EstoqueRolos estoque;
    TearesRegistrados teares;


    public ServicosTear(EstoqueRolos estoque, TearesRegistrados teares){
        this.estoque = estoque;
        this.teares = teares;
    }
    
    // Inserir novos rolos no tear
    public void colocarRolo(int numeracaoTear,  int numeracaoRolo) {


        Tear tear = teares.buscarTearPorNumero(numeracaoTear);

        //Verificar se o tear existe
        if (tear == null)
            throw new RuntimeException("Tear não encontrado");
 
        //Verificar disponibilidade do tear
        if(!tear.podeReceberRolo())
            throw new RuntimeException("Tear não está disponível");

        Rolo rolo = estoque.buscarRoloPorNumero(numeracaoRolo);

        //Verificar se o rolo existe no estoque
        if(rolo == null)
            throw new RuntimeException("Rolo não encontrado");

        
        estoque.removerRolo(numeracaoRolo);
        tear.setRolo(rolo);
        tear.setStatus(StatusTear.PARADO);

    }

    // Remover rolo do tear
    public void removerRolo(int numeracao) {
        Tear tear = teares.buscarTearPorNumero(numeracao);

        if (tear == null)
            throw new RuntimeException("Tear não encontrado");

        if (!tear.temRolo())
            throw new RuntimeException("O tear já não possui rolo");

        Rolo rolo = tear.getRolo();

        estoque.adicionarRolo(rolo);
        tear.setRolo(null);
        tear.setStatus(StatusTear.DISPONIVEL);
        
    }

    // Transfere um rolo de um tear para outro.
    public void transferirRolo(Tear tear1,Tear tear2) {
        // Transferir do tear1 pro tear2

        if (tear2.semRolo()) {
            tear2.setRolo(tear1.getRolo());
            tear1.setRolo(null);
        }


    }

    // A ideia é que quando for necessário reengrupar o rolo, informar o peso do urdume retirado
    // e fazer um cálculo de quantos metros foram tirados do rolo para atualizar a metragem restante
    public void reengruparRolo(Rolo rolo, Double peso) {


    }


}