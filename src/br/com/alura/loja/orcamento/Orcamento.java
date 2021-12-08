package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.Aprovado;
import br.com.alura.loja.orcamento.situacao.EmAnalise;

import java.math.BigDecimal;

public class Orcamento {

    private BigDecimal valor;
    private int quantidadeItens;
    private SituacaoOrcamento situacaoOrcamento;

    public Orcamento(BigDecimal valor, int quantidadeItens) {
        this.valor = valor;
        this.quantidadeItens = quantidadeItens;
        this.situacaoOrcamento = new EmAnalise();
    }

    public void aplicarDescontoExtra(){
        BigDecimal valorDoDescontoExtra = this.situacaoOrcamento.calcularValorDescontoExtra(this);
        this.valor = this.valor.subtract(valorDoDescontoExtra);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void aprovar(){
        this.situacaoOrcamento.aprovar(this);
    }

    public void reprovar(){
        this.situacaoOrcamento.reprovar(this);
    }

    public void finalizar(){
        this.situacaoOrcamento.finalizar(this);
    }

    public void setSituacaoOrcamento(SituacaoOrcamento situacaoOrcamento) {
        this.situacaoOrcamento = situacaoOrcamento;
    }

    public SituacaoOrcamento getSituacaoOrcamento() {
        return this.situacaoOrcamento;
    }
}
