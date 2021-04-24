package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class,
					() -> service.calcularBonus(new Funcionario("Teste 1", LocalDate.now(), new BigDecimal("25000"))));

	/*	try {
			service.calcularBonus(new Funcionario("Teste 1", LocalDate.now(), new BigDecimal("25000")));
			fail("Não deu a exception!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			assertEquals("Funcionário com salário maior do que o previsto.", e.getMessage());
		}*/
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Teste 2", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeDezMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Teste 3", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
