package hw_04_03;
/* Спроектируйте и разработайте метод, определяющий, сколько времени прошло с заданной даты.
   С помощью этого методы выведите в консоль, сколько времени прошло с вашего дня рождения
   в удобном для восприятия виде, например:
   «Вам исполнилось 20 лет, 3 месяца, 18 дней, 4 часа, 5 минут и 10 секунд».
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Person {
    int years;
    int months;
    int days;

    public Person() {
    }

    public Person(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Person{" + "years=" + years + ", months=" + months + ", days=" + days + '}';
    }


    public String timePeriod() {

        LocalDate today = LocalDate.now();
        int yearNow = today.getYear();
        int monthNow = today.getMonthValue();
        int dayOfMonthNow = today.getDayOfMonth();

        LocalDate startDate = LocalDate.of(years, months, days);
        if (monthNow == months && dayOfMonthNow == days) {
            int parYear = yearNow - years;
            System.err.println("Поздравляю!У Вас сегодня День Рождение! Вам - " + parYear + " лет!");
            System.exit(0);
        }
        Period period = Period.between(startDate, today);
        return "Вам исполнилось " + period.getYears() + " лет, "
                + period.getMonths() + " месяцев, " + period.getDays() + " дней";
    }
}


public class PeriodTime {
    public static void main(String[] args) {
        try {
            LocalDate today = LocalDate.now();
            System.out.println("Сегодня - " + today);

            System.out.println("Введите дату вашего рождения -");
            Scanner scanner = new Scanner(System.in);
            System.out.print("введите день: ");
            int day = scanner.nextInt();
            System.out.print("введите месяц: ");
            int month = scanner.nextInt();
            System.out.print("введите год: ");
            int year = scanner.nextInt();

            Person personTime = new Person(year, month, day);
            System.out.println(personTime.timePeriod());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
