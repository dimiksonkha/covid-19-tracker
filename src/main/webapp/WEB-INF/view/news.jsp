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
        <h1>Covid-19 News</h1>

            <c:forEach var="news" items="${newsList}">
                
                <div style="clear: both ">
                     <h2>${news.title}</h2>
                    <p>${news.description}</p>
                    <p>${news.content}</p>
                    <a href="${news.url}" target="_blank" >Read more</a>
                    <b>Source:</b>${news.source}
                </div>
                 
                
                    
                <br>
        
                   
                   
                    
            </c:forEach>
         
    </body>
</html>
