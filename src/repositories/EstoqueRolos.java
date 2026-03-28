package repositories;

import models.Rolo;

import java.util.*;

public class EstoqueRolos {

    private List<Rolo> rolos = new ArrayList<>();

    // Adicionar rolo no estoque
    public void adicionarRolo(Rolo rolo) {
        rolos.add(rolo);
    }

    public List<Rolo> getRolos() {
        //return rolos;
        return Collections.unmodifiableList(rolos);
    }

    public Rolo removerRolo(int numeracao) {

        Rolo rolo = buscarRoloPorNumero(numeracao);

        if (rolo == null)
            return null;

        rolos.remove(rolo);
        return rolo;
    }

    public Rolo buscarRoloPorNumero(int numeracao) {

        // Lógica para procurar o rolo na lista do
        for (Rolo r : rolos){
            if(r.getNumeracaoRolo() == numeracao)
                return r;
        }

        return null;
    }


}
