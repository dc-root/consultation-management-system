import java.util.ArrayList;

import main.models.Consulta;
import main.models.Medico;
import main.models.Paciente;
import main.repositorys.FicharioConsulta;
import main.repositorys.FicharioMedico;
import main.repositorys.FicharioPaciente;

import java.util.Scanner;

public class Main {
    public enum Operacoes {
        SAIR(0), OPERACAO_PACIENTE(1), OPERACAO_MEDICO(2), OPERACAO_CONSULTA(3),
        CADASTRAR(1), ALTERAR(2), REMOVER(3), CONSULTAR(4), RELATORIO(5);

        private final int opcao;

        Operacoes(int vopcao) {
            opcao = vopcao;
        }
        public int getOpcao() {
            return opcao;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();

        FicharioMedico ficharioMedico = new FicharioMedico(medicos);
        FicharioPaciente ficharioPaciente = new FicharioPaciente(pacientes);
        FicharioConsulta ficharioConsulta = new FicharioConsulta(consultas, medicos, pacientes);

        int opcaoGeral, opcaoPaciente, opcaoMedico, opcaoConsulta;
        do {
            System.out.print("\nSISTEMA DE GESTÃO DE CONSULTAS\n"
            +"------------------------------------------\n"
            +"1 - Paciente\n"
            +"2 - Medico\n"
            +"3 - Consulta\n"
            +"0 - Sair\n"
            +"Opção: ");
            opcaoGeral = entrada.nextInt();

            Operacoes opcaoG = Operacoes.values()[opcaoGeral];
            switch(opcaoG) {
                case OPERACAO_PACIENTE -> {
                    do {
                        System.out.println("\nPACIENTE");
                        System.out.println("------------------------------------------");
                        System.out.print(
                        "1. cadastrar um paciente \n"+
                        "2. alterar dados de um paciente \n"+
                        "3. remover um paciente \n"+
                        "4. mostrar dados de um paciente \n"+
                        "5. listar todos os pacientes \n"+
                        "0. sair \n"+
                        "opção: ");
                        opcaoPaciente = entrada.nextInt();

                        Operacoes opcaoP = Operacoes.values()[opcaoPaciente];
                        switch(opcaoP) {
                            case CADASTRAR -> ficharioPaciente.cadastrar();
                            case ALTERAR -> ficharioPaciente.alterar();
                            case REMOVER -> ficharioPaciente.remover();
                            case CONSULTAR -> ficharioPaciente.consultar();
                            case RELATORIO -> ficharioPaciente.relatorio();
                            default -> {
                                if(!opcaoP.equals(Operacoes.SAIR)) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoPaciente != 0);
                }

                case OPERACAO_MEDICO -> {
                    do {
                        System.out.println("\nMEDICO");
                        System.out.println("------------------------------------------");
                        System.out.print(
                        "1. cadastrar um medico \n"+
                        "2. alterar dados de um medico \n"+
                        "3. remover um medico \n"+
                        "4. mostrar dados de um medico \n"+
                        "5. listar todos os medicos \n"+
                        "0. sair \n"+
                        "opção: ");
                        opcaoMedico = entrada.nextInt();

                        Operacoes opcaoM = Operacoes.values()[opcaoMedico];
                        switch(opcaoM) {
                            case CADASTRAR -> ficharioMedico.cadastrar();
                            case ALTERAR -> ficharioMedico.alterar();
                            case REMOVER -> ficharioMedico.remover();
                            case CONSULTAR -> ficharioMedico.consultar();
                            case RELATORIO -> ficharioMedico.relatorio();
                            default -> {
                                if(!opcaoM.equals(Operacoes.SAIR)) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoMedico != 0);
                }

                case OPERACAO_CONSULTA -> {
                    do {
                        System.out.println("\nCONSULTA");
                        System.out.println("------------------------------------------");
                        System.out.print(
                        "1. gerar consulta \n"+
                        "2. alterar dados de consulta \n"+
                        "3. remover consulta \n"+
                        "4. mostrar dados de consulta \n"+
                        "5. listar todas as consultas \n"+
                        "0. sair \n"+
                        "opção: ");
                        opcaoConsulta = entrada.nextInt();

                        Operacoes opcaoC = Operacoes.values()[opcaoConsulta];
                        switch(opcaoC) {
                            case CADASTRAR -> ficharioConsulta.gerarConsulta();
                            case REMOVER -> ficharioConsulta.excluirConsulta();
                            case CONSULTAR -> ficharioConsulta.dadosDaConsulta();
                            case RELATORIO -> ficharioConsulta.relatorioDeConsultas();
                            default -> {
                                if(!opcaoC.equals(Operacoes.SAIR)) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoConsulta != 0);
                }
                default -> {
                    if(!opcaoG.equals(Operacoes.SAIR)) System.out.println("Opção inválida!");
                }
            }
        } while (opcaoGeral != 0);
        entrada.close();
    }
}