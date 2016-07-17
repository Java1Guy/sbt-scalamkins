// Account.scala

case class CloudWatchRoleArn(CloudWatchRoleArn:Object)
//   "CloudWatchRoleArn": { "Fn::GetAtt": ["CloudWatchRole", "Arn"] }

case class CFAccount(Properties:CloudWatchRoleArn) {
  val Type = "AWS::ApiGateway::Account"
  // "Properties": {
  //   "CloudWatchRoleArn": { "Fn::GetAtt": ["CloudWatchRole", "Arn"] }
  // }
}

case class MethodSetting()

case class StageProperties(
	CacheClusterEnabled: Boolean,
  CacheClusterSize: String,
  ClientCertificateId: String,
  DeploymentId: String,
  Description: String,
  MethodSettings: Array[ MethodSetting ],
  RestApiId: String,
  StageName: String,
  Variables: Object)

case class CFStage(Properties: StageProperties) {
  val Type = "AWS::ApiGateway::Stage"
}