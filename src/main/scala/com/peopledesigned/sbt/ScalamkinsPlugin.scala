package com.peopledesigned.sbt

import sbt._

import scala.util.{Failure, Success}

object Scalamkins extends AutoPlugin {
  object autoImport {
    // val createLambda = taskKey[Map[String, LambdaARN]]("Create a new AWS Lambda function from the current project")
    // val deploy = taskKey[Map[String, String/*LambdaARN*/]]("Package and deploy the current project to an AWS Lambda")
	}

  // override lazy val projectSettings = Seq(
  //   deploy := doDeploy(
      // region = region.value,
      // jar = sbtassembly.AssemblyKeys.assembly.value,
      // s3Bucket = s3Bucket.value,
      // s3KeyPrefix = s3KeyPrefix.?.value,
      // lambdaName = lambdaName.value,
      // handlerName = handlerName.value,
      // lambdaHandlers = lambdaHandlers.value
    // )
    // ,
    // createLambda := doCreateLambda(
    //   region = region.value,
    //   jar = sbtassembly.AssemblyKeys.assembly.value,
    //   s3Bucket = s3Bucket.value,
    //   s3KeyPrefix = s3KeyPrefix.?.value,
    //   lambdaName = lambdaName.value,
    //   handlerName = handlerName.value,
    //   lambdaHandlers = lambdaHandlers.value,
    //   roleArn = roleArn.value,
    //   timeout = awsLambdaTimeout.value,
    //   memory = awsLambdaMemory.value
    // )
	// )


  // private def doDeploy(
  	// region: Option[String], 
  	// jar: File, 
  	// s3Bucket: Option[String], 
  	// s3KeyPrefix: Option[String], 
  	// lambdaName: Option[String], 
    //  handlerName: Option[String], 
    // lambdaHandlers: Seq[(String, String)]
  // ): Unit
  // Map[String, LambdaARN] 
  // = {
    // val resolvedRegion = resolveRegion(region)
    // val resolvedBucketId = resolveBucketId(s3Bucket)
    // val resolvedS3KeyPrefix = resolveS3KeyPrefix(s3KeyPrefix)
    // val resolvedLambdaHandlers = resolveLambdaHandlers(lambdaName, handlerName, lambdaHandlers)

    // AwsS3.pushJarToS3(jar, resolvedBucketId, resolvedS3KeyPrefix) match {
    //   case Success(s3Key) => (for (resolvedLambdaName <- resolvedLambdaHandlers.keys) yield {
    //     AwsLambda.updateLambda(resolvedRegion, resolvedLambdaName, resolvedBucketId, s3Key) match {
    //       case Success(updateFunctionCodeResult) =>
    //         resolvedLambdaName.value -> LambdaARN(updateFunctionCodeResult.getFunctionArn)
    //       case Failure(exception) =>
    //         sys.error(s"Error updating lambda: ${exception.getLocalizedMessage}\n${exception.getStackTraceString}")
    //     }
    //   }).toMap
    //   case Failure(exception) =>
    //     sys.error(s"Error uploading jar to S3 lambda: ${exception.getLocalizedMessage}\n${exception.getStackTraceString}")
    // }
  // }

  // private def doCreateLambda(region: Option[String], jar: File, s3Bucket: Option[String], s3KeyPrefix: Option[String], lambdaName: Option[String], 
  //     handlerName: Option[String], lambdaHandlers: Seq[(String, String)], roleArn: Option[String], timeout: Option[Int], memory: Option[Int]): Map[String, LambdaARN] = {
  //   val resolvedRegion = resolveRegion(region)
  //   val resolvedLambdaHandlers = resolveLambdaHandlers(lambdaName, handlerName, lambdaHandlers)
  //   val resolvedRoleName = resolveRoleARN(roleArn)
  //   val resolvedBucketId = resolveBucketId(s3Bucket)
  //   val resolvedS3KeyPrefix = resolveS3KeyPrefix(s3KeyPrefix)
  //   val resolvedTimeout = resolveTimeout(timeout)
  //   val resolvedMemory = resolveMemory(memory)

  //   AwsS3.pushJarToS3(jar, resolvedBucketId, resolvedS3KeyPrefix) match {
  //     case Success(s3Key) =>
  //       for ((resolvedLambdaName, resolvedHandlerName) <- resolvedLambdaHandlers) yield {
  //         AwsLambda.createLambda(resolvedRegion, jar, resolvedLambdaName, resolvedHandlerName, resolvedRoleName, resolvedBucketId, resolvedTimeout, resolvedMemory) match {
  //           case Success(createFunctionCodeResult) =>
  //             resolvedLambdaName.value -> LambdaARN(createFunctionCodeResult.getFunctionArn)
  //           case Failure(exception) =>
  //             sys.error(s"Failed to create lambda function: ${exception.getLocalizedMessage}\n${exception.getStackTraceString}")
  //         }
  //       }
  //     case Failure(exception) =>
  //       sys.error(s"Error upload jar to S3 lambda: ${exception.getLocalizedMessage}\n${exception.getStackTraceString}")
  //   }
  // }

}