import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.test.WithApplication
import info.SystemInfo

class SystemSpec extends Specification {

  "systemInfo" should {
    "return cpu info" in new WithApplication{
      println(SystemInfo.cpus)
      
      println(SystemInfo.cpu_status)
    }
  }
}