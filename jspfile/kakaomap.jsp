<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "jsp.RestaurantDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
	html,
	body{
		width: 100%;
		height: 100%;
	}
</style>

<title>Insert title here</title>
</head>

<body>
	<%
		float latitude = Float.parseFloat(request.getParameter("latitude"));
		float longitude = Float.parseFloat(request.getParameter("longitude"));
		
		RestaurantDAO dao = RestaurantDAO.getInstance();
		int number = dao.findRestaurants(latitude, longitude);
		
	%>

	<div id="map" style="width:100%;height:100%;"></div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0cc283eba2401a8d3c5fd6c79744fad5"></script>
	<script type="text/javascript">
	var map
	
	var name;
	var openedWindow = null, selectedMarker = null;
	function makeMap(latitude, longitude) {
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
		map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		var imageSrc = 'http://the4456.iptime.org:8080/jsp/marker/Marker_Inside_Azure.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(50, 50), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
	    var markerPosition  = new kakao.maps.LatLng(latitude, longitude);
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition,
		    image: markerImage // 마커이미지 설정 
		});
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
		// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
		var iwContent = '<div>현재위치</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		    content : iwContent,
		    removable : iwRemoveable
		});
		kakao.maps.event.addListener(marker, 'click', function() {
	        // 클릭된 마커가 없고, click 마커가 클릭된 마커가 아니면
	        // 마커의 이미지를 클릭 이미지로 변경합니다
	        if (!selectedMarker || selectedMarker !== marker) {
	        	// 이미 열려있는 infowindow가 있으면 닫는다.
	        	if(openedWindow){
	        		openedWindow.close();
	        	}
	            // 현재 클릭된 마커의 infowindow를 연다
	            infowindow.open(map, marker);
	            openedWindow = infowindow;
	        }
	        // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
	        selectedMarker = marker;
	    });
		
		var numberOfRestaurants = <%=number%>;
		
		var i;
		<%
			int num = 0;
			for(num = 0; num< number; num++){%>
			latitude = <%=dao.getLatitude(num)%>;
			longitude = <%=dao.getLongitude(num)%>;
			name = "<%=dao.getName(num)%>";
			loadRestaurant(latitude,longitude,name);
			<%
			}
			dao.restaurants.clear();
		%>
	} 
	
	function sendMessage(msg){
		window.android.setMessage(msg);
	}
	function loadRestaurant(lati, longi, name){

		var icon = 'http://the4456.iptime.org:8080/jsp/marker/Marker_Inside_Chartreuse.png', // 마커이미지의 주소입니다    
		imageSize = new kakao.maps.Size(50, 50), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	    var markerImage = new kakao.maps.MarkerImage(icon, imageSize, imageOption)
	    var markerPosition  = new kakao.maps.LatLng(lati, longi);
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition,
		    image: markerImage // 마커이미지 설정 
		});
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		
		// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
		var iwContent = '<div>'+name+'</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
		    content : iwContent,
		    removable : iwRemoveable
		});
		    
		//마커의 이벤트리스너
		kakao.maps.event.addListener(marker, 'click', function() {
	        // 클릭된 마커가 없거나 click 마커가 클릭된 마커가 아니면
	        // 마커의 in
	        if (!selectedMarker || selectedMarker !== marker) {
	            // 이미 열려있는 infowindow가 있으면 닫는다.
	        	if(openedWindow){
	        		openedWindow.close();
	        	}
	            // 현재 클릭된 마커의 infowindow를 연다
	            infowindow.open(map, marker);
	            openedWindow = infowindow;
	         // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
		        selectedMarker = marker;
	        }else{
	        	var urlString = encodeURI("app://"+name);
	        	window.location.href = urlString;
	        }
	        
	    });
	}
	
	var latitude = <%=latitude%>;
	var longitude = <%=longitude%>;
	makeMap(latitude,longitude);
	
	
	</script>
	
</body>

</html>