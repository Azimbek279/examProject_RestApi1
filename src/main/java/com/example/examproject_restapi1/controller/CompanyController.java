package com.example.examproject_restapi1.controller;

import com.example.examproject_restapi1.DTO.company.CompanyRequest;
import com.example.examproject_restapi1.DTO.company.CompanyResponse;
import com.example.examproject_restapi1.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getAll")
    public List<CompanyResponse> getAllCompany(){
        return companyService.getAllCompanies();
    }

    @PostMapping("/save")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) throws IOException {
        return companyService.addCompany(companyRequest);
    }

    @GetMapping("/findById/{id}")
    public CompanyResponse findById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public CompanyResponse deleteById(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }

    @PutMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) throws IOException {
        return companyService.updateCompany(id, companyRequest);
    }


}
