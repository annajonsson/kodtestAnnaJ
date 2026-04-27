## Overview

This is my simple REST API built with spring boot and Java that reads data from a csv file. It is for getting an entire list of persons and also a limit of persons.

## How to run

1. Clone the project.
2. Start the project by typing:

```sh
  mvn spring-boot:run
```

in the terminal.

3. Open in browser or Postman:

```sh
   http://localhost:8080/api/data
```

## CSV file

The CSV file consists of different persons. It includes their name, age, email and an id.
This is an example of what the CSV file consists of:

```sh
id;name;age;email
1;Alice;28;alice@example.com
2;Bea;12;bea@example.com
3;Ceasar;56;ceasar@example.com
```

## Endpoints

There is two endpoints for this API, the first being:

#### Get all persons

```sh
GET /api/data
```

This will get the entire list of persons.
And the second endoint is:

#### Get limit of persons

```sh
GET /api/data?limit=10
```

That is for when you only want to get a limit of persons, so the integer at the end is what determines how many persons you will receive.

## Response example

For the Get-request:

```sh
GET /api/data?limit=2
```

This is the JSON-response you will receive:

```sh
[
    {
        "id": 1,
        "name": "Alice",
        "age": 28,
        "email": "alice@example.com"
    },
    {
        "id": 2,
        "name": "Bea",
        "age": 12,
        "email": "bea@example.com"
    }
]
```
