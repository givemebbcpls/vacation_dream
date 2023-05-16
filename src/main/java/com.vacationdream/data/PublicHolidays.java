package com.vacationdream.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PublicHolidays {
    @Id
    private Date holiday;

    public Date getHoliday() {
        return holiday;
    }

    public void setHoliday(Date holiday) {
        this.holiday = holiday;
    }
}
