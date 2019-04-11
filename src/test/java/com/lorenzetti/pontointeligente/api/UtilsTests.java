package com.lorenzetti.pontointeligente.api;

import java.util.Calendar;
import java.util.Random;

import com.lorenzetti.pontointeligente.api.entities.Empresa;
import com.lorenzetti.pontointeligente.api.entities.Funcionario;
import com.lorenzetti.pontointeligente.api.entities.Lancamento;
import com.lorenzetti.pontointeligente.api.enums.PerfilEnum;
import com.lorenzetti.pontointeligente.api.enums.TipoEnum;
import com.lorenzetti.pontointeligente.api.utils.PasswordUtils;

public class UtilsTests {

	protected Funcionario getFuncionarioRoleAdmin() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("69768915013");
		funcionario.setEmail("teste@gmail.com");
		funcionario.setEmpresa(this.getEmpresa());
		funcionario.setId(new Random().nextLong());
		funcionario.setNome("NOME DO FUNCIONARIO");
		funcionario.setPerfil(PerfilEnum.ROLE_ADMIN);
		funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
		
		return funcionario;
	}
	
	protected Empresa getEmpresa() {
		
		Empresa empresa = new Empresa();
		empresa.setCnpj("62113660000136");
		empresa.setDataAtualizacao(Calendar.getInstance().getTime());
		empresa.setDataCriacao(empresa.getDataAtualizacao());
		empresa.setId(this.getId());
		empresa.setRazaoSocial("RAZAO SOCIAL");
		
		return empresa;
		
	}

	protected Lancamento getLancamentoInicioTrabalho() {
		
		Lancamento lancamento = new Lancamento();
		lancamento.setData(Calendar.getInstance().getTime());
		lancamento.setDataAtualizacao(lancamento.getData());
		lancamento.setDataCriacao(lancamento.getData());
		lancamento.setDescricao("HORA DE ENTRADA");
		lancamento.setFuncionario(this.getFuncionarioRoleAdmin());
		lancamento.setId(this.getId());
		lancamento.setLocalizacao("123.221.232.99");
		lancamento.setTipo(TipoEnum.INICIO_TRABALHO);
		
		return lancamento;
		
	}
	
	protected Lancamento getLancamentoTerminoTrabalho() {
		
		Lancamento lancamento = new Lancamento();
		lancamento.setData(Calendar.getInstance().getTime());
		lancamento.setDataAtualizacao(lancamento.getData());
		lancamento.setDataCriacao(lancamento.getData());
		lancamento.setDescricao("HORA DE SAIDA");
		lancamento.setFuncionario(this.getFuncionarioRoleAdmin());
		lancamento.setId(this.getId());
		lancamento.setLocalizacao("123.221.232.99");
		lancamento.setTipo(TipoEnum.TERMINO_TRABALHO);
		
		return lancamento;
		
	}

	private Long getId() {
		return new Random().nextLong();
	}
	
}
