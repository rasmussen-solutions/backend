package dk.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import dk.backend.repository.entity.Companies;
import org.springframework.stereotype.Service;

@Service
public class CompaniesService {

    private ObjectReader objectReader;

    public CompaniesService(ObjectMapper objectMapper) {
        this.objectReader = objectMapper.readerFor(Companies.class);
    }

    private Companies createCompany(String payload) throws JsonProcessingException {
        return objectReader.readValue(payload);
    }

    public Companies createAndSaveCompany(String payload) throws JsonProcessingException {
        return createCompany(payload);
    }
}
