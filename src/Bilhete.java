import java.util.Random;

public class Bilhete {
    static final double TARIFABASE = 5.20;
    long numero;
    double saldo;
    Usuario usuario;

    public Bilhete(Usuario usuario) {
        Random rd = new Random();
        this.numero = rd.nextInt(1000, 10000);
        this.usuario = usuario;
    }

    // Métido para carregar o bilhete

    public double carregarBilhete( double valorRecarga){
        saldo += valorRecarga;

        return saldo;
    }

    // Método para consultar o saldo do bilhete
    public double consultarSaldo(){
        return saldo;
    }

    // Método para simular a passagem na catraca
    public String passarCatraca(){
       double debito = TARIFABASE/2;

        if(usuario.perfil.equalsIgnoreCase("COMUM")){
            debito = TARIFABASE;
        }

        if (saldo >= debito){
            saldo -= debito;
            return "Passagem liberada \n Saldo restante:" + saldo;
        }
            return "Saldo insuficiente \n Saldo atual:" + saldo;
    }
}
