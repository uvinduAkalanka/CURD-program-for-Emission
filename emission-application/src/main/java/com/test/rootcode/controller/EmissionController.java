package com.test.rootcode.controller;

import com.test.rootcode.exception.BadRequestException;
import com.test.rootcode.model.DAO.EmissionRequest;
import com.test.rootcode.model.Emissions;
import com.test.rootcode.repository.EmissionRepository;
import com.test.rootcode.service.EmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/emission")
public class EmissionController {
    private final EmissionService emissionService;
    private final EmissionRepository emissionRepository;

    @Autowired
    public EmissionController(EmissionService emissionService, EmissionRepository emissionRepository) {
        this.emissionService = emissionService;
        this.emissionRepository = emissionRepository;
    }


    @PostMapping("/save")
    public ResponseEntity<Emissions> saveEmissions(@RequestBody EmissionRequest emission) {
        try {
            Emissions emissions = emissionService.saveEmission(emission);
            return ResponseEntity.ok(emissionRepository.save(emissions));
        } catch (BadRequestException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<Emissions>>getAllEmissions(@PathVariable Integer year) {
        return ResponseEntity.ok(emissionService.getAllSassesMoreThanGivenValue(year));
    }
     @GetMapping("/minimum-value/{year}")
    public ResponseEntity<Optional<Emissions>>getMinimumGasEmissions(@PathVariable Integer year) {
        return ResponseEntity.ok(emissionService.minimumAmountOFGasAllDetails(year));
    }

 @GetMapping("/minimum-value-sector/{year}")
    public ResponseEntity<String>getMinimumGasEmissionsSector(@PathVariable Integer year) {
        return ResponseEntity.ok(emissionService.sectorOfMinimumAmountOFGas(year));
    }


}
