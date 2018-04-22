<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payroll</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
    <h1 class="text-center">Payroll</h1>
<br><br>
    <h5>${msg}</h5>

<form method="POST" action="/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/><br/>
    <input type="submit" value="Submit" />
</form>

<br><br>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Employee ID</th>
        <th scope="col">Pay Period</th>
        <th scope="col">Amount Paid</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="record">
        <tr>
            <th scope="row">${record.employeeId}</th>
            <td>${record.payPeriod}</td>
            <td>${record.amountPaid}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>