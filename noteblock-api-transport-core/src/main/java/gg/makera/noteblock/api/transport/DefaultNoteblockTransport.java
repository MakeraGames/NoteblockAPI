package gg.makera.noteblock.api.transport;

import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public final class DefaultNoteblockTransport implements NoteblockTransport {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public CompletableFuture<ResponseData> sendRequest(@NotNull Request request) {
//        System.out.println("Sending request " + request + "...");

        HttpRequest.Builder httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(request.getUrl()));
        request.getHeaders().forEach(httpRequest::header);

        String body = request.getBody();
        if (body != null)
            httpRequest.POST(HttpRequest.BodyPublishers.ofString(body));

        return httpClient.sendAsync(httpRequest.build(), HttpResponse.BodyHandlers.ofString())
                .thenApply(this::processHttpResponse);
    }

    private ResponseData processHttpResponse(HttpResponse<String> response) {
        int code = response.statusCode();
        String body = response.body();

//        System.out.println("Response " + code + ": " + body);
        return new ResponseData(code, body);
    }

    @Override
    public void close() {
    }
}
