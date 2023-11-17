# UI Tests README

## Overview

This repository contains UI tests for the Android application. The tests are implemented using the Espresso framework for Android and the Kaspresso library to simplify test writing and maintenance.

## Project Structure

- `LoginActivityTest`: a test class containing scenarios for the login activity (`LoginActivity`).
- `ListActivityTest`: a test class with scenarios for the list activity (`ListActivity`).
- `LoginScreen`: PageObject class for interacting with elements on the Login screen in tests.
- `ListScreen`: PageObject class for interacting with elements on the List screen in tests.

## Login Activity Test Scenarios

### 1. Login with Valid Credentials

This test verifies successful login into the application using valid email and password.

### 2. Login with Invalid Password

This test ensures that entering a password with fewer than 6 characters disables the login button, preventing login.

### 3. Login with Invalid Email

This test checks that entering an invalid email address disables the login button, preventing login.

### Using Parameters in Tests

In real-world projects, the use of test parameterization can be a valuable tool for handling large numbers of test cases.
However, with a small number of test examples, introducing parameterization with if-else constructions can overcomplicate the test structure, potentially impairing readability.

In this test project, I used parameterization to showcase its capabilities, but in practice it doesn't make sense to use with just 3 test examples.

## List Activity Test Scenarios

### 1. Check Users List

This test verifies the correct display of users on the list screen. It checks the total number of users and ensures that the last user's name and image are visible after scrolling.

## Running the Tests

1. Make sure your project is configured to use the Kaspresso and Espresso frameworks.
2. Open the desired test class (e.g., `LoginActivityTest` or `ListActivityTest`) in your development environment.
3. Run the tests using the tools provided by your development environment.

## Additional Resources

- [Espresso Documentation](https://developer.android.com/training/testing/espresso)
- [Kaspresso GitHub Repository](https://github.com/KasperskyLab/Kaspresso)
