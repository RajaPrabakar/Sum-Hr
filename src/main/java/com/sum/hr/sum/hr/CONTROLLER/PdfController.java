package com.sum.hr.sum.hr.CONTROLLER;
import com.sum.hr.sum.hr.DTO.SalaryRequestDTO;
import com.sum.hr.sum.hr.JPA.SalaryRepository;
import com.sum.hr.sum.hr.JWTUtil;
import com.sum.hr.sum.hr.MODEL.Salary;
import com.sum.hr.sum.hr.SERVICE.GeneratePdf;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PdfController
{
    @Autowired
    private GeneratePdf generatePdf;
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SalaryRepository salaryRepository;
    Map<String,Object> map = new HashMap<>();

    @GetMapping(value = "/get-salary-report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> getSalaryReport(@RequestHeader(value = "authentication", defaultValue = "") String auth, @RequestBody SalaryRequestDTO salaryRequestDTO) throws Exception
    {
        Claims claims = jwtUtil.verifyJWT(auth);
        List<Salary> list = salaryRepository.findByUsers_UserId(Integer.valueOf(claims.getId()));
        ByteArrayInputStream byteArrayInputStream = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=salaryReport.pdf");
        for (Salary salary : list)
        {
            if (Month.of(salary.getUpdateDate().getMonthValue()).toString().equalsIgnoreCase((salaryRequestDTO.getDownloadPaySlipMonth())))
            {
                 byteArrayInputStream = generatePdf.salaryReport(list, salaryRequestDTO);
            }
        }
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}