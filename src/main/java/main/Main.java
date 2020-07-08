package main;

import com.sun.net.httpserver.HttpServer;
import controller.Guestbook;
import controller.Static;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);

        server.createContext("/guestbook", new Guestbook());
        server.createContext("/static", new Static());
        server.setExecutor(null);
        server.start();
    }
}
