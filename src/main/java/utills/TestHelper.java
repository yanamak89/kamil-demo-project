package utills;

import java.time.LocalDate;
import java.time.Month;

public class TestHelper {
    private static LocalDate currentdate = LocalDate.now();
    private static Month currentMonth = currentdate.getMonth();


    public static void sleep5Seconds() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int getCurrentDateNumber(){
        return currentdate.getDayOfMonth();
    }

    public static int getTomorrowDateNumber(){
        LocalDate tomorrow = currentdate.plusDays(1);
        return tomorrow.getDayOfMonth();
    }

    //TODO figure out with DAY_AFTER_TOMORROW and getTheDayAfterTomorrow
    public static int getTheDayAfterTomorrow(){
        LocalDate tomorrow1 = currentdate.plusDays(2);
        return tomorrow1.getDayOfMonth();
    }

    public static String getCurrentMonth(){
        return currentMonth.toString();

    }

    public static String getNextMonth(){
        return currentMonth.plus(1).toString();
    }
}

