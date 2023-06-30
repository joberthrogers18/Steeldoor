package com.steelDoor.controller;

import com.steelDoor.model.Company;
import com.steelDoor.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/company", method= RequestMethod.POST)
    public ResponseEntity<Object> createCompany(@RequestBody Company company) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Company companySaved = companyService.createCompany(company);
            map.put("message", "Company create successfully");
            map.put("data", companySaved);
            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/companies", method= RequestMethod.GET)
    public ResponseEntity<Object> getAllCompanies() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Company> companies = companyService.getAllCompanies();
            map.put("data", companies);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value ="/company/{idCompany}", method= RequestMethod.GET)
    public ResponseEntity<Object> getCompanyById(@PathVariable(value = "idCompany") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Optional<Company> company = companyService.getCompanyById(id);

            if (company.isEmpty()) {
                map.put("message", "Company not found.");
                return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
            }

            map.put("data", company);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/company/{idCompany}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCompany(@PathVariable(value = "idCompany") Long id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            companyService.deleteCompany(id);
            map.put("message", "Company deleted successfully");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/company/{idCompany}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCompany(@PathVariable(value = "idCompany") Long id, @RequestBody Company company) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Company companyUpdated = companyService.updateCompany(id, company);
            map.put("data", companyUpdated);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e);
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
