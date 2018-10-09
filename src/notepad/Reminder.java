package notepad;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder extends Note {
    private LocalDate date;
    private LocalTime time;

    @Override
    public void askQuestions() {
        super.askQuestions();

        System.out.println("Enter Reminder date:");
        date = Main.askDate();
        System.out.println("Enter Reminder time:");
        time = Main.askTime();

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    @Override
    public boolean hasSubstring(String str) {
        return super.hasSubstring(str)
                || date.format(Main.DATE_FORMATTER).contains(str)
                || time.format(Main.TIME_FORMATTER).contains(str);
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                ", Text='" + getText() + '\'' +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}