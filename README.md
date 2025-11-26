# Echo Server

A simple Java echo server and client implementation supporting both TCP and UDP protocols.

## Project Structure

- `src/main/java/com/rashmit/johncrickett/`
  - `Tcp/` - TCP echo server and client
  - `Udp/` - UDP echo server and client
  - `Factories/` - Factory classes for server/client creation
  - `Interfaces/` - Common interfaces
  - `ServerDriver.java` - Main class to run the server
  - `ClientDriver.java` - Main class to run the client
- `src/test/java/com/rashmit/johncrickett/` - Unit tests
- `pom.xml` - Maven build file

## Requirements
- Java 21 (LTS)
- Maven

## Build

```sh
mvn clean install
```

## Run


### Run as JAR

#### Server
Run the server with port and protocol parameters:

```sh
java -cp target/echo-server-1.0-SNAPSHOT.jar com.rashmit.johncrickett.ServerDriver <portNumber> <protocol>
```
Example:
```sh
java -cp target/echo-server-1.0-SNAPSHOT.jar com.rashmit.johncrickett.ServerDriver 4445 tcp
```

#### Client
Run the client with host, port, and protocol parameters:

```sh
java -cp target/echo-server-1.0-SNAPSHOT.jar com.rashmit.johncrickett.ClientDriver <hostName> <portNumber> <protocol>
```
Example:
```sh
java -cp target/echo-server-1.0-SNAPSHOT.jar com.rashmit.johncrickett.ClientDriver localhost 4445 tcp
```

## Notes
- Update the parameters as needed for your environment.
- Make sure Java 21 is installed and set as your default Java version.

## License
MIT
