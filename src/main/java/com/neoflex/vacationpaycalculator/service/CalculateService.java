package com.neoflex.vacationpaycalculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateService {
    private final HolidayService holidayService;
    public double calculateVacationPay(double salary, int days, LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return calculateWithoutDates(salary, days);
        } else {
            return calculateWithDates(salary, startDate, endDate);
        }
    }

    private double calculateWithoutDates(double salary, int days) {
        return salary * days;
    }

    private double calculateWithDates(double salary, LocalDate startDate, LocalDate endDate) {
        List<LocalDate> vacationDays = getBusinessDays(startDate, endDate);
        int numberOfVacationDays = vacationDays.size();
        return salary * numberOfVacationDays;
    }

    private List<LocalDate> getBusinessDays(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> businessDays = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            if (isBusinessDay(currentDate)) {
                businessDays.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }

        return businessDays;
    }

    private boolean isBusinessDay(LocalDate date) {
        return !isWeekend(date) && !isHoliday(date);
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public interface HolidayService {
        boolean isHoliday(LocalDate date);
    }
    private boolean isHoliday(LocalDate date) {
        return holidayService.isHoliday(date); // Implement the HolidayService to check if a given date is a holiday
    }
    @Service
    public static class HolidayServiceImpl implements HolidayService  {

        public interface HolidayService {
            boolean isHoliday(LocalDate date);
        }
        private static final List<LocalDate> HOLIDAYS = Arrays.asList(
                LocalDate.of(2023, 1, 1), // New Year's Day
                LocalDate.of(2023, 1, 7), // Orthodox Christmas Day
                LocalDate.of(2023, 2, 23), // Defender of the Fatherland Day
                LocalDate.of(2023, 3, 8), // International Women's Day
                LocalDate.of(2023, 5, 1), // Spring and Labor Day
                LocalDate.of(2023, 5, 9), // Victory Day
                LocalDate.of(2023, 6, 12), // Russia Day
                LocalDate.of(2023, 11, 4), // National Unity Day
                LocalDate.of(2023, 12, 25) // Christmas Day (Catholic)
        );

        @Override
        public boolean isHoliday(LocalDate date) {
            return HOLIDAYS.contains(date);
        }
    }
}
