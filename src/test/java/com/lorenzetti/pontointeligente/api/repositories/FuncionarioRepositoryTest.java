package com.lorenzetti.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lorenzetti.pontointeligente.api.UtilsTests;
import com.lorenzetti.pontointeligente.api.entities.Funcionario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest extends UtilsTests {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CPF = "05352885062";
	private static final String EMAIL = "teste@gmail.com";
	
	@Before
	public void setUp() throws Exception {
		
		Funcionario funcionario = this.getFuncionarioRoleAdmin();
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		
		// gera o codigo automaticamente
		funcionario.getEmpresa().setId(null);
		
		this.empresaRepository.save(funcionario.getEmpresa());
		this.funcionarioRepository.save(funcionario);
		
	}
	
	@After
	public final void tearDown() {
		this.funcionarioRepository.deleteAll();
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testFindByCpf() {
		
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
		
		assertEquals(CPF, funcionario.getCpf());
		
	}
	
	@Test
	public void testFindByEmail() {
		
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		
		assertEquals(EMAIL, funcionario.getEmail());
		
	}

	@Test
	public void testFindByCpfOrEmail() {
		
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, null);
		
		assertEquals(CPF, funcionario.getCpf());
		
		funcionario = this.funcionarioRepository.findByCpfOrEmail(null, EMAIL);
		
		assertEquals(EMAIL, funcionario.getEmail());

	}

}
