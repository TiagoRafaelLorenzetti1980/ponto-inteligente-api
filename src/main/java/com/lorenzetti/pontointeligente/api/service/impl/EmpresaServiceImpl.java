package com.lorenzetti.pontointeligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzetti.pontointeligente.api.entities.Empresa;
import com.lorenzetti.pontointeligente.api.repositories.EmpresaRepository;
import com.lorenzetti.pontointeligente.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		this.log.info("EmpresaServiceImpl.buscarPorCnpj{}", cnpj);
		return Optional.ofNullable(this.empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		this.log.info("EmpresaServiceImpl.persistir{}", empresa.toString());
		return this.empresaRepository.save(empresa);
	}

}
