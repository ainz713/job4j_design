package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while ((str = in.readLine()) != null && !str.isEmpty()) {
                        if (str.contains("Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write("Hello\r\n".getBytes());
                            break;
                        }
                        if (str.contains("Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write("Exit\r\n".getBytes());
                            server.close();
                            break;
                        }
                        if (str.contains("What")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write("What\r\n".getBytes());
                            break;
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
                }
            }
        }
    }
}
