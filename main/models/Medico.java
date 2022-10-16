package main.models;

import java.util.Objects;

public class Medico extends Pessoa {
    private String especialidade;
    private String crm;
    private int ctps;

    public Medico(
        String nome,
        String especialidade,
        String crm,
        int ctps
    ) {
        this.especialidade = especialidade;
        this.crm = crm;
        this.ctps = ctps;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

    @Override
    public String toString() {
        return "["+nome+", "+especialidade+", "+crm+", "+ctps+"]";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Medico medico = (Medico) obj;
        return Objects.equals(crm, medico.crm) && Objects.equals(ctps, medico.ctps) && Objects.equals(cpf, medico.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm, ctps, cpf);
    }
}
