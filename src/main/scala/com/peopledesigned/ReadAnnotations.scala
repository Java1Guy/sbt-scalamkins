package com.peopledesigned

object ReadAnnotations {

  def decode(lambdaApp:Class[_]) = {
  	val ms = lambdaApp.getMethods()
		ms.foreach(m => m.getDeclaredAnnotations().foreach(a => println(m + " " + a)))
		// var ann = ms(2).getDeclaredAnnotations()
		// ann(0)
		// res7: java.lang.annotation.Annotation = @com.peopledesigned.LambdaFunction(inputModel=I, outputModel=O, path=/greeting)
	// val methods = classOf[com.peopledesigned.MyLabmdaApp].getInterfaces flatMap {intf =>
 //    intf.getMethods filter {_.getAnnotation(classOf[com.peopledesigned.LambdaFunction]) != null}

  }

}
