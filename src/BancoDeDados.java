import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

        static List<ContaCorrente> contas = new ArrayList<>();


        //conta é o parâmetro pedido na hora de salvar
        public static void salvarConta(ContaCorrente conta) {
                        contas.add(conta);
        }

        public static List<ContaCorrente> buscarContas() {
                return contas;
        }
}