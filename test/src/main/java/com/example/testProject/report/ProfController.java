package com.example.testProject.report;


import com.example.testProject.models.Professors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProfController {

    private final ServiceProfForReport service;

    public ProfController(ServiceProfForReport service) {
        this.service = service;
    }

// ServiceProfForReport работает без параметров (НЕ РЕАЛИЗОВАНА!), однако для скачивания шаблона отчета
// требуется ссылка с параметром. Например /prof/?id=2
    @GetMapping("/prof")
    public void exportToExcel(@RequestParam Long id, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Professors> listUsers = service.listAll();

        ProfExcel excelExporter = new ProfExcel(listUsers);

        excelExporter.export(response);
    }

}