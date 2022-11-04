package com.ipi.jva350.service;

import com.ipi.jva350.exception.SalarieException;
import com.ipi.jva350.model.SalarieAideADomicile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
}