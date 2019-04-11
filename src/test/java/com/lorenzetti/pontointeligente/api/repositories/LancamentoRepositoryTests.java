package com.lorenzetti.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lorenzetti.pontointeligente.api.UtilsTests;
import com.lorenzetti.pontointeligente.api.entities.Lancamento;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTests extends UtilsTests {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository; 
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private Long funcionarioId;
	
	@Before
	public void setUp() throws Exception {
		
		Lancamento lancamento = this.getLancamentoInicioTrabalho();

		lancamento.getFuncionario().getEmpresa().setId(null);;
		this.empresaRepository.save(lancamento.getFuncionario().getEmpresa());

		lancamento.getFuncionario().setId(null);
		this.funcionarioRepository.save(lancamento.getFuncionario());
		this.funcionarioId = lancamento.getFuncionario().getId();
		
		this.lancamentoRepository.save(lancamento);
		
		lancamento = this.getLancamentoTerminoTrabalho();
		lancamento.getFuncionario().setId(this.funcionarioId);
		this.lancamentoRepository.save(lancamento);

	}
	
	@After
	public final void tearDown() {
		this.lancamentoRepository.deleteAll();
		this.funcionarioRepository.deleteAll();
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarLancamentosPorFuncionarioId() {
		List<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId);
		
		assertEquals(2, lancamentos.size());
	}
	
	@Test
	public void testBuscarLancamentosPorFuncionarioIdPaginado() {
		PageRequest page = new PageRequest(0, 10);
		Page<Lancamento> lancamentos = this.lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		
		assertEquals(2, lancamentos.getTotalElements());
	}
	
}
