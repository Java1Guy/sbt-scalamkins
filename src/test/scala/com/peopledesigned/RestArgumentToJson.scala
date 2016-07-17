// RestArgumentToJson.scala
// Chalice Equivalent:
// CITIES_TO_STATE = {
//     'seattle': 'WA',
//     'portland': 'OR',
// }
// @app.route('/cities/{city}')
// def state_of_city(name):
//     return {'state': CITIES_TO_STATE[name]}

// TEST the test
// val la = new RestArgumentToJsonApp
// val bos = new java.io.ByteArrayOutputStream
// la.state_of_city(new java.io.ByteArrayInputStream("{\"city\":\"seattle\"}".getBytes), bos)
// bos
// res4: java.io.ByteArrayOutputStream = {"state":"WA"}

import java.io.{InputStream, OutputStream, PrintStream}
import com.peopledesigned.LambdaFunction

case class City(city: String)
case class State(state: String)

case class RestArgumentToJsonApp() {
	val CITIES_TO_STATE = Map(
	    "seattle" -> "WA",
	    "portland" -> "OR"
	)
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

  @LambdaFunction(path="/city/{city}", inputModel="City", outputModel="State")
  def state_of_city(input: InputStream, output: OutputStream): Unit = {
  	// #    # '/hello/james' -> {"hello": "james"}
    val city = scalaMapper.readValue(input, classOf[City])
		val result = new State(CITIES_TO_STATE(city.city))
    val resultStr = scalaMapper.writeValueAsString(result)
    output.write(resultStr.getBytes("UTF-8"))
  }
}