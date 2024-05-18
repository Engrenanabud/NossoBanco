import java.util.Scanner;

public class ContaCorrente {

    private String cliente;
    private int numeroConta;
    private String agencia;
    private float saldo;

    public ContaCorrente(String cliente, int numeroConta, String agencia, float saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public ContaCorrente() {

    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String toString() {

        return "Dados da sua conta: " + "\nCliente: " + cliente + "\nAgencia: " + agencia + "\nConta: " + numeroConta + "\nSaldo Total: " + String.format("\nR$ %.4f \n", saldo);

    }

}








