import java.util.EnumSet;
import java.util.Scanner;

import java.lang.reflect.Method;

public class Main {
   public enum OpGeral { SAIR, OPERACAO_PACIENTE, OPERACAO_MEDICO, OPERACAO_CONSULTA }
   public enum OpFicharios { SAIR, CADASTRAR, ALTERAR, REMOVER, CONSULTAR, RELATORIO }

   private static Enum<?> validationOption(int index, Enum<?>[] OperationType) {

      Method method = OperationType.getMethod("valueOf", String);

      Enum<?> opcao = EnumSet.allOf(OperationType.class).stream()
         .filter(op -> op.ordinal() == index
      ).findAny().orElse(method.invoke(null, "SAIR"));

      return opcao;
   }

   public static void main(String[] args) {
      System.out.println(validationOption(1, OpGeral));
   //    Scanner entrada = new Scanner(System.in);
   //    int opcaoGeral;
   //    do {
   //       System.out.println("\nSISTEMA DE GESTÃO DE CONSULTAS");
   //       System.out.println("------------------------------------------");
   //       System.out.println("1 - Paciente ");
   //       System.out.println("2 - Medico ");
   //       System.out.println("3 - Consulta ");
   //       System.out.println("0 - Sair ");
   //       System.out.print("Opção: ");
   //       opcaoGeral = entrada.nextInt();

   //       switch(validationOption(opcaoGeral)) {
   //          case OPERACAO_PACIENTE -> System.out.println("Operação paciente");
   //          case OPERACAO_MEDICO-> System.out.println("Operação medico");
   //          case OPERACAO_CONSULTA-> System.out.println("Operação consulta");
   //          default -> {
   //             if (opcaoGeral != 0) System.out.println("Opção inválida!");
   //          }
   //       }
   //  } while(opcaoGeral != 0);
   //  entrada.close();
   }
}
