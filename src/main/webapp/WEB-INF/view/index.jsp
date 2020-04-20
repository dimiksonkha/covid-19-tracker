<%-- 
    Document   : index
    Created on : Apr 19, 2020, 7:01:45 PM
    Author     : dimiksonkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h2>COVID-19 STATUS</h2>
        <table>
            <thead>
                <th>Country</th>
                <th>Confirmed</th>
                <th>Cases Per Million</th>
                <th>Recovered</th>
                <th>Deaths</th>
         
            </thead>
            <tr>
                <td>${status.country}</td>
                <td>${status.confirmed}</td>
                <td>${status.casesPerMillion}</td>
                <td>${status.recovered}</td>
                <td>${status.deaths}</td>
            </tr>
        </table>
     

    </body>
</html>
