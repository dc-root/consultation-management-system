import java.util.ArrayList;

import main.ficharios.FicharioMedico;
import main.ficharios.FicharioPaciente;
import main.ficharios.FicharioConsulta;

import main.interfaces.Consulta;
import main.interfaces.Medico;
import main.interfaces.Paciente;

import java.util.Scanner;

public class Main {
    public enum OpGeral { OPERACAO_PACIENTE, OPERACAO_MEDICO, OPERACAO_CONSULTA }
    public enum OpFicharios { CADASTRAR, ALTERAR, REMOVER, MOSTRARDADOS, LISTARTODOS }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();

        FicharioMedico ficharioMedico = new FicharioMedico(medicos);
        FicharioPaciente ficharioPaciente = new FicharioPaciente(pacientes);
        FicharioConsulta ficharioConsulta = new FicharioConsulta(consultas);

        int opcaoGeral, opcaoPaciente, opcaoMedico, opcaoConsulta;

        do {
            System.out.println("\n SISTEMA DE GESTÃO DE CONSULTAS\n");
            System.out.println("1 - Paciente ");
            System.out.println("2 - Medico ");
            System.out.println("3 - Consulta ");
            System.out.println("0 - Sair ");
            System.out.print("Opção: ");
            opcaoGeral = entrada.nextInt();

            OpGeral opcaoG = OpGeral.values()[opcaoGeral+(opcaoGeral != 0 ? 1 : 0)];
            switch(opcaoG) {
                case OPERACAO_PACIENTE -> {
                    do {
                        System.out.print("\n1. cadastrar um paciente \n"+
                        "2. alterar dados de um paciente \n"+
                        "3. remover um paciente \n"+
                        "4. mostrar dados de um paciente \n"+
                        "5. listar todos os pacientes \n"+
                        "0. sair \n"+
                        "opao: ");
                        opcaoPaciente = entrada.nextInt();

                        OpFicharios opcaoF = OpFicharios.values()[opcaoPaciente+(opcaoPaciente != 0 ? 1 : 0)];
                        switch(opcaoF) {
                            case CADASTRAR -> ficharioPaciente.cadastrar();
                            case ALTERAR -> ficharioPaciente.alterar();
                            case REMOVER -> ficharioPaciente.remover();
                            case MOSTRARDADOS -> ficharioPaciente.listarTodos();
                            case LISTARTODOS -> ficharioPaciente.listar();
                            default -> {
                                if(opcaoPaciente != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoPaciente != 0);
                }

                case OPERACAO_MEDICO -> {
                    do {
                        System.out.print("\n1. cadastrar um medico \n"+
                        "2. alterar dados de um medico \n"+
                        "3. remover um medico \n"+
                        "4. mostrar dados de um medico \n"+
                        "5. listar todos os medicos \n"+
                        "0. sair \n"+
                        "opao: ");
                        opcaoMedico = entrada.nextInt();

                        OpFicharios opcaoF = OpFicharios.values()[opcaoMedico+(opcaoMedico != 0 ? 1 : 0)];
                        switch(opcaoF) {
                            case CADASTRAR -> ficharioMedico.cadastrar();
                            case ALTERAR -> ficharioMedico.alterar();
                            case REMOVER -> ficharioMedico.remover();
                            case MOSTRARDADOS -> ficharioMedico.listarTodos();
                            case LISTARTODOS -> ficharioMedico.listar();
                            default -> {
                                if(opcaoMedico != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoMedico != 0);
                }
                case OPERACAO_CONSULTA -> {
                    do {
                        System.out.print("\n1. cadastrar consulta \n"+
                        "2. alterar dados de consulta \n"+
                        "3. remover consulta \n"+
                        "4. mostrar dados de consulta \n"+
                        "5. listar todas as consultas \n"+
                        "0. sair \n"+
                        "opao: ");
                        opcaoConsulta = entrada.nextInt();

                        OpFicharios opcaoF = OpFicharios.values()[opcaoConsulta+(opcaoConsulta != 0 ? 1 : 0)];
                        switch(opcaoF) {
                            case CADASTRAR -> ficharioConsulta.cadastrar();
                            case ALTERAR -> ficharioConsulta.alterar();
                            case REMOVER -> ficharioConsulta.remover();
                            case MOSTRARDADOS -> ficharioConsulta.listarTodos();
                            case LISTARTODOS -> ficharioConsulta.listar();
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