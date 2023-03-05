package com.test.rootcode.repository;

import com.test.rootcode.model.Emissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmissionRepository extends JpaRepository<Emissions,Long> {
}
