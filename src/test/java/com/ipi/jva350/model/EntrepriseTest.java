package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {

    @ParameterizedTest(name = "Date à vérifier :{0} Date debut :{1} et date fin : {2} expected value : {3}")
    @CsvSource({
            "'2022-10-11', '2022-10-11','2022-10-11', true",
            "'2022-10-10', '2022-10-09','2022-10-11', true",
            "'2022-10-08', '2022-10-08','2022-10-12', true",
            "'2022-10-12', '2022-10-08','2022-10-12', true",
            "'2022-10-04', '2022-10-08','2022-10-11', false",
    })
    void estDansPlage(String dateToCheck, String debut, String fin, boolean result) {
        LocalDate checkDate = LocalDate.parse(dateToCheck);
        LocalDate dateDebut = LocalDate.parse(debut);
        LocalDate dateFin = LocalDate.parse(fin);

        Assertions.assertEquals(result, Entreprise.estDansPlage(checkDate, dateDebut, dateFin));
    }
}