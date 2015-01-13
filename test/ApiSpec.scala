import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class APISpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "healthz" in new WithApplication{
      val req = route(FakeRequest(GET, "/healthz")).get

      status(req) must equalTo(OK)
      contentType(req) must beSome.which(_ == "text/html")
      contentAsString(req) must contain ("OK")
    }

    "statusz" in new WithApplication{
      val req = route(FakeRequest(GET, "/statusz")).get

      status(req) must equalTo(OK)
      contentType(req) must beSome.which(_ == "text/html")
      contentAsString(req) must contain ("Up")
    }
    "propertiesz" in new WithApplication {
      val req = route(FakeRequest(GET, "/propertiesz")).get

      status(req) must equalTo(OK)
      contentType(req) must beSome.which(_ == "text/html")
      contentAsString(req) must contain ("build version data unknown")
    }
  }
}
