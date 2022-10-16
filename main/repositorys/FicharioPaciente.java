package main.repositorys;

import java.util.ArrayList;
import java.util.Scanner;

import main.models.Endereco;
import main.models.Paciente;

public class FicharioPaciente extends FicharioGenerico<Paciente> implements Fichario {
    public FicharioPaciente(ArrayList<Paciente> pacientes) {
        super(pacientes);
    }

    @Override
    public void cadastrar() {
        String nome, cpf, identidade, telefone, nomeConvenio;
        int numeroConvenio, option=0;
        ArrayList<Endereco> enderecos = new ArrayList<>();

        System.out.println("\nCADASTRO");
        System.out.println("------------------------------------------");
        System.out.print("Nome: ");
        nome = entrada.nextLine();

        System.out.print("CPF: ");
        cpf = entrada.nextLine();
        
        System.out.print("Identidade: ");
        identidade = entrada.nextLine();

        System.out.print("telefone: ");
        telefone = entrada.nextLine();

        System.out.print("Nome do convenio: ");
        nomeConvenio = entrada.nextLine();

        System.out.print("Numero do convenio: ");
        numeroConvenio = entrada.nextInt();
        clearBuffer(entrada);

        System.out.print("Endereços:\n");

        String logradouro, complemento, bairro, municipio, cep;
        int numero, tipo;

        do {
            System.out.print("\tLograduro: ");
            logradouro = entrada.nextLine();
        
            System.out.print("\tNumero: ");
            numero = entrada.nextInt();
            clearBuffer(entrada);

            System.out.print("\tComplemento: ");
            complemento = entrada.nextLine();

            System.out.print("\tBairro: ");
            bairro = entrada.nextLine();

            System.out.print("\tMunicipio: ");
            municipio = entrada.nextLine();

            System.out.print("\tCEP: ");
            cep = entrada.nextLine();

            System.out.print("\tTipo: ");
            tipo = entrada.nextInt();
            clearBuffer(entrada);

            enderecos.add(new Endereco(logradouro, numero, complemento, bairro, municipio, cep, tipo));
            if(enderecos.size() < 2) {
                System.out.print("\n1. mais um endereço(qualquer numero)\n0. sair\nopcão: ");
                option = entrada.nextInt();
                clearBuffer(entrada);
            } else option = 0;
        } while(option != 0);

        Paciente paciente = new Paciente(nome, cpf, identidade, telefone, nomeConvenio, numeroConvenio, enderecos);

        cadastrar(paciente);
    }

    @Override
    public void alterar(){
        System.out.println("\nALTERAÇÃO");
        System.out.println("------------------------------------------");
        System.out.print("Digite o numero do cpf do paciente a ser alterado: ");
        String cpf = entrada.nextLine();

        Paciente paciente = buscarPaciente(cpf);
        
        if(paciente != null) {
            System.out.println("\nEscolha o item a editar!\n\n"+
                "1. Nome\n"+
                "2. Cpf\n"+
                "3. Identidade\n"+
                "4. Telefone\n"+
                "5. Nome do convenio\n"+
                "6. Numero do convenio\n"+
                (paciente.getEnderecos().size() < 2 ?
                "7. endereco\n" : "7. endereço 1\n"+
                "8. endereço 2\n"));

            System.out.print("Opção: ");
            int opcao = entrada.nextInt();
            clearBuffer(entrada);

            switch (opcao) {
                case 1 -> {
                    System.out.print("\nNome: ");
                    paciente.setNome(entrada.nextLine());
                }
                case 2 -> {
                    System.out.print("\nCpf: ");
                    paciente.setCpf(entrada.nextLine());
                }
                case 3 -> {
                    System.out.print("\nIdentidade: ");
                    paciente.setTelefone(entrada.nextLine());
                }
                case 4 -> {
                    System.out.print("\nTelefone: ");
                    paciente.setTelefone(entrada.nextLine());
                }
                case 5 -> {
                    System.out.print("\nNome do convenio: ");
                    paciente.setNomeConvenio(entrada.nextLine());
                }
                case 6 -> {
                    System.out.print("\nNumero do convenio: ");
                    paciente.setNumeroConvenio(entrada.nextInt());
                    clearBuffer(entrada);
                }
                case 7, 8 -> {
                    int indexEndereco = (opcao == 7 ? 0 : 1);

                    System.out.printf("\nENDEREÇO %d: %s\n"+
                        "1. Logradouro\n"+
                        "2. numero\n"+
                        "3. complemento\n"+
                        "4. bairro\n"+
                        "5. municipio\n"+
                        "6. CEP\n"+
                        "7. tipo\n"+
                        "Opcão: ",
                    indexEndereco+1, paciente.getEnderecos().get(indexEndereco));

                    int opcaoItenEndereco = entrada.nextInt();
                    clearBuffer(entrada);

                    switch(opcaoItenEndereco) {
                        case 1 -> {
                            System.out.print("\nLogradouro: ");
                            paciente.getEnderecos().get(indexEndereco).setLogradouro(entrada.nextLine());
                        }
                        case 2 -> {
                            System.out.print("\nNúmero: ");
                            paciente.getEnderecos().get(indexEndereco).setNumero(entrada.nextInt());
                        }
                        case 3 -> {
                            System.out.print("\nComplemento: ");
                            paciente.getEnderecos().get(indexEndereco).setComplemento(entrada.nextLine());
                        }
                        case 4 -> {
                            System.out.print("\nBairro: ");
                            paciente.getEnderecos().get(indexEndereco).setBairro(entrada.nextLine());
                        }
                        case 5 -> {
                            System.out.print("\nMunicipio: ");
                            paciente.getEnderecos().get(indexEndereco).setMunicipio(entrada.nextLine());
                        }
                        case 6 -> {
                            System.out.print("\nCEP: ");
                            paciente.getEnderecos().get(indexEndereco).setCep(entrada.nextLine());
                        }
                        case 7 -> {
                            System.out.print("\nTipo: ");
                            paciente.getEnderecos().get(indexEndereco).setTipo(entrada.nextInt());
                        }
                    }
                }
            }

            int index = entitys.indexOf(paciente);
            alterar(index, paciente);
        } else {
            System.out.println("\nnúmero de cpf não encontrado!");
        }
    }
    
    @Override
    public void remover(){
        System.out.print("Numero do cpf do paciente a ser removido: ");
        String cpf = entrada.nextLine();

        Paciente paciente = buscarPaciente(cpf);

        if(paciente != null) {
            if(entitys.contains(paciente)) {
                remover(paciente);
            } else {
                System.out.println("\nesse paciente já  não consta na lista!");
            }
        } else {
            System.out.println("\nnúmero de matricula não encontrado!");
        }
    }
    
    @Override
    public void consultar() {
        System.out.print("Numero do cpf do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = buscarPaciente(cpf);

        if(paciente != null) {
            System.out.printf("\n[DADOS DO PACIENTE %s]\n", paciente.getNome().toUpperCase());
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(paciente);
        } else {
            System.out.println("\nNúmero de cpf não encontrado!");
        }
    }

    private Paciente buscarPaciente(String cpf) {
        Paciente pacienteEncontrado = entitys.stream()
        .filter(paciente -> paciente.getCpf()   
                .equals(cpf)
        ).findAny().orElse(null);

        return pacienteEncontrado; 
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}