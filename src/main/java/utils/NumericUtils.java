package utils;

public class NumericUtils {

    public static int reverseBasicInt(int x) {
        int rev = 0;
        while (x != 0) {
            // Pop last digit from the input
            int pop = x % 10;
            x /= 10;


            // Check for overflow
            // 1) Has room for another digit
            // 2) If so - able to append pop value to max / min
            //            (Max signed int == 2^32/2 = 2,147,483,648 = (-1 to account for 0) 2,147,483,647
            //            (Min signed int == 2^32/2 = -2,147,483,648
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            // Push the pop to the reverse as the last digit
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverseBasicAPIInt(int x) {
        final String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
