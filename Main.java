import java.util.ArrayList;

import main.models.Consulta;
import main.models.Medico;
import main.models.Paciente;
import main.repositorys.FicharioConsulta;
import main.repositorys.FicharioMedico;
import main.repositorys.FicharioPaciente;

import java.util.Scanner;

public class Main {
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
            
            switch(opcaoGeral) {
                case 1 -> {
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

                        switch(opcaoPaciente) {
                            case 1 -> ficharioPaciente.cadastrar();
                            case 2 -> ficharioPaciente.alterar();
                            case 3 -> ficharioPaciente.remover();
                            case 4 -> ficharioPaciente.consultar();
                            case 5 -> ficharioPaciente.relatorio();
                            default -> {
                                if(opcaoPaciente != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoPaciente != 0);
                }

                case 2 -> {
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

                        switch(opcaoMedico) {
                            case 1 -> ficharioMedico.cadastrar();
                            case 2 -> ficharioMedico.alterar();
                            case 3 -> ficharioMedico.remover();
                            case 4 -> ficharioMedico.consultar();
                            case 5 -> ficharioMedico.relatorio();
                            default -> {
                                if(opcaoMedico != 0) System.out.println("Opção inválida");
                            }
                        }
                    } while(opcaoMedico != 0);
                }

                case 3 -> {
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

                        switch(opcaoConsulta) {
                            case 1 -> ficharioConsulta.gerarConsulta();
                            case 2 -> ficharioConsulta.alterarConsulta();
                            case 3 -> ficharioConsulta.excluirConsulta();
                            case 4 -> ficharioConsulta.dadosDaConsulta();
                            case 5 -> ficharioConsulta.relatorioDeConsultas();
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