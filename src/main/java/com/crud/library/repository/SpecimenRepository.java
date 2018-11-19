package com.crud.library.repository;

import com.crud.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SpecimenRepository extends CrudRepository<Specimen,Long> {
    @Override
    Specimen save (Specimen specimen);

    List<Specimen> findAllByTitleId(Long titleId);

    Specimen findBySpecimenId(Long specimenId);
}
