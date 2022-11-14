package main.repositorys;

import java.util.ArrayList;
import java.util.Scanner;

import main.models.Medico;

public class FicharioMedico extends FicharioGenerico<Medico> implements Fichario {
    public FicharioMedico(ArrayList<Medico> medicos) {
        super(medicos);
    }

    @Override
    public void cadastrar(){
        String nome, especialidade, crm;
        int ctps;

        System.out.println("\nCADASTRO");
        System.out.println("------------------------------------------");
        System.out.print("Nome: ");
        nome = entrada.nextLine();

        System.out.print("Especialidade: ");
        especialidade = entrada.nextLine();
        
        System.out.print("CRM: ");
        crm = entrada.nextLine();

        System.out.print("CTPS: ");
        ctps = entrada.nextInt();

        Medico medico = new Medico(nome, especialidade, crm, ctps);
        cadastrar(medico);
    }

    @Override
    public void alterar(){
        System.out.println("\nALTERAÇÃO");
        System.out.println("------------------------------------------");
        System.out.print("Digite o numero do crm do medico a ser alterado: ");
        String crm = entrada.nextLine();

        Medico medico = buscarMedico(crm);
        if(medico != null) {
            System.out.println("\nEscolha o item a ser alterado!\n\n"+
                "1. Nome\n"+
                "2. Especialidade\n"+
                "3. CRM\n"+
                "4. CTPS\n"+
                "Opcão: ");

            int opcao = entrada.nextInt();
            clearBuffer(entrada);
            switch (opcao) {
                case 1 -> {
                    System.out.print("\nNome: ");
                    medico.setNome(entrada.nextLine());
                }
                case 2 -> {
                    System.out.print("\nEspecialidade: ");
                    medico.setEspecialidade(entrada.nextLine());
                }
                case 3 -> {
                    System.out.print("\nCRM: ");
                    medico.setCrm(entrada.nextLine());
                }
                case 4 -> {
                    System.out.print("\nCTPS: ");
                    medico.setCtps(entrada.nextInt());
                }
            }
            int index = entitys.indexOf(medico);
            alterar(index, medico);
        } else {
            System.out.println("\nnúmero de crm não encontrado!");
        }
    }
    
    @Override
    public void remover(){
        System.out.print("Numero do crm do medico a ser removido: ");
        String crm = entrada.nextLine();

        Medico medico = buscarMedico(crm);

        if(medico != null) {
            if(entitys.contains(medico)) {
                remover(medico);
            } else {
                System.out.println("\nesse medico já  não consta na lista!");
            }
        } else {
            System.out.println("\nnúmero de crm não encontrado!");
        }
    }
    
    @Override
    public void consultar(){
        System.out.print("Numero do crm do medico: ");
        String crm = entrada.nextLine();

        Medico medico = buscarMedico(crm);

        if(medico != null) {
            System.out.println("[DADOS MEDICO]");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(medico);
        } else {
            System.out.println("\nNúmero de crm não encontrado!");
        }
    }

    @Override
    public void relatorio() {
        listar();
    }

    private Medico buscarMedico(String crm) {
        Medico medicoEncontrado = entitys.stream()
        .filter(medico -> medico.getCrm()
                .equals(crm)
        ).findAny().orElse(null);

        return medicoEncontrado; 
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}