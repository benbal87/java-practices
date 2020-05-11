// Write a class with the name: ReverseServer.
// It has only a main method in which you need to create a socket server which
// is listening on the 1921 port.
// The server waits for the clients request messages.
// In case of incoming message it should print out the given message reversely
// to the output stream.
// Take care about close the server and the listener as well.

package com.ben.javapractices.practices.litteexcercises.reverseserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {

    static String input = null;

    static String output = null;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1921);
            System.out.println("Server initiated!");

            Socket socket = serverSocket.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            input = (String) ois.readObject();

            output = new StringBuilder(input).reverse().toString();

            oos.writeObject(output);

            oos.close();
            ois.close();
            socket.close();
            serverSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
