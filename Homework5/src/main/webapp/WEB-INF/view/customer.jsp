<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Chungdenroi
  Date: 12/20/2021
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"  %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
    <center>
        <h1>New Customer</h1>
        <form action="customer" method="post">
            <table>
                <tr>
                    <td>Full name: </td>
                    <td><input type="text" name="fullname" required minlength="3" maxlength="50"></td>
                </tr>
                <tr>
                    <td>Birthday: </td>
                    <td><input type="date" name="birthday" value=<%=LocalDate.now()%>></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" required minlength="10" maxlength="50"></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" minlength="3" maxlength="60"></td>
                </tr>
                <tr>
                    <td>Mobile phone: </td>
                    <td><input type="text" name="mobilePhone" minlength="10" maxlength="11"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <fieldset>
                            <legend>Gender</legend>
                            <input type="radio" name="gender" value="Male"> Male
                            <input type="radio" name="gender" value="Female"> Female
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add">
                        <input type="reset" value="Reset">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
