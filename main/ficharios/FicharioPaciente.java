package main.ficharios;

import java.util.ArrayList;
import main.interfaces.Paciente;

public class FicharioPaciente extends FicharioGenerico<Paciente> implements Fichario {
    public FicharioPaciente(ArrayList<Paciente> pacientes) {
        super(pacientes);
    }

    @Override
    public void cadastrar(){
        
    }

    @Override
    public void alterar(){
        
    }
    
    @Override
    public void remover(){
        
    }
    
    @Override
    public void listar(){
        
    }

    public void listarTodos() {}
}
