# File Server

This is a simple file server application that allows clients to perform basic operations on files, such as creating, retrieving, and deleting files. The server and client applications are implemented in Java.

## Client

The client package contains the following classes:

- `Main`: This is the main class of the client application. It prompts the user to enter an action (1 for getting a file, 2 for creating a file, 3 for deleting a file), and based on the input, it interacts with the server to perform the requested action.

To run the client application, execute the `Main` class.

## Server

The server package contains the following classes:

- `Main`: This is the main class of the server application. It listens for incoming client connections and handles client requests. The server supports the following commands:
  - `PUT`: Creates a new file on the server with the provided file name and content.
  - `GET`: Retrieves the content of a file from the server.
  - `DELETE`: Deletes a file from the server.
  - `EXIT`: Exits the server application.

To run the server application, execute the `Main` class.

## Communication Protocol

The client and server communicate using a simple text-based protocol based on HTTP. The client sends commands to the server, and the server responds with status codes and optional data.

- Command format: `<command> <file_name>`
- Status codes:
  - `200`: Success
  - `403`: Forbidden (e.g., file already exists when creating a file)
  - `404`: Not found (e.g., file does not exist when retrieving or deleting a file)
- Data format:
  - When retrieving a file (`GET` command), the server responds with the content of the file.

## Usage

1. Start the server application by executing the `Main` class in the server package.
2. Start the client application by executing the `Main` class in the client package.
3. The client will prompt you to enter an action:
   - Enter `1` to get a file from the server.
   - Enter `2` to create a file on the server.
   - Enter `3` to delete a file from the server.
   - Enter `EXIT` to exit the client application.
4. Depending on the selected action, the client will prompt you to enter a file name or file content.
5. The client will communicate with the server to perform the requested action and display the server's response.

Note: The server stores the files in the `./src/server/data/` directory relative to the server application's location. Ensure that the directory exists and is writable by the server application.

## Dependencies

The client and server applications have the following dependencies:

- Java 8 or above

## License

This file server application is open-source and distributed under the [MIT License](LICENSE). Feel free to modify and use it according to your needs.
