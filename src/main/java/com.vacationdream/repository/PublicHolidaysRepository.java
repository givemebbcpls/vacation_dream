package com.vacationdream.repository;

import com.vacationdream.data.PublicHolidays;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;


public interface PublicHolidaysRepository extends CrudRepository<PublicHolidays, Date> {
}
