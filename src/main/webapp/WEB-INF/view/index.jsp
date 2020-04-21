<%-- 
    Document   : index
    Created on : Apr 19, 2020, 7:01:45 PM
    Author     : dimiksonkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Covid-19 Tracker</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>
        <h2>COVID-19 STATUS</h2>
        <h3>Worldwide Status</h3>
        <table align="center">
            <thead>
            
                <tr>     
                <td>Total Confirmed: ${totalConfirmed}</td>
                <td>Total Recovered: ${totalRecovered}</td>
                <td>Total Deaths: ${totalDeaths}</td>

               </tr>
           
           
        </table>
        
          <h3>Country wise Status</h3>
        <table align="center">
            <thead>
                <th>Country</th>
                <th>Confirmed</th>
                <th>Recovered</th>
                <th>Deaths</th>
                <th>Action</th>
         
            </thead>
            <c:forEach var="status" items="${covidStatus}">
                 <tr>
                <td>${status.country}</td>
                <td>${status.confirmed}</td>
                <td>${status.recovered}</td>
                <td>${status.deaths}</td>
                <td><button>Details</button></td>
               </tr>
            </c:forEach>
           
        </table>
   
    </body>
</html>
