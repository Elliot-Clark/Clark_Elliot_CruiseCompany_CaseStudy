<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Display</title>
	
	<!-- reference our style sheet -->
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon1.ico">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/index.css" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/display.css" />
	<script src="${pageContext.request.contextPath}/resources/scripts/display.js"></script>	  

</head>

<body>

      <nav class="container">
        <a href="${pageContext.request.contextPath}/">Very Good Cruise Company</a>
        <a href="${pageContext.request.contextPath}/admin">Admin</a>

        <div id="rightContainer">
            <span>${username}</span>
            <a href="${pageContext.request.contextPath}/">Logout</a>
        </div>
    </nav>



    <section>
		<div class="container" id="display">
			<table>
				<tr>
					<th>ID</th>
					<th>Destination</th>
					<th>Leaving From</th>
					<th>Duration (days)</th>
					<th>Price</th>
					<th>Join</th>
				</tr>
		
				<!-- loop over and print our customers -->
				<c:forEach var="tempCruise" items="${cruises}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="addLink" value="/addCruise">
						<c:param name="tempCruiseId" value="${tempCruise.id}" />
					</c:url>					

					<tr>
						<td id="id"> ${tempCruise.id} </td>
						<td> ${tempCruise.destination} </td>
						<td> ${tempCruise.leavingFrom} </td>
			
						<td> ${tempCruise.duration} </td>
						<td>$${tempCruise.price} </td>
												
						<td><a href="${addLink}"><button
						onclick="if (!(confirm('Are you sure you want to add this Cruise to your cart?'))) return false"
						>Join Cruise</button></a></td>
						
					</tr>
				
				</c:forEach>
			</table>
			
			<table>
				<tr>
					<th>ID</th>
					<th>Destination</th>
					<th>Leaving From</th>
					<th>Duration (days)</th>
					<th>Price</th>
					<th>Remove</th>
				</tr>
		
				<!-- loop over and print our customers -->
				<c:forEach var="customerSelectedCruises" items="${customerCruises}" varStatus="loopIndex">	
				
				<c:url var="removeLink" value="/removeCruise">
					<c:param name="customerSelectedCruisesId" value="${loopIndex.index}" />
				</c:url>				

					<tr>
						<td id="id"> ${customerSelectedCruises.id} </td>
						<td> ${customerSelectedCruises.destination} </td>
						<td> ${customerSelectedCruises.leavingFrom} </td>
			
						<td> ${customerSelectedCruises.duration} </td>
						<td>$${customerSelectedCruises.price} </td>
						<td><a href="${removeLink}"><button
						id="removeButton"
						onclick="if (!(confirm('Are you sure you want to remove this Cruise from your cart?'))) return false"
						>Remove</button></a></td>		
						
					</tr>
				
				</c:forEach>
							<h1>Available Cruises</h1>
							
			</table>
                	<h1>Your Selected Cruises</h1>

        </div>
       </div>
      </section>
      
</body>

</html>


