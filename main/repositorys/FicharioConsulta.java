package main.repositorys;

import java.util.ArrayList;

import main.models.Consulta;
import main.models.Medico;
import main.models.Paciente;

public class FicharioConsulta extends FicharioGenerico<Consulta> implements Fichario {
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

    @Override
    public void cadastrar(){
        Medico medico;
        Paciente paciente; 
    }

    @Override
    public void alterar(){
        
    }
    
    @Override
    public void remover(){
        
    }
    
    @Override
    public void consultar(){
        
    }

    public void relatorio() {}
}
