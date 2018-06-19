<html>
	<head>
		<title>Loose Search</title>
		
		<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
		
		<script type="text/javascript">
		
			function doSearch() {
				// make request to server
				$.getJSON("looseSearch.do", {CHARS: $("#searchBox").val()}, function(data) {
					$("#results").text('');
					for (var index in data) {
						$("#results").append("<p>" + data[index].title + "</p>");						
					}
				});
			}
		
		</script>
	</head>
	<body>
		<h1>Loose Search</h1>
		
		<input id="searchBox" type="text" onKeyUp="doSearch();" />
		
		<div id="results">
			Results will appear here...
		</div>
		
	</body>
</html>