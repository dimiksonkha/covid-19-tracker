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
                      <a class="nav-link" href="">Status <span class="sr-only">(current)</span></a>
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
     <h2 style="text-align:center">COVID-19 Status</h2>
     </div>
   </div>
   <div class="row" style="margin-top:20px">
     <div class="col-md-1">

     </div>
     <div class="col-md-3">
       <div class="card text-white bg-warning mb-3" style="max-width: 18rem;">
         <div class="card-header">New Confirmed</div>
         <div class="card-body">
       <h1 class="card-title">${newConfirmed}</h1>
         </div>
       </div>
    </div>
    <div class="col-md-3">
      <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
      <div class="card-header">New Recovered</div>
      <div class="card-body">
        <h1 class="card-title">${newRecovered}</h1>
      </div>
      </div>
     </div>

     <div class="col-md-3">
       <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
       <div class="card-header">New Deaths</div>
       <div class="card-body">
         <h1 class="card-title">${newDeaths}</h1>
       </div>
       </div>

    </div>

    <div class="col-md-2">

    </div>
    </div>
    <div class="row">
      <div class="col-md-1">

      </div>
      <div class="col-md-3">
        <div class="card text-white bg-warning mb-3" style="max-width: 18rem;">
          <div class="card-header">Total Confirmed</div>
          <div class="card-body">
            <h1 class="card-title">${totalConfirmed}</h1>
          </div>
        </div>
     </div>
     <div class="col-md-3">
       <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
       <div class="card-header">Total Recovered</div>
       <div class="card-body">
         <h1 class="card-title">${totalRecovered}</h1>
       </div>
       </div>
      </div>

      <div class="col-md-3">
        <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
        <div class="card-header">Total Deaths</div>
        <div class="card-body">
          <h1 class="card-title">${totalDeaths}</h1>
        </div>
        </div>

     </div>

     <div class="col-md-2">

     </div>
     </div>
        <hr>
     <div class="row" style="margin-top:10px">
       <div class="col-md-12">
       <h5 style="text-align:center">Country wise Status</h5>
       </div>
     </div>
        <hr>

     <div class="row">
         <div class="col-md-1">
             
         </div> 
         
        <div class="col-md-10">
          <table id="data-table"class="table table-sm">
              <thead class="table-light">
              <tr>
                <th>Country</th>
                <th>Confirmed</th>
                <th>Recovered</th>
                <th>Deaths</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="status" items="${covidStatus}">
                <tr>
                    <td class="bg-light">${status.country}</td>
                <td class="bg-light">${status.confirmed}</td>
                <td class="bg-light">${status.recovered}</td>
                <td class="bg-light">${status.deaths}</td>
                <td class="bg-light"><button class="btn btn-primary">Details</button></td>
               </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="col-md-1">
             
         </div> 
    </div>



    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>
