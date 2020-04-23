<%-- 
    Document   : index
    Created on : Apr 19, 2020, 7:01:45 PM
    Author     : dimiksonkha
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Covid-19 Tracker</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
        <style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
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
     <h3>My Google Maps Demo</h3>
    <!--The div element for the map -->
    <div id="map"></div>
    <script>
        
     
// Initialize and add the map
function initMap() {
  // The location of Uluru
  var centerPos = {lat: 23.685, lng: 90.356};
  var locs = [[]];;
 <c:forEach var="location" items="${locations}">
        locs.push([${location.lat},${location.lon}, ${location.confirmed}, ${location.recovered}, ${location.deaths}]); 
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
    <!--Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
    -->
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_GctIqJWwa6_YkGqxqM9VujDFRMbjD0w&callback=initMap">
    </script>
    
</body>
</html>
