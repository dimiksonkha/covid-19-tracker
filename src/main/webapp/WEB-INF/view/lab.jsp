<%-- 
    Document   : lab
    Created on : Apr 24, 2020, 7:34:28 PM
    Author     : dimiksonkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Covid-19 Testing Locations</title>
    </head>
    <body>
        <h1>Covid-19 Testing Locations</h1>

            <c:forEach var="lab" items="${labs}">
                
                <div style="clear: both ">
                     <h2>${lab.name}</h2>
                    <p>${lab.description}</p>
                    <p><b>Address:</b>${lab.physicalAddress.addressOne},${lab.physicalAddress.city},${lab.physicalAddress.region},${lab.physicalAddress.stateProvince},${lab.physicalAddress.postalCode},${lab.physicalAddress.country}</p>
                    <p><b>Phone:</b>${lab.phone}</p>
                </div>
                 
                <div>
                    <table align="left">
                        <thead>
                            <th>Week Day</th>
                            <th>Opens At</th>
                            <th>Closes At</th>         
                        </thead>
                        <c:forEach var="schedule" items="${lab.schedules}">
                            <tr>
                            <td>${schedule.weekDay}</td>
                            <td>${schedule.opensAt}</td>
                            <td>${schedule.closesAt}</td>
                           </tr>
                        </c:forEach>
           
                    </table>
                </div>
                <br>
        
                   
                   
                    
            </c:forEach>
         
    </body>
</html>
