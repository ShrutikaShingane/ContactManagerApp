# Contact Manager Console Application

## Project Overview

Contact Manager is a Java console-based application that helps users manage contact information. It allows users to add, view, update, and delete contacts using an ArrayList and stores contact details in a CSV file for future use.

## Features

* Add new contacts
* View all saved contacts
* Update existing contacts
* Delete contacts
* Store contact details in a CSV file
* Automatically load saved contacts when the application starts
* Handle invalid menu choices and contact numbers

## Technologies Used

* Java
* Eclipse IDE
* ArrayList
* File Handling
* CSV (Comma-Separated Values)

## Concepts Practiced

* Object-Oriented Programming (OOP)
* Classes and objects
* Encapsulation
* Collections Framework
* CRUD operations
* File reading and writing
* Exception handling

## Contact Details

Each contact contains:

* Name
* Phone number
* Email address

## Project Structure

```text
ContactManagerApp/
└── src/
    └── contactmanager/
        ├── Contact.java
        ├── ContactManager.java
        └── ContactManagerApp.java
```

## How to Run

1. Open Eclipse IDE.
2. Create or import the ContactManagerApp Java project.
3. Ensure all three Java files are inside the contactmanager package.
4. Open ContactManagerApp.java.
5. Run it as Java Application.
6. Use the console menu to manage contacts.

## Menu Options

1. Add Contact
2. View Contacts
3. Update Contact
4. Delete Contact
5. Exit

## Data Storage

Contact details are stored in a file named `contacts.csv`. The application saves changes when contacts are added, updated, or deleted and loads saved contacts when it starts again.

## Learning Outcome

This project demonstrates how to build a menu-driven Java application using ArrayList, implement CRUD operations, handle exceptions, and persist data using CSV file handling.

## Note

This is an educational project intended for learning Java programming. It is not a cloud-based contact management service.