package services;

import models.Rolo;
import repositories.EstoqueRolos;

public class GerirRolo {

    EstoqueRolos estoque;

    public GerirRolo(EstoqueRolos estoque){
        this.estoque = estoque;
    }

    public void adicionarRolo(String artigo, int numeracaoRolo, Double metragem, Double peso){
        Rolo roloNovo = new Rolo(artigo, numeracaoRolo, metragem, peso);


        if(estoque.buscarRoloPorNumero(numeracaoRolo) != null)
            throw new RuntimeException("Código de rolo já existente");
        
        
        estoque.adicionarRolo(roloNovo);
    }
    
}
