package util.values;

public class Date {

    public final int MONTHS_MODULE = 12;
    public final int DYAS_MODULE = 30;

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        assert this.isValidMonth(month) : "with month: " + month;
        assert this.isValidDay(day) : "with day: " + day;

        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public boolean isValidMonth(int month) {
        return new IntegerInterval(1, this.MONTHS_MODULE).includes(month);
    }

    public boolean isValidDay(int day) {
        return new IntegerInterval(1, this.DYAS_MODULE).includes(day);
    }

    public boolean equals(Date date) {
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
        return "Date [" + this.year + "/" + this.month + "/" + this.day + "]";
    }

}
