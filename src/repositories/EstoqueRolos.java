package repositories;

import models.Rolo;

import java.util.*;

public class EstoqueRolos {

    private List<Rolo> rolos = new ArrayList<>();

    // Adicionar rolo no estoque
    public void adicionarRolo(Rolo roloNovo) {
        rolos.add(roloNovo);
    }

    public List<Rolo> getRolos() {
        //return rolos;
        return Collections.unmodifiableList(rolos);
    }

    public void listarRolos(){
        int i = 0;
        for (Rolo r : rolos){
            i++;
            System.out.println("========== ROLO " + i + " ==========");
            System.out.println("Artigo: " + r.getArtigo());
            System.out.println("Numero do rolo: " + r.getNumeracaoRolo());
            System.out.println("Metragem: " + r.getMetragem());
            System.out.println("Peso: " + r.getPeso());
        }
        System.out.println();
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
