<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Very Good Cruise Company</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/favicon1.ico">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pattaya&display=swap" rel="stylesheet">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous" defer></script>
    	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/index.css" />
	<style type="text/css">
		header {
		    background-image: linear-gradient(
		        rgba(34, 34, 34, 0.6),
		        rgba(34, 34, 34, 0.6)
		      ),
		      url(${pageContext.request.contextPath}/resources/images/cruiseship.jpg);
		    background-size: cover;
	  	}
	</style>
  </head>
 
  <body>
    <header>
      <nav class="container">
        <a href="${pageContext.request.contextPath}/">Very Good Cruise Company</a>
        <div id="rightContainer">
            <a href="${pageContext.request.contextPath}/login">Login</a>
            <a href="${pageContext.request.contextPath}/register">Register</a>
            <a href="http://localhost:8083/customers/list">Admin Page</a>
            <a href="http://localhost:8081/spring-crm-rest/api/customers">B2B</a>
        </div>
    </nav>


      <div class="header-container">
        <div class="header-container-inner">
          <h1>A Well Meaning And Non-Suspicious Cruise Company</h1>
          <p>The smarter, quicker, and faster way to travel the globe in style and comfort.</p>
          <a href="${pageContext.request.contextPath}/login" class="btn">Plan My Voyage!</a>
        </div>
      </div>
    </header>

    <div id="aboutUs" class="index-Container">
      <div id="quote">
        <h1>"Out of all of the companies in the world, this is certainly one of them" - Abraham Lincoln</h1>
        <p>Equal access is the name of the game for us here at Very Good Cruise Company. Our top team of highly proficient market researchers discovered a disproportionate amount of vacation cruises departing
          from strictly coastal cities. We didn't think this was quite fair, that is why our company seeks to provide high quality cruises to all those in landlocked locations so everyone can enjoy an ocean voyage on their trip from Arizona to Kentucky.
        </p>
      </div>

      <div class="indexSection">
        <img src="${pageContext.request.contextPath}/resources/images/24213.png" alt="All Vacations">
        <span>When you sign up for our services, you aren't just agreeing to give us your money, you are also acknowledging this company have the exclusive rights to your name and likeness in perpetuity from now until the end of time. You are also agreeing to rate us a full 5 stars on Yelp. And yes, a higher rating means more completely legal business for us. We're open for bookings on the weekends and during prime holiday seasons: our employee's wellbeing is the least of our concerns. We serve up bbq every Monday and Thursday through Labor Day. Please do not report us to the health inspector. Be cool.</span>
	 </div>

      <div class="indexSection">
      	<span>Our cruise travel company strives to exceed the needs and expectations of all its clients. When you choose us, we will always be that "go-to" travel company that stands out in a crowd. We keep it fresh and fun by providing deals that we've made up in the air. Take the guesswork out of travel by "following" us, as we'll be posting fun deals, giveaways and travel tips on our blog. We also plan to offer various memberships like golf, golf travel, tennis, and even an on-board radio. Travel with us today and experience new, unrivaled travel to meet your needs. All you have to do is keep an eye out for special deals and promotions that we will be offering on our blog, Facebook, Twitter and other social media sites. We look forward to serving you in the near future. Please feel free to contact us for more information</span>
	    <img src="${pageContext.request.contextPath}/resources/images/74534.jpg" alt="Cruise Ship">
      </div>
    </div>

  </body>
</html>






