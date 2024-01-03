package exam01;

public class Schedule {
    int year;
    int month;
    int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(month == 2 && day > 28){
            day = 28;
        }
        this.day = day;
    }

    void showDate(){
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


}
