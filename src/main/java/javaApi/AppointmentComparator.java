package javaApi;

import java.util.Comparator;
import java.util.List;

public class AppointmentComparator {
    private static final Comparator<String> PRODUCT_COMPARATOR = (String stringOne, String stringTwo) -> {
        if(stringOne.equals(stringTwo)) {
            return 0;
        }

        if(stringOne.equals("goodType")) {
            return 1;
        } else {
            return -1;
        }
    };


    // Compare end dates
    // If these are null, go by product type
    // Finally go by the start date
    private static final Comparator<AppointmentInfo> COMPARATOR = Comparator.comparing(
            // First argument extracts the elements to compare, Second is comparing the elements themselves (the LocalDates) but will sort nulls accordingly
            AppointmentInfo::getEndDate, Comparator.nullsFirst(Comparator.naturalOrder()))
            .thenComparing(AppointmentInfo::getProductType, Comparator.nullsFirst(PRODUCT_COMPARATOR))
            .thenComparing(AppointmentInfo::getStartDate, Comparator.nullsFirst(Comparator.naturalOrder()));

    public List<AppointmentInfo> sort(final List<AppointmentInfo> appointmentInfos) {
        appointmentInfos.sort(COMPARATOR);
        return appointmentInfos;
    }
}
