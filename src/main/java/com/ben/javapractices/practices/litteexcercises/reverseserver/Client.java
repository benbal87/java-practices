// Write a class with the name: ReverseServer.
// It has only a main method in which you need to create a socket server which is listening on the 1921 port.
// The server waits for the clients request messages.
// In case of incoming message it should print out the given message reversely to the output stream.
// Take care about close the server and the listener as well.

package com.ben.javapractices.practices.litteexcercises.reverseserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static String message = "Message.";

    public static String incomingMessage = null;

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Socket clientSocket = new Socket("localHost", 1921);

        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

        oos.writeObject(message);

        incomingMessage = (String) ois.readObject();

        System.out.println(incomingMessage);

        clientSocket.close();
    }

}
