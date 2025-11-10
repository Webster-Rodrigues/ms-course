package io.github.websterrodrigues.msavaliadorcredito.model;

public class EvaluationData {

    private String cpf;
    private Long income;

    public EvaluationData() {
    }

    public EvaluationData(String cpf, Long income) {
        this.cpf = cpf;
        this.income = income;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }
}
