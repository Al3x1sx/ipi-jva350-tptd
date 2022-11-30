package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.LinkedHashSet;


// import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SalarieAideADomicileServiceTest {

    @Autowired
    private SalarieAideADomicileService salarieAideADomicileService;
    @Test
    void clotureMois() throws SalarieException {
        SalarieAideADomicile aide = new SalarieAideADomicile(
                "yoyo", LocalDate.of(2022,10,01), LocalDate.now(), 0, 0, 0, 1, 0
        );
            salarieAideADomicileService.clotureMois(aide, 20);
        Assertions.assertEquals(20, aide.getJoursTravaillesAnneeN());
    }

    @ParameterizedTest(name = "Date debut :{0} et date fin : {1} expected nombre de congés possibles : {2}")
    @CsvSource({
            "'2022-12-01', '2022-12-15', 1",
            "'2022-07-02', '2022-07-04', 0",
            "'2022-07-01', '2022-07-03', 0",
            "'2022-07-02', '2022-07-02', 0"
    })
    void calculeLimiteEntrepriseCongesPermis(String dateUne, String DateDeux, double result) {
        LocalDate date = LocalDate.parse(dateUne);
        LocalDate data = LocalDate.parse(DateDeux);
        SalarieAideADomicile aide = new SalarieAideADomicile(
                "yoyo", LocalDate.of(2022,10,01), LocalDate.now(), 0, 0, 10, 1, 0
        );

        double congesNmoins1 = 2.1;
        Assertions.assertEquals(result, SalarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(aide.getMoisEnCours(), congesNmoins1, aide.getMoisDebutContrat(), date, data));
    }
}