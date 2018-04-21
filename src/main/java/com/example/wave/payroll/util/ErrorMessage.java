package com.example.wave.payroll.util;

public interface ErrorMessage {

    String ReportUploaded = "This report has already been uploaded";
    String ReportNumberMissing = "Report number is missing in the CSV";
    String CSVError = "There was an error parsing the CSV file. Please check the format";
    String InvalidJobGroup = "The Job Group is invalid for one of the entries. It should be A or B";
    String InvalidFileType = "Only CSV files are allowed";
    String Error = "Something went wrong, please try again";
}
