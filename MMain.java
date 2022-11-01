import java.util.Scanner;

public class MMain {
      public enum Operacoes {
         SAIR(0), OPERACAO_PACIENTE(1), OPERACAO_MEDICO(2), OPERACAO_CONSULTA(3),
         CADASTRAR(1), ALTERAR(2), REMOVER(3), CONSULTAR(4), RELATORIO(5);

         private final int opcao;

         Operacoes(int vopcao) {
            opcao = vopcao;
         }
         public int getValor() {
            return opcao;
         }
   }

   public static Operacoes opcaoMenu(int index) {
      return Operacoes.values()[index];
   }

   public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);

      Operacoes geral;
      do {
         System.out.print("\nSISTEMA DE GESTÃO DE CONSULTAS\n"
         +"------------------------------------------\n"
         +"1 - Paciente\n"
         +"2 - Medico\n"
         +"3 - Consulta\n"
         +"0 - Sair\n"
         +"Opção: ");

         geral = opcaoMenu(entrada.nextInt());

         switch(geral) {
            case OPERACAO_PACIENTE -> System.out.println("Operação paciente");
            case OPERACAO_MEDICO-> System.out.println("Operação medico");
            case OPERACAO_CONSULTA-> System.out.println("Operação consulta");
            default -> {
               if (!geral.equals(Operacoes.SAIR)) System.out.println("Opção inválida!");
            }
         }
    } while(!geral.equals(Operacoes.SAIR));
      entrada.close();
   }
}