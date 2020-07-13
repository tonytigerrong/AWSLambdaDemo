package com.serverless.lambda.student.function;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.event.S3EventNotification;

/**
 * Lambda function that simply prints "Hello World" if the input String is not provided,
 * otherwise, print "Hello " with the provided input String.
 */
public class HelloWorld implements RequestHandler<Request, Object> {
  

	@Override
	public Object handleRequest(Request request, Context context) {
		LambdaLogger logger = context.getLogger();
		Student s = new Student(); 
		s.setId(1l);
		s.setName("David");
		logger.log(s.getName());
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDBMapper mapper = new DynamoDBMapper(client);
		s = mapper.load(Student.class,request.getId());
		return s;
	}
}