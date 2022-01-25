package com.example.testProject.controller;

import com.example.testProject.report.TotalStatistics;
import com.example.testProject.report.ProfExcel;
import com.example.testProject.service.ProfForReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/report")
public class ProfControllerReport {
    private final ProfForReportService service;
    public ProfControllerReport(ProfForReportService service) {
        this.service = service;
    }

    @GetMapping("/prof")
    public void exportToExcel(@RequestParam ("prof_id") Long prof_id, HttpServletResponse response) throws IOException {
        log.info("Формирование отчета");
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List<TotalStatistics> listUsers = new ArrayList<>();
                listUsers.add(service.listAll(prof_id));
        ProfExcel excelExporter = new ProfExcel(listUsers);
        excelExporter.export(response);
    }
}