package repositories;

import models.Tear;

import java.util.ArrayList;
import java.util.List;

public class TearesRegistrados {


    private List<Tear> teares = new ArrayList<>();


    public void adicionarTear(Tear tear){
        teares.add(tear);
    }

    public Tear removerTear(int numeracao){

        Tear tear = buscarTearPorNumero(numeracao);
        if(tear == null)
            return null;
        
        teares.remove(tear);
        return tear;
    }

    public Tear buscarTearPorNumero(int numeracao){

        /** 
        for (int i = 0; i < teares.size(); i++){
            Tear atual = teares.get(i);

            if (atual.getNumero() == numeracao)
                return i;
        }
        // Se encontrar o tear, o método retorna sua posição.

        return -1;
    */
        for (Tear t : teares){
            if (t.getNumero() == numeracao)
                return t;
        }

        return null;
    }

    public Tear getTear(int numeracao){
        return teares.get(buscarTearPorNumero(numeracao));
    }



}
