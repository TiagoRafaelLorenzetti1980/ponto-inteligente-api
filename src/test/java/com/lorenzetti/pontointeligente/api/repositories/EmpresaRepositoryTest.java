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
import com.lorenzetti.pontointeligente.api.entities.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoryTest extends UtilsTests {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "62819505000130";
	
	@Before
	public void setUp() throws Exception {
		
		Empresa empresa = this.getEmpresa();
		empresa.setCnpj(CNPJ);
		
		this.empresaRepository.save(empresa);
		
	}
	
	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
		
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		
		assertEquals(CNPJ, empresa.getCnpj());
		
	}
	
}
