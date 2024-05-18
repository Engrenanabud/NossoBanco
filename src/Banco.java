import java.util.Random;
import java.util.Scanner;

public class Banco {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int opcao = 0;


        while (opcao != 5) {

            System.out.println();
            System.out.println("**Bem vindo ao Nosso Banco**");
            System.out.println("Selecione [1] para Criar Conta");
            System.out.println("Selecione [2] para Criar Depósito");
            System.out.println("Selecione [3] para Efetuar Saque");
            System.out.println("Selecione [4] para Verificar Saldo");
            System.out.println("Selecione [5] Finalizar");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    ContaCorrente contaCriada = criarConta();
                    System.out.println("Conta criada com sucesso: " + contaCriada);

                    BancoDeDados.salvarConta(contaCriada);
                    break;

                case 2:

                    break;

                case 3:
                    //retornou a conta no banco de dados e enviou os dados da conta.
                    float saldoDaConta = verificarContaEagencia();
                    System.out.println("Quanto você deseja sacar?");
                    float valorDoSaque = scanner.nextFloat();
                    if (saldoDaConta >= valorDoSaque){
                        saldoDaConta -= valorDoSaque;
                    }
                    System.out.println("Seu saldo é de: "+ saldoDaConta);
                    break;

                case 4:
                    System.out.println("Verificar Saldo");
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Insira uma opcao valida por favor");
            }
        }
    }

    public static int gerarNumeroDeCincoDigitos() {
        Random rand = new Random();
        int numeroGerado = rand.nextInt(90000) + 10000; // Gera um número aleatório entre 10000 e 99999
        return numeroGerado;
    }

    // Cria uma conta do tipo ContaCorrente.
    // Ele pede os atributos da conta e depois armazena no banco.
    // puxa o método que gera um numero de 5 dígitos e armazena em I, dps exibe o I.
    private static ContaCorrente criarConta() {

        System.out.println("Digite seu Nome");
        String nome = scanner.next();
        System.out.println("Digite sua agência");
        String agencia = scanner.next();
        System.out.println("Sua conta será o número: ");
        int i = gerarNumeroDeCincoDigitos();
        System.out.println(i);
        System.out.println("Faça um depósito mínimo inicial: ");
        float depositoInicial = scanner.nextFloat();


        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(nome);
        contaCorrente.setAgencia(agencia);
        contaCorrente.setNumeroConta(i);
        contaCorrente.setSaldo(depositoInicial);
        return contaCorrente;
    }

    public static float verificarContaEagencia() {

        //voce precisa digitar a conta e agencia e ele vai ver se essa conta existe
        //Caso a conta exista,vai ver se o valor a ser sacado é menor ou igual ao saldo da conta.

        System.out.println("Digite sua agencia");
        String agenciaDigitada = scanner.next();
        System.out.println("Digite sua conta");
        int contaDigitada = scanner.nextInt();

        // precisa procurar na lista uma conta que tenha mesma agencia e conta;
        for (ContaCorrente contaCorrenteProcurada : BancoDeDados.buscarContas()) {
            if (contaDigitada == contaCorrenteProcurada.getNumeroConta() && contaCorrenteProcurada.getAgencia().equals(agenciaDigitada)){
               return contaCorrenteProcurada.getSaldo();
            }
        }
        return 0;
    }
}


