package com.example.examproject_restapi1.service;


import com.example.examproject_restapi1.DTO.company.CompanyRequest;
import com.example.examproject_restapi1.DTO.company.CompanyResponse;

import java.io.IOException;
import java.util.List;


public interface CompanyService {
    List<CompanyResponse> getAllCompanies();

    CompanyResponse addCompany(CompanyRequest companyRequest) throws IOException;

    CompanyResponse getCompanyById(Long id);

    CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) throws IOException;

    CompanyResponse deleteCompany(Long companyId);
}
