<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Покази датчиків</title>

    <style>
        html, body {
            height: 100%;
            padding-bottom: 40px;
        }

        html {
            display: table;
            margin: auto;
        }

        body {
            display: table-cell;
            vertical-align: top;
        }

        #gmap-dropdown{
            with:300px;
            height:450px;
        }
    </style>
</head>
<body>
<h1>Карта</h1>
<div id="gmap-dropdown"></div>

<h1>Покази датчиків</h1>
    <table class="table table-bordered table-striped" id="data">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Температура, C</th>
            <th>Вологість, %</th>
            <th>Пора року</th>
            <th>СН сенсора температури</th>
            <th>СН сенсора вологості</th>
            <th>GPS-координати</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sensors}" var="sensor">
            <tr>
                <td>
                    <c:out value="${sensor.getId()}"/>
                </td>
                <td>
                    <c:out value="${sensor.getTemperature()}"/>
                </td>
                <td>
                <c:out value="${sensor.getHumidity()}"/>
            </td>
            <td>
                <c:out value="${sensor.getSeason()}"/>
            </td>
            <td>
                <c:out value="${sensor.getTemperature_sensor()}"/>
            </td>
            <td>
                <c:out value="${sensor. getHumidity_sensor()}"/>
            </td>
            <td>
                <c:out value="${sensor. getGps()}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </table>


    <script src="https://maps.google.com/maps/api/js?sensor=false&libraries=geometry&v=3.22&key=AIzaSyCwJzEM2xl8tTxRXKk72EdsIhzW8G-_HbU">
    </script>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="http://maplacejs.com/dist/maplace.min.js"></script>
    <script type="text/javascript">
        $(function() {
            var LocsA = []
            var table = document.getElementById("data");
            for (var i = 1, row; row = table.rows[i]; i++) {
                gps = row.cells[6].innerHTML.split(", ")
                temperature = "<h3>Температура:" + row.cells[1].innerHTML+ " C</h3>"
                humidity = "<h3>Вологість:" + row.cells[2].innerHTML+ "%</h3>"
                season = "<p>Пора року:" + row.cells[3].innerHTML+ "</p>"
                temperature_sensor = "<p>СН сенсора температури:" + row.cells[4].innerHTML+ "</p>"
                humidity_sensor = "<p>СН сенсора вологості:" + row.cells[5].innerHTML+ "</p>"
                LocsA[i-1] = {
                    lat: gps[0],
                    lon: gps[1],
                    title: row.cells[4].innerHTML,
                    html: [
                        temperature,
                        humidity,
                        season,
                        temperature_sensor,
                        humidity_sensor
                    ].join(''),
                    zoom: 32,
                    icon: 'http://maps.google.com/mapfiles/markerC.png'
                }
            }


            new Maplace({
                locations: LocsA,
                map_div: '#gmap-dropdown',
                controls_title: 'Виберіть датчик:',
                listeners: {
                    click: function(map, event) {
                        alert('Вже обраний!');
                    }
                }
            }).Load();


        });

    </script>
</body>
</html>
