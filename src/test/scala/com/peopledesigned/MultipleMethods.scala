// MultipleMethods.scala
// Chalice Equivalent:
// @app.route('/resource/{value}', methods=['PUT'])
// def put_test(value):
//     return {"value": value}
// @app.route('/myview', methods=['POST', 'PUT'])
// def myview():
//     pass

// TEST the test
// val la = new MultipleMethodsApp
// val bos = new java.io.ByteArrayOutputStream
// la.put_test(new java.io.ByteArrayInputStream("{\"resource\":\"test\"}".getBytes), bos)
// bos
// res4: java.io.ByteArrayOutputStream = {"value":"test"}
// val bos2 = new java.io.ByteArrayOutputStream
// la.myview(new java.io.ByteArrayInputStream("".getBytes), bos2)
// bos2
// res4: java.io.ByteArrayOutputStream = 

import java.io.{InputStream, OutputStream, PrintStream}
import com.peopledesigned.LambdaFunction

case class Resource(resource: String)
case class Value(value: String)

case class MultipleMethodsApp() {
	// final val helloWorldModel:String = classOf[HelloWorld].toString

	val scalaMapper = {
       import com.fasterxml.jackson.databind.ObjectMapper
       import com.fasterxml.jackson.module.scala.DefaultScalaModule
       new ObjectMapper().registerModule(new DefaultScalaModule)
  }

	// TODO figure out how to use class string
	// TODO Error Handling
	// def state_of_city(name):
	//    try:
	//        return {'state': CITIES_TO_STATE[name]}
	//    except KeyError:
	//        raise BadRequestError("Unknown city '%s', valid choices are: %s" % (
	//            name, ', '.join(CITIES_TO_STATE.keys())))

  @LambdaFunction(path="/resource/{value}", inputModel="Resource", outputModel="Value", methods=Array("PUT"))
  def put_test(input: InputStream, output: OutputStream): Unit = {
  	// #    # '/hello/james' -> {"hello": "james"}
    val inputStr = scalaMapper.readValue(input, classOf[Resource])
		val result = new Value(inputStr.resource)
    val resultStr = scalaMapper.writeValueAsString(result)
    output.write(resultStr.getBytes("UTF-8"))
  }

  @LambdaFunction(path="/myview", methods=Array("POST", "PUT"))
  def myview(input: InputStream, output: OutputStream): Unit = {
  }
}
