# FileUtility
Created 4 End points for
1. For showing All the file Name.
2. For Downloading the file
3. For Copying the file
4. For deletion of the file.

For a large data file downloading, I am using StreamingResponseBody, which is useful for asynchronous request processing.
In this approach the application writes the data directly to the response OutputStream without holding up the Servlet Container thread. 
Add I Used Proper Exception Handling as Spring boot suggests. I did use these annotations.
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
 For Exception Handling and forException format. I created a class "ExceptionFormat" .  

And For logging purposes I used Spring AOP.  In loggin I am showing some attribute of request only. 
I also implement Swagger for documentation. 


For testing, Please add a directory path in the property file of spring boot resource. and put some files into that directory.
For my convenience, I added  E:/Tuts/Files/

And For logging purposes I used Spring AOP.  In loggin I am showing some attribute of request. 
I also implemented Swagger api for documentation
