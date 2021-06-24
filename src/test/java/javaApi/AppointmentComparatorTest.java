package javaApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentComparatorTest {

    private final AppointmentComparator appointmentComparator = new AppointmentComparator();

    private List<AppointmentInfo> appointmentInfo;
    private AppointmentInfo firstApp;
    private AppointmentInfo secondApp;
    private AppointmentInfo thirdApp;

    // 'z' used to be naturally higher in comparison order than 'g' in 'goodType'
    private static final String DONT_CARE = "zdontcare";
    private static final String GOOD_TYPE = "goodType";

    @BeforeEach
    public void setup() {
        firstApp = new AppointmentInfo(LocalDate.of(1992, 5, 15),
                LocalDate.of(1992, 2, 15),
                DONT_CARE);

        secondApp = new AppointmentInfo(LocalDate.of(1992, 3, 15),
                LocalDate.of(1992, 4, 15),
                DONT_CARE);

        thirdApp = new AppointmentInfo(LocalDate.of(1992, 1, 15),
                LocalDate.of(1992, 6, 15),
                DONT_CARE);

        appointmentInfo = new ArrayList<>();
        appointmentInfo.add(firstApp);
        appointmentInfo.add(secondApp);
        appointmentInfo.add(thirdApp);
    }


    @Test
    public void whenSomeNullEndDate_shouldReturnLatestDate() {
        thirdApp.setEndDate(null);

        appointmentComparator.sort(appointmentInfo);
        assertEquals(secondApp, getMaxSortedAppointment());
    }


    @Test
    public void whenEqualEndDate_shouldReturnBestProduct() {
        final LocalDate equalEndDate = LocalDate.of(1992, 6, 15);
        firstApp.setEndDate(equalEndDate);
        secondApp.setEndDate(equalEndDate);
        thirdApp.setEndDate(equalEndDate);

        firstApp.setProductType(GOOD_TYPE);

        appointmentComparator.sort(appointmentInfo);
        assertEquals(firstApp, getMaxSortedAppointment());
    }

    @Test
    public void whenEqualEndDate_shouldReturnBestProduct_AndShouldIgnoreNulls() {
        final LocalDate equalEndDate = LocalDate.of(1992, 6, 15);
        firstApp.setEndDate(equalEndDate);
        secondApp.setEndDate(equalEndDate);
        thirdApp.setEndDate(equalEndDate);

        thirdApp.setProductType(null);

        secondApp.setProductType(GOOD_TYPE);

        appointmentComparator.sort(appointmentInfo);
        assertEquals(secondApp, getMaxSortedAppointment());
    }

    @Test
    public void whenEqualEndDate_AndEqualProductType_shouldReturnLatestStart() {
        final LocalDate equalEndDate = LocalDate.of(1992, 6, 15);
        firstApp.setEndDate(equalEndDate);
        secondApp.setEndDate(equalEndDate);
        thirdApp.setEndDate(equalEndDate);

        final String equalProductType = DONT_CARE;
        firstApp.setProductType(equalProductType);
        secondApp.setProductType(equalProductType);
        thirdApp.setProductType(equalProductType);

        appointmentComparator.sort(appointmentInfo);
        assertEquals(firstApp, getMaxSortedAppointment());
    }

    @Test
    public void whenEqualEndDate_AndEqualProductType_shouldReturnLatestStart_AndIgnoreNulls() {
        final LocalDate equalEndDate = LocalDate.of(1992, 6, 15);
        firstApp.setEndDate(equalEndDate);
        secondApp.setEndDate(equalEndDate);
        thirdApp.setEndDate(equalEndDate);

        final String equalProductType = DONT_CARE;
        firstApp.setProductType(equalProductType);
        secondApp.setProductType(equalProductType);
        thirdApp.setProductType(equalProductType);

        firstApp.setStartDate(null);

        appointmentComparator.sort(appointmentInfo);
        assertEquals(secondApp, getMaxSortedAppointment());
    }


    private AppointmentInfo getMaxSortedAppointment() {
        return appointmentInfo.get(appointmentInfo.size() - 1);
    }
}