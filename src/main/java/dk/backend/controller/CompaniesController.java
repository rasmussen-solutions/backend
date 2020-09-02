package dk.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.backend.model.CompaniesResponseBody;
import dk.backend.repository.CompaniesRepository;
import dk.backend.repository.entity.Companies;
import dk.backend.service.CompaniesService;

import java.net.URI;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(CompaniesController.CONTEXT_PATH)
public class CompaniesController implements CompaniesOperations {
    static final String CONTEXT_PATH = "/companies";

    private CompaniesService companiesService;
    private CompaniesRepository companiesRepository;

    public CompaniesController(CompaniesService companiesService, CompaniesRepository companiesRepository) {
        this.companiesService = companiesService;
        this.companiesRepository = companiesRepository;
    }

    @Override
    public ResponseEntity<CompaniesResponseBody> save(String payload) {
        Companies companies = null;

        try {
            companies = companiesService.createAndSaveCompany(payload);
            companiesRepository.save(companies);
        } catch (JsonProcessingException e) {
            log.info("Exception occured:", e);
        }

        CompaniesResponseBody companiesResponseBody = new CompaniesResponseBody(companies);
        return ResponseEntity.created(locationUriFor(companies.getId())).body(companiesResponseBody);
    }

    @Override
    public ResponseEntity<List<Companies>> index() {
        List<Companies> companies = companiesRepository.findAll();
        return ResponseEntity.ok().body(companies);
    }

    @Override
    public ResponseEntity<Companies> get(Long id) {
        return null;
    }

    private URI locationUriFor(Long id) {
        return URI.create(String.format("%s/%d", CONTEXT_PATH, id));
    }
}
