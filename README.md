== Google Cloud Client Library for Java - Cloud Storage example ==

This is a runnable example based on the authentication and storage snippets from https://github.com/GoogleCloudPlatform/gcloud-java with typos removed.

To run this example:

mvn package  
mvn dependency:copy-dependencies  
java -cp target/gcloud-example-1.0-SNAPSHOT.jar:target/dependency/*:. com.mycompany.app.App path/to/private_key.json bucket-name
