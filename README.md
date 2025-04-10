# Challenge project developed by Pablo

## How to Run it

The only requirement is to have Java JDK 11 or higher installed on your machine
This project uses gradle, but it's not necessary to have gradle installed because it can run with the gradle wrapper

**Steps to run the project:**

+ download or clone the repository 
+ Open the repo with any IDE of your preference to watch the code (Recommended Intellij IDEA or VS Code)
+ Go to UserApplication class and select Run UsersApplication.Run()
+ Once the application is up and running you can access the swagger UI page at http://localhost:9090/swagger-ui/index.html where the API is documented
+ This UI can be used to test the API by leveraging the "Try it out" feature or otherwise
+ Open Postman or your preferred tool to send requests to the application (A postman collection is provided in the folder 'postman collection' inside the project root folder)


 You can also run the project directly from command terminal
+ Open a terminal in the root location of the project and use the command ```./gradlew bootRun```

Happy testing!
