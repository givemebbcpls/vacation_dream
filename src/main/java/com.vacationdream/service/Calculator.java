package com.vacationdream.service;

import com.vacationdream.repository.PublicHolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Calculator {
    @Autowired
    private PublicHolidaysRepository publicHolidaysRepository;

    private final static double DAYS_IN_MONTH = 29.3;

    public double vacationPay(double salary, int days) {
        return Math.round(salary / DAYS_IN_MONTH * days * 100) / 100.0;
    }

    public double vacationPay(double salary, int days, Date startDate) {
        days = checkHolidays(days, startDate);
        return vacationPay(salary, days);
    }

    private int checkHolidays(int days, Date startDate) {
        int holidaysCounter = 0;
        for (int i = days; i > 0; i--) {
            if (publicHolidaysRepository.findById(startDate).isPresent()) {
                holidaysCounter++;
            }
            startDate.setTime(startDate.getTime() + 86_400_000); //set next day
        }
        return days - holidaysCounter;
    }
}
