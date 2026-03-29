package models;

public class Tear {

    private int numero; // Numeração do tear
    private Rolo rolo; // Rolo associado ao tear
    private StatusTear status;


    public enum StatusTear{
        PRODUZINDO, // Estado desejável do tear
        PARADO, // O tear deveria estar produzindo, mas está parado (parada normal)
        MANUTENCAO, // o tear está com problema mecânico (parado)
        DISPONIVEL // Quando o tear está parado, mas sem rolo (disponível pra adicionar rolo)
    }


    public Tear(int numero){
        this.numero = numero;
        this.status = StatusTear.DISPONIVEL;
    }


    public int getNumero(){
        return this.numero;
    }

    public Rolo getRolo(){
        return this.rolo;
    }


    public void setRolo(Rolo rolo){
        this.rolo = rolo;
    }

    public boolean temRolo(){
        return (rolo != null);
    }

    public boolean podeReceberRolo(){
        if(!temRolo() && status == StatusTear.DISPONIVEL)
            return true;
        return false;
    }

    public StatusTear getStatus(){
        return status;
    }

    public void setStatus(StatusTear status){
        this.status = status;
    }
}