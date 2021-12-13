package com.shapeshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public CompanyEntity createOrder(CompanyEntity company) {
		companyRepository.save(company);
		return company;
	}

	public void deleteCompany(long id) {
		companyRepository.deleteById(id);
	}

	public void deleteOrder(CompanyEntity company) {
		companyRepository.delete(company);
	}

	public List<CompanyEntity> getAllCompanies() {
		List<CompanyEntity> result = StreamSupport.stream(companyRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return result;
	}

	public CompanyEntity getCompanyById(long id) {
		return companyRepository.findById(id);
	}
}
