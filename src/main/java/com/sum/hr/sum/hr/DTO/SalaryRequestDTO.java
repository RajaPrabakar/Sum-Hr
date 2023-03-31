package com.sum.hr.sum.hr.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SalaryRequestDTO
{
    private int salaryId;

    private double annualPay;

    private double monthlyPay;

    private double hra;

    private double conveyance;

    private double totalAddition;

    private double providentFund;

    private double esi;

    private double loan;

    private double professionTax;

    private double totalDeduction;

    private double netSalary;

    @NotBlank(message = "Enter the Month to download")
    private String downloadPaySlipMonth;

    private String payslip;
}
