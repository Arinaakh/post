package ir.ac.kntu;

public class Date {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public Date(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    public boolean isBigger(Object o){
        if(o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;

        if(year == date.year && month == date.month && day == date.day && hour == date.hour && minute > date.minute){
            return true;
        }
        if(year == date.year && month == date.month && day == date.day && hour > date.hour){
            return true;
        }
        if(year == date.year && month == date.month && day > date.day){
            return true;
        }
        if(year == date.year && month > date.month ){
            return true;
        }
        if(year > date.year){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute ;
    }
}
