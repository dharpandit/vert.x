package io.vertx;

import io.vertx.core.Vertx;

public class helloWorld {
    public static void main(String[] args) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>");
        htmlBuilder.append("<head><title>Hello World!</title></head>");
        htmlBuilder.append("<body>" +
                "<h1>Hello, from Vert.x</h1>" +
                "<p>Nice to see your first program in <b>Vert.x</b></p><" +
                "/body>");
        htmlBuilder.append("</html>");
        String html = htmlBuilder.toString();

        // Create an HTTP server which simply returns "Hello World!" to each request.
        Vertx.vertx()
                .createHttpServer()
                .requestHandler(req -> req.response().end( html ))
                .listen(8080, handler -> {
                    if (handler.succeeded()) {
                        System.out.println("http://localhost:8080/");
                    } else {
                        System.err.println("Failed to listen on port 8080");
                    }
                });

    }
}
