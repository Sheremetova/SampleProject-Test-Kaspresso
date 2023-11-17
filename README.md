# UI Tests README

## Overview

This repository contains UI tests for the Android application. The tests are implemented using the Espresso framework for Android and the Kaspresso library to simplify test writing and maintenance.

## Project Structure

app
|-- src
|   |-- androidTest
|       |-- kotlin
|           |-- com.example.espressotest
|               |-- `LoginActivityTest`: a test class containing scenarios for the login activity (`LoginActivity`).
|               |-- `ListActivityTest`: a test class with scenarios for the list activity (`ListActivity`).
|               |-- screen
|                   |-- `LoginScreen`: PageObject class for interacting with elements on the Login screen in tests.
|                   |-- `ListScreen`: PageObject class for interacting with elements on the List screen in tests.

## Login Activity Test Scenarios

### 1. Login with Valid Credentials

This test verifies successful login into the application using valid email and password.

Upon successful login, a toast with a welcome message and the user's name appears.
However, it's important to note that checking time-sensitive elements like toasts through automated tests is not recommended due to potential instability.
If there's a strict need for testing toasts, consider the solution described [here](https://avito-tech.github.io/avito-android/test/Toast/).

### 2. Login with Invalid Password

This test ensures that entering a password with fewer than 6 characters disables the login button, preventing login.

### 3. Login with Invalid Email

This test checks that entering an invalid email address disables the login button, preventing login.
In the tested application, there are two validations for an email:
- if it is not empty
- if it matches the standard regular expression for emails.

However, in this automated test I do not check both options.
This choice is driven by the consideration that the validator should be tested at the unit test level.

### Using Parameters in Tests

In real-world projects, the use of test parameterization can be a valuable tool for handling large numbers of test cases.
However, with a small number of test examples, introducing parameterization with if-else constructions can overcomplicate the test structure, potentially impairing readability.

In this test project, I used parameterization to showcase its capabilities, but in practice it doesn't make sense to use with just 3 test examples.

## List Activity Test Scenarios

### 1. Check Users List

This test verifies the correct display of users on the list screen. It checks that:

- The total number of users is fixed at 20.
- Each user has a name and an image (verified for one element as an example).
- The last user's name and image are visible after scrolling.

Please note that the choice of these particular checks is based on the belief that:
- The number of users in the list is fixed.
- User names and images are not fixed.

In real-life scenarios, these circumstances may depend on the specific functionality type, and in case of any disputes, they should be discussed with the project manager.

## Running the Tests

1. Make sure your project is configured to use the Kaspresso and Espresso frameworks.
2. Open the desired test class (e.g., `LoginActivityTest` or `ListActivityTest`) in your development environment.
3. Run the tests using the tools provided by your development environment.

## Additional Resources

- [Testing toasts](https://avito-tech.github.io/avito-android/test/Toast/)
- [Espresso Documentation](https://developer.android.com/training/testing/espresso)
- [Kaspresso GitHub Repository](https://github.com/KasperskyLab/Kaspresso)
