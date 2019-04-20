package com.example.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
	
     private String dateId;
     
     private String dateName;
     
     private int adjustmentYear;
     
     private int adjustmentMonth;
     
     private int adjustmentDay;
     
     private String calculatedDate;
     
     public Date(){
    	 
     }

     public Date DateConversion(String baseDate) {
 		LocalDate fmt= LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
 		LocalDate result =fmt.plusYears(adjustmentYear).plusMonths(adjustmentMonth).plusDays(adjustmentDay);
 			this.calculatedDate = result.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
 			return this;
 	}
     
	public String getDateId() {
		return dateId;
	}

	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public int getAdjustmentYear() {
		return adjustmentYear;
	}

	public void setAdjustmentYear(int adjustmentYear) {
		this.adjustmentYear = adjustmentYear;
	}

	public int getAdjustmentMonth() {
		return adjustmentMonth;
	}

	public void setAdjustmentMonth(int adjustmentMonth) {
		this.adjustmentMonth = adjustmentMonth;
	}

	public int getAdjustmentDay() {
		return adjustmentDay;
	}

	public void setAdjustmentDay(int adjustmentDay) {
		this.adjustmentDay = adjustmentDay;
	}

	public String getCalculatedDate() {
		return calculatedDate;
	}

	public void setCalculatedDate(String calculatedDate) {
		this.calculatedDate = calculatedDate;
	}


}
