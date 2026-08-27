# Eventify – Event Management REST API

## Project Overview

Eventify is a backend REST API for an Event Management System developed using Spring Boot. The application manages events, attendees, organizers, registrations, feedback, and notifications.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- REST API
- Spring Security
- Basic Authentication
- Postman
- Maven

## Main Features

- Create, view, update, and delete events
- Manage event information
- Manage attendees and organizers
- Event registration
- Event feedback and ratings
- Notifications
- Basic Authentication for API security

## REST API Operations

- GET – Fetch events
- POST – Create an event
- PUT – Update an event
- DELETE – Delete an event

## API Testing

I tested the REST APIs using Postman.

## Database

MySQL is used as the database. The project contains tables for:

- Attendee
- Organizer
- Admin
- Event
- Registration
- Feedback
- Notification

## How to Run

1. Clone the repository.
2. Import the project into Eclipse or Spring Tool Suite.
3. Configure MySQL.
4. Create the Eventify database and tables.
5. Update the database configuration in `application.properties`.
6. Run the Spring Boot application.
7. Test the APIs using Postman.

## Authentication

The application uses Basic Authentication for securing REST APIs.

## Author

Achal Vikas Hivarkar
