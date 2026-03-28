package models;

public class Rolo{

    // Futuramente adicionar uma classe artigo, cada artigo
    // Vai ter as configurações já feitas
    private String artigo;  

    // Cada rolo tem que ter uma numeração única
    private int numeracaoRolo;

    private Double metragem;
    private Double metragemRestante;
    private Double peso;

    public Rolo(String artigo, int numeracaoRolo, Double metragem, Double peso){

        this.artigo = artigo;
        this.numeracaoRolo = numeracaoRolo;
        this.metragem = metragem;
        this.peso = peso;

    }

    public int getNumeracaoRolo(){
        return numeracaoRolo;
    }



}