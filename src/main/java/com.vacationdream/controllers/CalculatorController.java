package com.vacationdream.controllers;

import com.vacationdream.service.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/calculate")
public class CalculatorController {
    @Autowired
    private Calculator calculator;
    @PostMapping
    public @ResponseBody double vacationPay(@RequestParam(name = "salary") double salary,
                                            @RequestParam(name = "days") int days,
                                            @RequestParam(name = "startdate", required = false) Date startDate) {
        if (salary < 0 || days < 0) {
            return 0.0;
        }

        if (startDate != null) {
            if (startDate.before(Date.valueOf("2023-01-01")) ||
                    startDate.after(Date.valueOf("2023-12-31"))) {
                return 0.0;
            }
            return calculator.vacationPay(salary, days, startDate);
        } else {
            return calculator.vacationPay(salary, days);
        }
    }

    @GetMapping
    public String getForms() {
        return "calculate";
    }
}
