import java.util.*;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        String[] a = date1.split("-");
        String[] b = date2.split("-");

        c1.set(Integer.parseInt(a[0]), Integer.parseInt(a[1]) - 1,
               Integer.parseInt(a[2]), 0, 0, 0);

        c2.set(Integer.parseInt(b[0]), Integer.parseInt(b[1]) - 1,
               Integer.parseInt(b[2]), 0, 0, 0);

        long diff = Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis());

        return (int)(diff / (24 * 60 * 60 * 1000));
    }
}