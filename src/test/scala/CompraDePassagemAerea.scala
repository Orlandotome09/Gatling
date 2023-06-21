package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.util.Random

class CompraDePassagemAerea extends Simulation{

  val httpConf = http.baseUrl(url = "https://www.blazedemo.com")
    .header(name= "Content-Type", value= "application/json")


  def postAirTicketPurchase() = {
      exec(http("Post Select destiny")
          .post("/reserve.php")
          .body(ElFileBody("bodies/postDestiny.json")).asJson
          .check(status.is(200))
          )
    
  
      exec(http("Post Select Flights ")
          .post("/purchase.php")
          .body(ElFileBody("bodies/postFlights.json")).asJson
          .check(status.is(200))
          )
    
 
      exec(http("Post flight confirmation")
          .post("/confirmation.php")
          .body(ElFileBody("bodies/postConfirmation.json")).asJson
          .check(status.is(200))
          )
    
  }

  val scn = scenario("Select Destiny")
    .exec(postAirTicketPurchase()
    )

  setUp(
    scn.inject(
      nothingFor(1 seconds),
      atOnceUsers(250),
    ).protocols(httpConf.inferHtmlResources())
  )
}
