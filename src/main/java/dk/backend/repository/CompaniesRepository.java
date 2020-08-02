package dk.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.backend.repository.entity.Companies;

public interface CompaniesRepository extends JpaRepository<Companies, Long> {
}
