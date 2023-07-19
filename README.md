# Examples drools

A simple demo java application with drools as a BRM.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Drools Rules](#drools-rules)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Introduction

This project is a simple REST API built using Spring Boot that allows users to manage products. It incorporates Drools to apply rules when adding new products. This is merely for demonstration purposes, so do not use as production grade solution.

## Features

- Fetch a list of products
- Add a new product to the list
- Apply Drools rules when adding a product

## Getting Started

### Prerequisites

Before running the project, ensure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Gradle build tool (optional)

### Installation

1. Clone the repository:

```sh
git clone https://github.com/gvanastasov/example-drools.git
```

2. Build the project using Gradle:

```sh
./gradlew build
```

## Usage
To run the application, use the following command:

```sh
./gradlew bootRun
```

Once the application is running, you can interact with the REST API using your preferred HTTP client (e.g., cURL, Postman etc.). Fetch the list of products via the GET endpoint, then try adding a new product with `available: false` and notice how
the rule engine would kick in and change that to `true`.

## Endpoints

- `GET api/products`: Retrieve a list of all products.
- `POST api/products`: Add a new product to the list.

## Drools Rules

The project includes a simple Drools rule that sets the `available` property of a new product to `true` by default.
Rule DRL file: [Dummy Rule](app/src/main/resources/rules/RuleA.drl)


## Contributing

Contributions to this project are welcome. If you find any issues or have new feature ideas, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [./LICENSE](LICENSE)

## Acknowledgments

This project uses the Spring Boot framework and the Drools rule engine.