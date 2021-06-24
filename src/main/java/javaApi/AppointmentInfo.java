package javaApi;

import java.time.LocalDate;

public class AppointmentInfo {
    private LocalDate startDate;
    private LocalDate endDate;
    String productType;

    public AppointmentInfo(final LocalDate startDate, final LocalDate endDate, final String productType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.productType = productType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setProductType(final String productType) {
        this.productType = productType;
    }
}
