package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    // greet() waisa hi hai - isliye purana test bina change ke pass hoga
    public static String greet() {
        return "Hello from CI pipeline 1";
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", exchange -> {
            String response = greet();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Server running on port " + port);
    }
}
