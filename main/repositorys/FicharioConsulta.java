package main.repositorys;

import java.util.ArrayList;

import main.models.Consulta;
import main.models.Medico;
import main.models.Paciente;

public class FicharioConsulta extends FicharioGenerico<Consulta> {
    ArrayList<Medico> medicos = new ArrayList<>();
    ArrayList<Paciente> pacientes = new ArrayList<>();

    public FicharioConsulta(
        ArrayList<Consulta> consultas,
        ArrayList<Medico> medicos,
        ArrayList<Paciente> pacientes
    ) {
        super(consultas);
        this.medicos = medicos;
        this.pacientes = pacientes;
    }

    public void gerarConsulta() { // CADASTRAR
        System.out.println("------------------------------------------");
        System.out.print("Número do crm do medico a prestar serviço: ");
        String crm = entrada.nextLine();

        Medico medicoaSerConsultado = medicos.stream()
            .filter(medico -> medico.getCrm()
                .equals(crm)
            ).findAny().orElse(null);

        System.out.println("------------------------------------------");
        System.out.print("Número do cpf do paciente a ser consultado: ");
        String cpf = entrada.nextLine();

        Paciente pacienteaConsultar = pacientes.stream()
        .filter(medico -> medico.getCpf()
            .equals(cpf)
        ).findAny().orElse(null);

        if(pacienteaConsultar != null && medicoaSerConsultado != null) {
            Consulta novaConsulta = new Consulta(medicoaSerConsultado, pacienteaConsultar);
            cadastrar(novaConsulta);
        } else {
            System.out.println("\n> Error: Numero de cpf do pacinte e/ou crm do medico não encontrado!");
        }
    }

    public void excluirConsulta() { // REMOVER
        System.out.print("Numero do codigo da consulta a ser excluida: ");
        String codigo = entrada.nextLine();

        Consulta consulta = buscarConsulta(codigo);

        if(consulta != null) {
            remover(consulta);
        } else {
            System.out.println("\nNúmero de codigo de consulta não encontrado!");
        }
    }

    public void dadosDaConsulta() { // CONSULTAR
        System.out.print("Numero do codigo da consulta a ser excluida: ");
        String codigo = entrada.nextLine();

        Consulta consulta = buscarConsulta(codigo);

        if(consulta != null) {
            System.out.println(codigo);
        } else {
            System.out.println("\nNúmero de codigo de consulta não encontrado!");
        }
    }

    public void relatorioDeConsultas() { // RELATORIO
        listar();
    }

    private Consulta buscarConsulta(String codigo) {
        Consulta consultaEncontrado = entitys.stream()
        .filter(consulta -> consulta.getCodigo()
                .equals(codigo)
        ).findAny().orElse(null);

        return consultaEncontrado; 
    }
}
