package com.ipi.jva350.model;

// import com.google.type.DateTime;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedHashSet;
// import java.util.Locale;

class SalarieAideADomicileTest {

    @ParameterizedTest(name = "{0} est valide : {1}")
    @CsvSource({
            "0, false",
            "9, false",
            "10, true",
            "15, true"
    })
    void aLegalementDroitADesCongesPayesinitialize(int jours, Boolean expected) {
        //Given
        SalarieAideADomicile salarie = new SalarieAideADomicile(
                "yoyo", LocalDate.of(2022,10,01), LocalDate.now(), 0, 0, jours, 1, 0
        );
        //When
        boolean res = salarie.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertEquals(res, expected);
        //Assertions.assertThat(res).isFalse();
    }

    @ParameterizedTest(name = "{0} et {1}")
    @CsvSource({
            "'2022-10-11', '2022-10-11'"
    })
    void calculeJoursDeCongeDecomptesPourPlageTest(String date, String daro) {
        LocalDate yolo = LocalDate.parse(date);
        LocalDate yolo2 = LocalDate.parse(daro);
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        LinkedHashSet<LocalDate> expected = new LinkedHashSet<>();
        LocalDate o = LocalDate.of(2022, 10, 11);
        expected.add(o);
        Assertions.assertEquals(expected, salarie.calculeJoursDeCongeDecomptesPourPlage(yolo, yolo2));
    }

    @ParameterizedTest(name = "Date debut :{0} et date fin : {1} expected nombre de congés possibles : {2}")
    @CsvSource({
            "'2022-10-11', '2022-10-11', 1",
            "'2022-07-02', '2022-07-04', 1",
            "'2022-07-01', '2022-07-03', 2",
            "'2022-07-02', '2022-07-02', 0"
    })
    void calculeJoursDeCongeDecomptesPourPlageTest(String date, String daro, double result) {
        LocalDate yolo = LocalDate.parse(date);
        LocalDate yolo2 = LocalDate.parse(daro);

        SalarieAideADomicile salarie = new SalarieAideADomicile();
        // LinkedHashSet<LocalDate> expectedhashset = new LinkedHashSet<>();

        LinkedHashSet<LocalDate> res = salarie.calculeJoursDeCongeDecomptesPourPlage(yolo, yolo2);

        Assertions.assertEquals(result, res.size());
    }


}