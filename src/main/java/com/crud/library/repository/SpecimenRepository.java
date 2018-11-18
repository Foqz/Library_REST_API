package com.crud.library.repository;

import com.crud.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecimenRepository extends CrudRepository<Specimen,Long> {
    @Override
    Specimen save (Specimen specimen);

    List<Specimen> findAllById(Long titleId);
}
