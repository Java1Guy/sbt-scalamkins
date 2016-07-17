// RootReturnsJson.scala
// TEST the test
// val la = new RootReturnsJsonApp
// val bos = new java.io.ByteArrayOutputStream
// la.index(new java.io.ByteArrayInputStream("".getBytes), bos)
// bos
// res4: java.io.ByteArrayOutputStream = {"hello":"world"}

import java.io.{InputStream, OutputStream, PrintStream}
import com.peopledesigned.LambdaFunction

case class HelloWorld(hello: String)

case class RootReturnsJsonApp() {
	final val helloWorldModel:String = classOf[HelloWorld].toString

	val scalaMapper = {
       import com.fasterxml.jackson.databind.ObjectMapper
       import com.fasterxml.jackson.module.scala.DefaultScalaModule
       new ObjectMapper().registerModule(new DefaultScalaModule)
  }

	// TODO figure out how to use class string
  @LambdaFunction(path="/", outputModel="HelloWorld")
  def index(input: InputStream, output: OutputStream): Unit = {
		val result = new HelloWorld("world")
    val resultStr = scalaMapper.writeValueAsString(result)
    output.write(resultStr.getBytes("UTF-8"))
  }
}