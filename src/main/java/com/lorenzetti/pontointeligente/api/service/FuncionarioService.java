package com.lorenzetti.pontointeligente.api.service;

import java.util.Optional;

import com.lorenzetti.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {

	Funcionario persistir(Funcionario funcionario);
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	Optional<Funcionario> buscarPorId(Long id);
	
}
