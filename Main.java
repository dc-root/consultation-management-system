import java.util.ArrayList;

import main.models.Consulta;
import main.models.Medico;
import main.models.Paciente;
import main.repositorys.FicharioConsulta;
import main.repositorys.FicharioMedico;
import main.repositorys.FicharioPaciente;

import java.util.Scanner;

public class Main {
    public enum OpGeral { SAIR, OPERACAO_PACIENTE, OPERACAO_MEDICO, OPERACAO_CONSULTA }
    public enum OpFicharios { SAIR, CADASTRAR, ALTERAR, REMOVER, CONSULTAR, RELATORIO }

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
            System.out.println("\nSISTEMA DE GESTÃO DE CONSULTAS");
            System.out.println("------------------------------------------");
            System.out.println("1 - Paciente ");
            System.out.println("2 - Medico ");
            System.out.println("3 - Consulta ");
            System.out.println("0 - Sair ");
            System.out.print("Opção: ");
            opcaoGeral = entrada.nextInt();

            OpGeral opcaoG = OpGeral.values()[opcaoGeral];
            switch(opcaoG) {
                case OPERACAO_PACIENTE -> {
                    do {
                        System.out.println("\nPACIENTE");
                        System.out.println("------------------------------------------");
                        System.out.print("1. cadastrar um paciente \n"+
                        "2. alterar dados de um paciente \n"+
                        "3. remover um paciente \n"+
                        "4. mostrar dados de um paciente \n"+
                        "5. listar todos os pacientes \n"+
                        "0. sair \n"+
                        "opção: ");
                        opcaoPaciente = entrada.nextInt();

                        OpFicharios opcaoF = OpFicharios.values()[opcaoPaciente];
                        switch(opcaoF) {
                            case CADASTRAR -> ficharioPaciente.cadastrar();
                            case ALTERAR -> ficharioPaciente.alterar();
                            case REMOVER -> ficharioPaciente.remover();
                            case CONSULTAR -> ficharioPaciente.consultar();
                            case RELATORIO -> ficharioPaciente.relatorio();
                            case SAIR -> { break; }
                            default -> {
                                if(opcaoPaciente != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoPaciente != 0);
                }

                case OPERACAO_MEDICO -> {
                    do {
                        System.out.println("\nMEDICO");
                        System.out.println("------------------------------------------");
                        System.out.print("1. cadastrar um medico \n"+
                        "2. alterar dados de um medico \n"+
                        "3. remover um medico \n"+
                        "4. mostrar dados de um medico \n"+
                        "5. listar todos os medicos \n"+
                        "0. sair \n"+
                        "opção: ");
                        opcaoMedico = entrada.nextInt();

                        OpFicharios opcaoF = OpFicharios.values()[opcaoMedico];
                        switch(opcaoF) {
                            case CADASTRAR -> ficharioMedico.cadastrar();
                            case ALTERAR -> ficharioMedico.alterar();
                            case REMOVER -> ficharioMedico.remover();
                            case CONSULTAR -> ficharioMedico.consultar();
                            case RELATORIO -> ficharioMedico.relatorio();
                            case SAIR -> { break; }
                            default -> {
                                if(opcaoMedico != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoMedico != 0);
                }
                case OPERACAO_CONSULTA -> {
                    do {
                        System.out.println("\nCONSULTA");
                        System.out.println("------------------------------------------");
                        System.out.print("1. cadastrar consulta \n"+
                        "2. alterar dados de consulta \n"+
                        "3. remover consulta \n"+
                        "4. mostrar dados de consulta \n"+
                        "5. listar todas as consultas \n"+
                        "0. sair \n"+
                        "opção: ");
                        opcaoConsulta = entrada.nextInt();

                        OpFicharios opcaoF = OpFicharios.values()[opcaoConsulta];
                        switch(opcaoF) {
                            case CADASTRAR -> ficharioConsulta.cadastrar();
                            case ALTERAR -> ficharioConsulta.alterar();
                            case REMOVER -> ficharioConsulta.remover();
                            case CONSULTAR -> ficharioConsulta.consultar();
                            case RELATORIO -> ficharioConsulta.relatorio();
                            case SAIR -> { break; }
                            default -> {
                                if(opcaoConsulta != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoConsulta != 0);
                }
                default -> {
                    if (opcaoGeral != 0) System.out.println("Opção inválida!");
                }
            }
        } while (opcaoGeral != 0);
        entrada.close();
    }
}