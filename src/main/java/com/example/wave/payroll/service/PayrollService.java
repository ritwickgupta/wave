package com.example.wave.payroll.service;

import com.example.wave.payroll.persistence.Record;
import com.example.wave.payroll.persistence.ReportNumber;
import com.example.wave.payroll.repository.PayrollReportRepository;
import com.example.wave.payroll.repository.ReportNumberRepository;
import com.example.wave.payroll.repository.RecordRepository;
import com.example.wave.payroll.util.Constants;
import com.example.wave.payroll.util.ErrorMessage;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    Logger log = LoggerFactory.getLogger(PayrollService.class);

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    PayrollReportRepository payrollReportRepository;

    @Autowired
    ReportNumberRepository reportNumberRepository;

    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }

    public String uploadAndSaveRecord(MultipartFile multipartFile) throws IOException, NumberFormatException, ParseException {

        String result = "";
        File file = convertMultiPartToFile(multipartFile);
        List<Record> records = new ArrayList<>();
        ReportNumber reportNumber = new ReportNumber();

        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if(Constants.Date.equalsIgnoreCase(line[0])) {
                    continue;
                } else if (Constants.ReportId.equalsIgnoreCase(line[0])) {
                    if(reportNumberRepository.findByRecordNumber(Integer.parseInt(line[1])) != null) {
                        log.info(ErrorMessage.ReportUploaded);
                        return ErrorMessage.ReportUploaded;
                    } else {
                        reportNumber.setReportNumber(Integer.parseInt(line[1]));
                    }
                } else {
                    DateFormat dateFormat = new SimpleDateFormat(Constants.DateFormat);
                    Record record = new Record(dateFormat.parse(line[0]), Double.parseDouble(line[1]), Integer.parseInt(line[2]), line[3]);
                    log.info(record.toString());
                    records.add(record);
                }
            }

            if(reportNumber.getReportNumber() == null) {
                log.info(ErrorMessage.ReportNumberMissing);
                return ErrorMessage.ReportNumberMissing;
            }

            recordRepository.saveAll(records);
            reportNumberRepository.save(reportNumber);
            return result;
        }
    }
}
