package main.ficharios;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class FicharioGenerico<E> {
    protected ArrayList<E> entity;
    private Scanner entrada;

    protected FicharioGenerico(ArrayList<E> entity) {
        this.entity = entity;
        this.entrada = new Scanner(System.in);
    }

    protected void cadastrar(E unknown) {
        try {
            if(entity.contains(unknown)) {
                System.out.println("\nJá existe esse cpf cadastrado no sistem!");
                return;
            }

            entity.add(unknown);
            System.out.println("\nCadastrado realizado com sucesso!");
        } catch (Exception e) {
            System.out.println("\nNão foi possivel execultar: 'cadastrar()'");
        }
    }

    protected void alterar(int index, E unknown) {
        try {
            entity.set(index, unknown);
            System.out.println("\nAlteração realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("\nNão foi possivel execultar: 'alterar()' ");
        }
    }

    protected void remover(E unknown) {
        try {
            System.out.print("Você realmente deseja excluir? (yes/no): ");
            String option = entrada.nextLine();

            switch(option) {
                case "y", "Y", "YES", "yes" -> {
                    if(entity.remove(unknown)) {
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
}