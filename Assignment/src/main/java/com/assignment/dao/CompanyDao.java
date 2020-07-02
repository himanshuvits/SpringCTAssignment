package com.assignment.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.dto.Company;

public interface CompanyDao extends JpaRepository<Company, Integer>{
	List<Company> findAll();
	Company findByCompanyId(Integer companyId);
}
