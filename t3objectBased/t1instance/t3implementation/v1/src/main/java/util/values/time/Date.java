package util.values.time;

import util.values.interval.IntegerInterval;

public class Date {

    public static final int MONTHS_MODULE = 12;
    public static final int DYAS_MODULE = 30;

    public static boolean isValidMonth(int month) {
        return new IntegerInterval(1, MONTHS_MODULE).includes(month);
    }

    public static boolean isValidDay(int day) {
        return new IntegerInterval(1, DYAS_MODULE).includes(day);
    }

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        assert isValidMonth(month) : "with month: " + month;
        assert isValidDay(day) : "with day: " + day;

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean equals(Object object) {
        assert object instanceof Date;

        Date date = (Date) object;
        return this.year == date.year
                && this.month == date.month
                && this.day == date.day;
    }

    public boolean before(Date date) {
        if (this.year < date.year) {
            return true;
        }
        if (this.year == date.year) {
            if (this.month < date.month) {
                return true;
            }
            if (this.month == date.month) {
                if (this.day < date.day) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean after(Date date) {
        return !this.before(date) && !this.equals(date);
    }

    public int compareTo(Date date) {
        if (this.before(date)) {
            return -1;
        }
        if (this.equals(date)) {
            return 0;
        }
        return 1;
    }

    public Date next() {
        int year = this.year;
        int month = this.month;
        int day = this.day + 1;
        if (!isValidDay(day)) {
            day = 1;
            month++;
            if (!isValidMonth(month)) {
                month = 1;
                year++;
            }
        }
        return new Date(year, month, day);
    }

    public String toString() {
        return "Date [" + this.year + ":" + this.month + ":" + this.day + "]";
    }

}
