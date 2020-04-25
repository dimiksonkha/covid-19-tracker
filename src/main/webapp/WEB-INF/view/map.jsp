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
    <style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 500px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
       .confo{
        color:orange;   
       }
       
       .recovo{
           color:green;
       }
       .detho{
           color:red;
       }
       </style>
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
                      <a class="nav-link" href="status">Status <span class="sr-only">(current)</span></a>
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
            <h2 style="text-align:center">COVID-19 Map</h2>
            </div>
        </div>
        
        <div class="row" style="margin-top:20px">
       <div id="map" class="col-md-12">
           
       </div>
       </div>
   </div>    
   
   
  
           
<script>
        
     
// Initialize and add the map
function initMap() {
  // The location of Uluru
  var centerPos = {lat: 23.685, lng: 90.356};
  var locs = [[]];
 <c:forEach var="location" items="${locations}">
        locs.push([${location.lat},${location.lng}, ${location.confirmed}, ${location.recovered}, ${location.deaths}]); 
 </c:forEach>
     
    
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 4, center: centerPos});
  // The marker, positioned at Bangladesh
  
 var marker1 = new google.maps.Marker({position: centerPos, map: map});
  
 var infowindow = new google.maps.InfoWindow();
 var marker, i;

    for (i = 0; i < locs.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locs[i][0], locs[i][1]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          var info = "<div>"+
                     "<b class='confo'>Total Confirmed:" + locs[i][2] + "<br>" +
                     "<b class='recovo'>Total Recovered:" + locs[i][3] + "<br>" +
                     "<b class='detho'>Total Deaths:" + locs[i][4] + "<br>" +
                     "</div>"
          infowindow.setContent(info);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
}

</script> 



    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_GctIqJWwa6_YkGqxqM9VujDFRMbjD0w&callback=initMap">
    </script>
    
  </body>
</html>
