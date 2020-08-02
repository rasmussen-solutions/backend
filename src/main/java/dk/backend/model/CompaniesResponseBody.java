package dk.backend.model;

import dk.backend.repository.entity.Companies;

public class CompaniesResponseBody {
    private Companies companies;

    public CompaniesResponseBody(Companies companies) {
        this.companies = companies;
    }

    public Companies getCompanies() {
        return companies;
    }
}
