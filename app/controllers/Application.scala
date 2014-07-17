package controllers


import scala.concurrent.duration._
import org.joda.time.LocalDateTime
import play.api._
import play.api.libs.concurrent.Promise
import play.api.libs.iteratee.Enumerator
import play.api.libs.iteratee.Iteratee
import play.api.mvc._
import com.sun.management.OperatingSystemMXBean

object Application extends Controller {

  import scala.concurrent.ExecutionContext.Implicits._
  
  def index = Action { implicit request =>
    Ok(views.html.index("Your new application is ready."))
  }

  def showTime = WebSocket.using[String] {
    implicit request =>
      ingoreIn(time)
  }
  
  def showSystemInfo = WebSocket.using[String]{
    implicit request =>
      ingoreIn(systemInfo)
  }
 
  
  
  private def ingoreIn[T](f: => T,timeout:FiniteDuration = 3 seconds):(Iteratee[T,_],Enumerator[T]) = {
    import scala.concurrent.duration._
      import scala.concurrent.ExecutionContext.Implicits._
      val in = Iteratee.ignore[T]
      val out = Enumerator.repeatM(Promise.timeout(f, timeout))
      (in,out)
  }
  private def time:String = {
    LocalDateTime.now().toString()
  }

  private def systemInfo:String = {
    import info.SystemInfo
    ""+SystemInfo.getCpuCount()
  }
  
}