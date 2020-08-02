package dk.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dk.backend.model.CompaniesResponseBody;
import dk.backend.repository.entity.Companies;
import java.util.List;

public interface CompaniesOperations {

    /**
     * Creates a new Company resource from the provided payload
     *
     * @param payload for now may contain anything, but ideally should be JSON
     * @return a ResponseEntity containing a JSON representation of a CompaniesResponseBody
     * containing the created Company, a HTTP CREATED status, and a Location header
     * containing the URI to the newly created resource.
     */
    @PostMapping
    ResponseEntity<CompaniesResponseBody> save(@RequestBody String payload);

    /**
     * @return a list of all companies resources
     */
    @GetMapping
    ResponseEntity<List<Companies>> index();

    /**
     * Retrieve the company with the provided id
     *
     * @param id the ID for the company
     * @return a JSON representation of the resource or HTTP NOT_FOUND
     */
    @GetMapping("/id")
    ResponseEntity<Companies> get(@PathVariable Long id);
}
