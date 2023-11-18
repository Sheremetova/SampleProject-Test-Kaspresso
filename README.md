# UI Tests README

## Overview

This repository contains UI tests for the Android application.
The tests are implemented using the Kaspresso framework, which serves as a wrapper for Espresso and UI Automator.
Kaspresso facilitates the use of both libraries and provides built-in support for the Page Object pattern.

## Project Structure

```
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

```

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

## Running the Tests via Android Studio

- To run all tests, right-click on the `app > src > androidTest` folder and choose 'Run All tests'.
- Alternatively, you can run a specific test from the corresponding class (e.g., `LoginActivityTest` or `ListActivityTest`).

## Viewing Logs

- To view Kaspresso logs within Android Studio, navigate to the 'Logcat' tab and filter by `package:mine KASPRESSO`.
- Alternatively, run the following command in the command line: `adb logcat "KASPRESSO:I *:S"`

## Possible Improvements and Future Development

1. **Screenshot Capture and/or Screen Recording:**
This can aid in identifying errors in case of test failures.

2. **Custom Logging:**
While the current test steps provide sufficient information, adding custom logcat messages for more detailed logging can be added.
This can be achieved using commands like `testLogger.i("your message")`.

3. **Custom Assertion Timeouts:**
While the default timeout in Kaspresso is 10 seconds, some scenarios might require longer waiting periods.
Adjusting timeouts can be done in tests where necessary.

4. **Offline Login Scenario:**
Consider testing the application's behavior when attempting to log in with no internet connection.
As the tested application does not handle this situation, this scenario has not been implemented in the current tests.

## Additional Resources

- [Testing toasts](https://avito-tech.github.io/avito-android/test/Toast/)
- [Espresso Documentation](https://developer.android.com/training/testing/espresso)
- [Kaspresso GitHub Repository](https://github.com/KasperskyLab/Kaspresso)
