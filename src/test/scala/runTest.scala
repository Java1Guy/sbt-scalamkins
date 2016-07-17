
object runTest {

	import _root_.com.peopledesigned.MyLambdaApp
	val c = classOf[MyLambdaApp]
  com.peopledesigned.ReadAnnotations.decode(c)

	// import _root_._
	val mma = classOf[MultipleMethodsApp]
  com.peopledesigned.ReadAnnotations.decode(mma)

}
