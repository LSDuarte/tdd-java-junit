package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteSerive {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal perc = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(perc);
		funcionario.reajustarSalario(reajuste);
	}

}
