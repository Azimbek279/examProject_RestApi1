package com.example.examproject_restapi1.converter.company;

import com.example.examproject_restapi1.DTO.company.CompanyRequest;
import com.example.examproject_restapi1.entities.Company;
import org.springframework.stereotype.Component;


@Component
public class CompanyRequestConverter {
    public Company createCompany(CompanyRequest companyRequest){
        if (companyRequest == null){
            return null;
        }

        Company company = new Company();

        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

//        List<Course> courses = companyRequest.getCourses();
//        List<Group> groups = companyRequest.getGroups();
//
//        courses.forEach(x -> x.setCompany(company));
//        groups.forEach(x -> x.setCompany(company));
//
//        company.setCourses(courses);
//        company.setGroups(groups);

        return company;
    }


    public void updateCompany(Company company, CompanyRequest companyRequest){

        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }

}
