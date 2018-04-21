package com.example.wave.payroll.util;

public interface ErrorMessage {

    String ReportUploaded = "This report has already been uploaded";
    String ReportNumberMissing = "Report number is missing in the CSV";
    String CSVError = "There was an error parsing the CSV file. Please check the format";
}
