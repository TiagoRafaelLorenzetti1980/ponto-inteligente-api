package com.lorenzetti.pontointeligente.api.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.lorenzetti.pontointeligente.api.UtilsTests;
import com.lorenzetti.pontointeligente.api.entities.Funcionario;
import com.lorenzetti.pontointeligente.api.repositories.FuncionarioRepository;
import com.lorenzetti.pontointeligente.api.service.FuncionarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceImplTest extends UtilsTests {

	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private static final String CPF = "75565079047";
	private static final String EMAIL = "teste@gmail.com";

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(this.getFuncionarioRoleAdmin());
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(this.getFuncionarioRoleAdmin());
		BDDMockito.given(this.funcionarioRepository.findById(Mockito.anyLong())).willReturn(this.getFuncionarioRoleAdmin(Boolean.TRUE));
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(this.getFuncionarioRoleAdmin());
	}
	
	@Test
	public void testPersistir() {
		Funcionario funcionario = this.funcionarioService.persistir(this.getFuncionarioRoleAdmin());
		assertNotNull(funcionario);
	}

	@Test
	public void testBuscarPorCpf() {
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf(this.CPF);
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarPorEmail() {
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail(this.EMAIL);
		assertTrue(funcionario.isPresent());
	}

	@Test
	public void testBuscarPorId() {
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorId(1l);
		assertTrue(funcionario.isPresent());
	}

}
