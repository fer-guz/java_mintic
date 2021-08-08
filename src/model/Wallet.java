package model;

public class Wallet {

    public static final int CAPACIDAD_MAXIMA = 1000000;

    private int saldo;
    private boolean tieneLimite;
    private int meta;

    public Wallet() {

        super();
        this.saldo = 0;
        this.tieneLimite = true;
    }

    public String saveMoney(int value) {

        if (saldo + value > CAPACIDAD_MAXIMA && tieneLimite) {

            return "No se puede superar el limite " + CAPACIDAD_MAXIMA;
        }

        saldo += value;

        return "Transaccion exitosa, nuevo saldo " + saldo;

    }

    public String takeMoney(int value) {
        if (saldo < value) {
            saldo -= value;
            return "Transaccion exitosa, nuevo saldo " + saldo;
        }

        return "saldo insuficiente";
    }

    public String breakLimit() {
        if (saldo >= 10000 && tieneLimite) {

            saldo -= 10000;

            setTieneLimite(false);
            return "Has roto los limites!!!";

        }
        return "no tiene saldo suiciente para romper los limites d tu cuenta :(";
    }

    public boolean establecerMeta(int valor){

        if(valor == 0){
            meta = valor;
            return true;

        }
        if(valor < 0 || valor <= saldo || valor > CAPACIDAD_MAXIMA && tieneLimite){

            return false;
        }

        meta = valor;
        return true;
    }

    public boolean verificarMeta(){
        if(meta == 0 || meta > saldo){
            return false;
        }else{
            return true;
        }

        
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isTieneLimite() {
        return tieneLimite;
    }

    public void setTieneLimite(boolean tieneLimite) {
        this.tieneLimite = tieneLimite;
    }

    public static int getCapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
    }

}
