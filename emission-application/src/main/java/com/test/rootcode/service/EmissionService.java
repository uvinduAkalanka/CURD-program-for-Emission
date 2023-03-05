package com.test.rootcode.service;

import com.test.rootcode.model.DAO.EmissionRequest;
import com.test.rootcode.model.Emissions;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface EmissionService {
    Emissions saveEmission(EmissionRequest emission);

    List<Emissions> getAllEmissionsDetails();

    List<Emissions> getAllSassesMoreThanGivenValue(Integer year);

    OptionalDouble minimumAmountOFGas(Integer year);
    Optional<Emissions> minimumAmountOFGasAllDetails(Integer year);

    String sectorOfMinimumAmountOFGas(Integer year);
}
