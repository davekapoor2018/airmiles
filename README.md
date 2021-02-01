# airmiles
This is the backend spring boot project

Requirements
Step 1: Build the back-end
Design a REST web service with a method that returns the text that is passed to it.
Design a few unit tests to verify your application. You may use any unit test framework.
Step 2: Connect your front and back ends
How would you create a web form that has a text box, and a ‘Done’ button. When ‘Done’ is clicked make AJAX call, passing the entered text to the web service you created in the previous step. Display the response from the web service call below the text box on the form.
How would you extend your tests to verify new components? 
Step 3: Bring in the database
How would you extend your web service to add a method to store text passed from the form into the database using design patterns where appropriate? In addition to saving the text, store the date and time when the data was saved.
Step 4: Include the user info
How would you extend the form to capture the user name and a list of all the submissions by user? Can you add another method to the service to return all text submissions and display them at the bottom of the page? 
Step 5: Replying to text
How would you extend your solution from previous challenge to allow “responding” to already posted texts and display responses, indented, below the related text entry? 
As always, extend your tests.
Step 6: Capture more data
How would you capture user’s location (user enters the city) on the form. For every post, include city, city’s latitude and longitude and current temperature. How would you display this information on the form, next to each post? 
Step 7: Secure your application with https
This should be easy!


Running the application locally
'''mvn spring-boot:run'''

