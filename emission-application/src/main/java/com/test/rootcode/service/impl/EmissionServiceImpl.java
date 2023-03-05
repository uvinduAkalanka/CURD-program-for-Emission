package com.test.rootcode.service.impl;

import com.test.rootcode.exception.BadRequestException;
import com.test.rootcode.model.DAO.EmissionRequest;
import com.test.rootcode.model.Emissions;
import com.test.rootcode.repository.EmissionRepository;
import com.test.rootcode.service.EmissionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmissionServiceImpl implements EmissionService {
    private final EmissionRepository emissionRepository;

    public EmissionServiceImpl(EmissionRepository quizQuestionsRepository) {
        this.emissionRepository = quizQuestionsRepository;
    }


    //    @Override
//    public Emissions saveEmission(Emissions emission) {
//        if (emission.getYear() > 2007)
//            return emissionRepository.save(emission);
//        else {
//            throw new BadRequestException("entered year is not valid year");
//        }
//    }
    @Override
    public Emissions saveEmission(EmissionRequest emission) {
        double value = emission.getValue();
        String unit = emission.getUnit();
        if (emission.getYear() > 2007) {
            if (emission.getUnit().equals("kg")) {
                value /= 1000;
                unit = "000 Tonnes";
            } else if (unit == null) {
                unit = "000 Tonnes";
            }
            Emissions emissions = new Emissions();
            emissions.setSector(emission.getSector());
            emissions.setYear(emission.getYear());
            emissions.setStatistic(emission.getStatistic());
            emissions.setStatisticCode(emission.getStatisticCode());
            emissions.setUnit(unit);
            emissions.setValue(value);
            return emissions;

        } else {
//            throw new BadRequestException(emission.getYear());
            throw new BadRequestException("you can not enter  yer lower than 2007 but you entered : ", emission.getYear().toString());
        }
    }

    @Override
    public List<Emissions> getAllEmissionsDetails() {
        return emissionRepository.findAll();
    }

    @Override
    public List<Emissions> getAllSassesMoreThanGivenValue(Integer year) {

        return getAllEmissionsDetails()
                .stream()
                .filter(emission -> Objects.equals(emission.getYear(), year) && emission.getYear() > year).collect(Collectors.toList());
    }

    @Override
    public OptionalDouble minimumAmountOFGas(Integer year) {
        return getAllEmissionsDetails()
                .stream()
                .filter(emission -> Objects.equals(emission.getYear(), year))
                .mapToDouble(Emissions::getYear)
                .min();
    }

     @Override
    public Optional<Emissions> minimumAmountOFGasAllDetails(Integer year) {
        return getAllEmissionsDetails()
                .stream()
                .filter(emission -> Objects.equals(emission.getYear(), year))
                .min(Comparator.comparingDouble(Emissions::getValue));
    }

    @Override
    public String sectorOfMinimumAmountOFGas(Integer year) {
        return getAllEmissionsDetails()
                .stream()
                .filter(emission -> Objects.equals(emission.getYear(), year))
                .min(Comparator.comparingDouble(Emissions::getValue))//.get().getSector();
                .map(Emissions::getSector)
                .orElseThrow(()-> new BadRequestException("please try again : ", "invalid"));

    }
}
