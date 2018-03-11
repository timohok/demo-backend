package app.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.IOException;

@ApplicationScoped
@Named
public class ClientProvider {

    private final OkHttpClient client = new OkHttpClient();

    public String get(String url) throws IOException {

        String result = null;

        if (url != null && !url.isEmpty()) {

            Request request = new Request.Builder().url(url).build();

            try (Response response = client.newCall(request).execute()) {
                result = response.body().string();
            }
        }

        return result;
    }
}
