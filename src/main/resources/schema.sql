drop table if exists record;

create table record (
  id integer not null,
  jobdate date not null,
  hoursworked integer not null,
  employeeid integer not null,
  jobgroup varchar(1) not null
);

drop table if exists payrollreport;

create table payrollreport (
  id integer not null,
  employeeid integer not null,
  startdate date not null,
  enddate date not null,
  amountpaid decimal not null
);