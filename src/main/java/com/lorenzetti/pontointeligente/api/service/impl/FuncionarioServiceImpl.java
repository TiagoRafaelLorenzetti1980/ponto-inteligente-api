package com.lorenzetti.pontointeligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzetti.pontointeligente.api.entities.Funcionario;
import com.lorenzetti.pontointeligente.api.repositories.FuncionarioRepository;
import com.lorenzetti.pontointeligente.api.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario persistir(Funcionario funcionario) {
		this.log.info("FuncionarioServiceImpl.persistir{}", funcionario.toString());
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		this.log.info("EmpresaServiceImpl.buscarPorCpf{}", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		this.log.info("EmpresaServiceImpl.buscarPorEmail{}", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		this.log.info("EmpresaServiceImpl.buscarPorId{}", id);
		return this.funcionarioRepository.findById(id);
	}
	
}
