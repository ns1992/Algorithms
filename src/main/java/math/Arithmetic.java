package math;

public class Arithmetic {

    /**
     * Output:-
     * Given amountPaidInFortnight, work out the amount of rent paid in a Calendar month
     *
     * amountPaidInFortnight 54
     *
     * With incorrect truncating integer division
     * Fortnights in year: 2 ; should be 2.1667
     * Calculated amount paid in fortnight (arithmetic error)
     * As Int: 108
     *
     * With correct double division
     * Fortnights in year: 2.1666666666666665 (cannot be represented as exact figure in floating point arithmetic)
     * Calculated amount paid in fortnight
     * 116.99999999999999
     * As Int (not rounded): 116
     * As Int (rounded): 117
     *
     * -------------------------------
     */
    public static void main(String []args){
        System.out.println("Given amountPaidInFortnight, work out the amount of rent paid in a Calendar month");
        System.out.println();

        int amountPaidInFortnight = 54;
        System.out.println("amountPaidInFortnight " + amountPaidInFortnight);
        System.out.println();

        System.out.println("With incorrect truncating integer division");
        int fortNightsInYearInt = (52 / 2) / 12;
        System.out.println("Fortnights in year: " + fortNightsInYearInt + " ; should be 2.1667");

        double result = amountPaidInFortnight * fortNightsInYearInt;
        System.out.println("Calculated amount paid in fortnight (arithmetic error)");
        System.out.println(("As Int: " + (int) result));
        System.out.println();

        System.out.println("With correct double division");
        double fortNightsInYear = (52.0 / 2) / 12;
        System.out.println("Fortnights in year: " + fortNightsInYear + " (cannot be represented as exact figure in floating point arithmetic)");

        System.out.println("Calculated amount paid in fortnight");
        result = amountPaidInFortnight * fortNightsInYear;
        System.out.println(result);
        System.out.println(("As Int (not rounded): " + (int) result));

        double ceilingResult = Math.ceil(result);
        System.out.println(("As Int (rounded): " + (int) ceilingResult));
    }
}
