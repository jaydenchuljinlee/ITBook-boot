$(function() {
	//ckEditor
	CKEDITOR.config.language = 'ko';
	CKEDITOR.replace('seminarContent', {
		filebrowserImageUploadUrl: "upload.do"});
	
	//썸네일 미리보기
	$("#thumbnail").change(handleImgFileSelect);
	
	function handleImgFileSelect(e) {
		var files = e.target.files;
		var filesArr = Array.prototype.slice.call(files);
		
		filesArr.forEach(function(selFile) {
			
			if (!selFile.type.match("image.*")) {
				alert("이미지 파일을 올려주세요!");
				return;
			}
			
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$("#eventThumbnail").attr("src", e.target.result);
			}
			
			reader.readAsDataURL(selFile);
		});
	}
	
	////////////////Google map
	var geocoder = new google.maps.Geocoder;	//좌표 주소
	var map ;	//구글맵 들어갈 변수
	var infowindow;	//정보창
	var clcikInfowindow = new google.maps.InfoWindow();
	var place;	//위치정보들어간 변수
	function initialize() {
	  var mapOptions = {
	    center: {lat: 37.250943, lng: 127.028344},
	    zoom: 13,
	    scrollwheel: true,
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	  };
	  map = new google.maps.Map(document.getElementById('googleMap'),
	    mapOptions);
	
	  var input = /** @type {HTMLInputElement} */(
	      document.getElementById('pac-input'));
	
	  // Create the autocomplete helper, and associate it with
	  // an HTML text input box.
	  var autocomplete = new google.maps.places.Autocomplete(input);
	  autocomplete.bindTo('bounds', map);
	
	  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
	
	  infowindow = new google.maps.InfoWindow();
	  clickInfowindow = new google.maps.InfoWindow();
	  
	  var marker = new google.maps.Marker({
	    map: map,
	  });
	  google.maps.event.addListener(marker, 'click', function(e) {
	    infowindow.open(map, marker);
	  });
	
	  // Get the full place details when the user selects a place from the
	  // list of suggestions.
	  google.maps.event.addListener(autocomplete, 'place_changed', function() {
	    infowindow.close();
	    place = autocomplete.getPlace();
		    if (!place.geometry) {
		      return;
		    }

		    if (place.geometry.viewport) {
		    	map.fitBounds(place.geometry.viewport);
		    } else {
		      map.setCenter(place.geometry.location);
		      map.setZoom(17);
		    }
	
	    // Set the position of the marker using the place ID and location.
	    marker.setPlace(/** @type {!google.maps.Place} */ ({
	      placeId: place.place_id,
	      location: place.geometry.location
	    }));
	    marker.setVisible(true);
	    
	    
		infowindow.setContent('<div><strong>' + place.name + '</strong><br>' +
	        'Place ID: ' + place.place_id + '<br>' +
	        place.formatted_address + '</div>');
	    infowindow.open(map, marker);
	  });
	  
	  var clickMarker = new google.maps.Marker({
		    map: map
	  });
	  
	  google.maps.event.addListener(map, 'click', function(event) {	//맵을 클릭한 경우
		  map.panTo(event.latLng); //클릭한 위치로 이동
		  
		  
		  geocoder.geocode({'location': map.getCenter()}, function(results, status) {
			  if (status === 'OK') {
	   		    	if (results[0]) {
	   		    		clcikInfowindow.close();
	   		    		clickMarker.setPlace(/** @type {!google.maps.Place} */ ({
		  				  placeId: results[0].place_id,
		  				  location: event.latLng}))
		  				  clcikInfowindow.setContent('<div><strong>' + results[0].formatted_address + '</strong><br>' +
		  				        'Place ID: ' + results[0].place_id + '</div>');
		  				clcikInfowindow.open(map, clickMarker);  
	   		    	} else {
	   	   		        window.alert('No results found');
	   	   		    }
	   		    	
	   		    }else {
	   		    	alert("오류 다른곳을 클릭해주세요")
	   		    }
	   		  }); 
		 
			  
			  
	  });
	}//initialize 끝
	
	// Run the initialize function when the window has finished loading.
	google.maps.event.addDomListener(window, 'load', initialize);
	
	$("#map_btn").click(function() {
   		if($("#googleMap").is(":visible")){
    		$("#googleMap").slideUp();
   		}else {
    		$("#googleMap").slideDown();
   		}
   	})
   
   	$("#confirm").click(function() {
   		geocoder.geocode({'location': map.getCenter()}, function(results, status) {
   		    if (status === 'OK') {
   		      if (results[0]) {
   		    	$("#location").val(results[0].formatted_address);
   		    	alert(results[0].address_components[0].long_name);
   		    	
   		    	alert(results[0].address_components[1].long_name);
   		    	
   		    	alert(results[0].address_components[2].long_name);
   		    	
   		    	alert(results[0].address_components[3].long_name);
   		      } else {
   		        window.alert('No results found');
   		      }
   		    } else {
   		      window.alert('Geocoder failed due to: ' + status);
   		    }
   		  });
   	}); 
});