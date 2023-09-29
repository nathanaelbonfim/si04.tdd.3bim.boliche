# Boliche

Boliche is a Java game for scoring a game of bowling. It provides a Boliche class that can be used to keep track of the score for multiple players in a game of bowling.

## Project Organization
The Boliche project is organized as follows:
```
├── boliche
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── br
│       │   │       └── unipar
│       │   │           └── si
│       │   │               └── tdd
│       │   │                   └── boliche
│       │   │                       ├── Boliche.java
│       │   │                       ├── Main.java
│       │   │                       └── Player.java
│       │   └── resources
│       └── test
│           └── java
│               └── BolicheTest.java
├── LICENSE
└── README.md
```

The [`Boliche.java`](boliche/src/main/java/br/unipar/si/tdd/boliche/Boliche.java) file contains the implementation of the Boliche class, which provides methods for adding players, rolling the ball, and getting the score for each player.

The [BolicheTest.java](boliche/src/test/java/BolicheTest.java) file contains the unit tests for the Boliche class, which were developed using Test-Driven Development (TDD).


## Running the project

#### Requirements
- Java 11
- Maven 4.0.0
- Preferably, an IDE/Editor such as IntelliJ IDEA, Eclipse or Visual Studio Code

#### Instructions
- Clone the repository
- Open the project in your IDE/Editor
- Run the tests

## Contributing

If you find a bug or would like to suggest a new feature, please open an issue on the GitHub repository. Pull requests are also welcome.

## License

Boliche is licensed under the MIT License. See the `LICENSE` file for details.