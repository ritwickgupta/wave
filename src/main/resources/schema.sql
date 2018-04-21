drop table if exists record;

create table record (
  id integer not null auto_increment,
  jobdate date not null,
  hoursworked decimal not null,
  employeeid integer not null,
  jobgroup varchar(1) not null
);

drop table if exists payroll_report;

create table payroll_report (
  id integer not null auto_increment,
  employeeid integer not null,
  startdate date not null,
  enddate date not null,
  amountpaid decimal not null
);


drop table if exists report_number;

create table report_number (
  id integer not null auto_increment,
  reportNumber integer not null
);