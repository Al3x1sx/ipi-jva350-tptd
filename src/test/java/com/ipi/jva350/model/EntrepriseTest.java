package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {

    @ParameterizedTest(name = "Date à vérifier :{0} Date debut :{1} et date fin : {2} expected value : {3}")
    @CsvSource({
            "'2022-10-11', '2022-10-11','2022-10-11', true",
            "'2022-10-10', '2022-10-09','2022-10-11', true",
            "'2022-10-08', '2022-10-08','2022-10-12', true",
            "'2022-10-12', '2022-10-08','2022-10-12', true",
            "'2022-10-04', '2022-10-08','2022-10-11', false"
    })
    void estDansPlage(String dateToCheck, String debut, String fin, boolean result) {
        LocalDate checkDate = LocalDate.parse(dateToCheck);
        LocalDate dateDebut = LocalDate.parse(debut);
        LocalDate dateFin = LocalDate.parse(fin);

        Assertions.assertEquals(result, Entreprise.estDansPlage(checkDate, dateDebut, dateFin));
    }

    @ParameterizedTest(name = "Date à vérifier :{0} resultat :{1}")
    @CsvSource({
            "'2012-04-09', true",
            "'2022-04-10', false",
            "'2022-04-08', false",
            "'2022-10-12', false",
            "'2012-01-01', true"
    })
    void estJourFerie(String date, boolean expect) {
        LocalDate dateCheck = LocalDate.parse(date);

        Assertions.assertEquals(expect, Entreprise.estJourFerie(dateCheck));
    }

    @ParameterizedTest(name = "Date à vérifier: {0} resultat: {1}")
    @CsvSource({
            "'2012-04-09', '2011-06-01'",
            "'2022-06-10', '2022-06-01'",
            "'2022-07-08', '2022-06-01'",
            "'2022-02-12', '2021-06-01'",
            "'null', 'null'"
    })
    void getPremierJourAnneeDeConges(String dateToCheck, String expectedDate) {
        LocalDate dateCheck = null;
        LocalDate dateResult = null;

        if(!Objects.equals(dateToCheck, "null")){
            dateCheck = LocalDate.parse(dateToCheck);
        }
        if(!Objects.equals(expectedDate, "null")){
            dateResult = LocalDate.parse(expectedDate);
        }

        Assertions.assertEquals(dateResult, Entreprise.getPremierJourAnneeDeConges(dateCheck));
    }
}