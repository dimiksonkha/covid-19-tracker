<%--
    Document   : index
    Created on : Apr 19, 2020, 7:01:45 PM
    Author     : dimiksonkha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Main CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">


    <title>COVID-19 Tracker</title>
  
  </head>
  <body>

    <div class="container">

      <div class="row">
          <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">COVID-19 Tracker</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                      <a class="nav-link" href="${pageContext.request.contextPath}/">Status <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="map">Map</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="labs">Testing Locations</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="news">News</a>
                    </li>
                  </ul>
                </div>
          </nav>

      </div>

   </div>
        <div class="row" style="margin-top:10px">
            <div class="col-md-12">
            <h2 style="text-align:center">COVID-19 Testing Locations</h2>
            </div>
        </div>
        <c:forEach var="lab" items="${labs}">
            <div style="border:4px solid whitesmoke; margin-bottom:25px">
                <div class="row">
                <div class="col-md-12"><h4>${lab.name}</h4></div>
            </div>
        <div class="row">
            <div class="col-md-8">                
                <p>${lab.description}</p>
            </div>
             <div class="col-md-4">
                <p><b>Address:</b>${lab.physicalAddress.addressOne},${lab.physicalAddress.city},${lab.physicalAddress.region},${lab.physicalAddress.stateProvince},${lab.physicalAddress.postalCode},${lab.physicalAddress.country}</p>
                <p><b>Phone:</b>${lab.phone}</p>
            </div>
                       
       </div>
            <div class="row">
              <c:forEach var="schedule" items="${lab.schedules}">
                  <div style="width:100px; float: left; margin-left: 20px">
                                 
                      <b>Week Day ${schedule.weekDay}</b><br>
                      ${schedule.opensAt}<br>
                      ${schedule.closesAt}<br>
                  </div>
                           
              </c:forEach> 
            </div>    
            </div>
        </c:forEach>
   </div> 
                    
                     
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>   
  </body>
</html>