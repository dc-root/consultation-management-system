package main.repositorys;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class FicharioGenerico<E> {
    protected ArrayList<E> entitys;
    protected Scanner entrada;

    protected FicharioGenerico(ArrayList<E> entitys) {
        this.entitys = entitys;
        this.entrada = new Scanner(System.in);
    }

    protected void cadastrar(E entity) {
        try {
            if(entitys.contains(entity)) {
                System.out.println("\nJá existe esse cpf cadastrado no sistem!");
                return;
            }

            entitys.add(entity);
            System.out.println("\nCadastrado realizado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nNão foi possivel execultar: 'cadastrar()'");
        }
    }

    protected void alterar(int index, E entity) {
        try {
            entitys.set(index, entity);
            System.out.println("\nAlteração realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("\nNão foi possivel execultar: 'alterar()' ");
        }
    }

    protected void remover(E entity) {
        try {
            System.out.println(entity);

            System.out.print("Você realmente deseja excluir? (yes/no): ");
            String option = entrada.nextLine();

            switch(option) {
                case "y", "Y", "YES", "yes" -> {
                    if(entitys.remove(entity)) {
                        System.out.println("\nremovido com sucesso!");
                    } else {
                        System.out.println("\nErro ao realizar remoção!");
                        return;
                    }
                }
                case "n", "N", "NO", "no" -> { return; }
                default -> {
                    System.out.println("\nOpção invalida!");
                }
            }
        } catch (Exception e) {
            System.out.println("\nNão foi possivel execultar: 'remover()'");
        }
    }

    public void relatorio() {
        System.out.println("\nRELATÓRIO");
        System.out.println("------------------------------------------------------------------------------------");
        if(entitys.size() == 0)
            System.out.println("[ Lista vazia ]");
        else
            entitys.stream()
                .forEach(entity -> {
                    System.out.println(entity);
                    System.out.println("------------------------------------------------------------------------------------");
            });
    }
}