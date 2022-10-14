package main.ficharios;

import java.util.ArrayList;
import main.interfaces.Medico;

public class FicharioMedico extends FicharioGenerico<Medico> implements Fichario {
    public FicharioMedico(ArrayList<Medico> medicos) {
        super(medicos);
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