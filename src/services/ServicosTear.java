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

        // Verificar se o tear existe
        if (tear == null)
            throw new RuntimeException("Tear não encontrado");
        // Verificar se o tear tem rolo
        if (!tear.temRolo())
            throw new RuntimeException("O tear já não possui rolo");

        Rolo rolo = tear.getRolo();

        // Depois adicionar verificador de quantidade de urdume, se o rolo estiver no fim.
        // Perguntar se quer voltar o rolo pro estoque ou se quer declarar fim de rolo.
        estoque.adicionarRolo(rolo);
        tear.setRolo(null);
        tear.setStatus(StatusTear.DISPONIVEL);
        
    }

    // Transfere um rolo de um tear para outro.
    public void transferirRolo(int numeracaoTear1, int numeracaoTear2) {
        // Transferir do tear1 pro tear2

        Tear tear1 = teares.buscarTearPorNumero(numeracaoTear1);
        Tear tear2 = teares.buscarTearPorNumero(numeracaoTear2);

        // Verificar existencia dos teares
        if(tear1 == null)
            throw new RuntimeException("Tear " + numeracaoTear1 + " não econtrado");
        if(tear2 == null)
            throw new RuntimeException("Tear " + numeracaoTear2 + " não econtrado");

        //Verificar se os teares tem ou não rolo
        if(!tear1.temRolo()) //Tear 1 tem que ter rolo
            throw new RuntimeException("Tear " + tear1.getNumero() + " não possui rolo para transferir");
        if(tear2.temRolo())//Tear 2 não pode ter rolo
            throw new RuntimeException("Tear  "+ tear2.getNumero() +" já possui rolo");
        // Depois perguntar se quer remover o rolo e colocar no estoque ou inverter os rolos
        // Exemplo, do tear 1 ir pro tear 2 e do tear 2 ir pro tear 1

        tear2.setRolo(tear1.getRolo()); // Associar rolo do tear 1 ao tear 2
        tear2.setStatus(StatusTear.PARADO); // Mudar status do tear 2
        tear1.setRolo(null); // Remover o rolo do tear 1
        tear1.setStatus(StatusTear.DISPONIVEL); // Mudar status do tear 1

    }

    // A ideia é que quando for necessário reengrupar o rolo, informar o peso do urdume retirado
    // e fazer um cálculo de quantos metros foram tirados do rolo para atualizar a metragem restante
    public void reengruparRolo(Rolo rolo, Double peso) {


    }


}