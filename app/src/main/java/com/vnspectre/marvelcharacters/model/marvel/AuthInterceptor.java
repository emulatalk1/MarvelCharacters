package com.vnspectre.marvelcharacters.model.marvel;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Spectre on 11/28/17.
 */

public class AuthInterceptor implements Interceptor {
    private static final String TIMESTAMP_KEY = "ts";
    private static final String HASH_KEY = "hash";
    private static final String API_KEY = "apikey";

    private final String publicKey;
    private final String privateKey;
    private final com.vnspectre.marvelcharacters.model.marvel.TimeProvider timeProvider;
    private final AuthHashGenerator authHashGenerator = new AuthHashGenerator();

    public AuthInterceptor(String publicKey, String privateKey, TimeProvider timeProvider) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.timeProvider = timeProvider;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String timestamp = String.valueOf(timeProvider.currentTimeMillis());
        String hash = null;
        hash = authHashGenerator.generateHash(timestamp, publicKey, privateKey);
        Request request = chain.request();
        HttpUrl url = request.url()
                .newBuilder()
                .addQueryParameter(TIMESTAMP_KEY, timestamp)
                .addQueryParameter(API_KEY, publicKey)
                .addQueryParameter(HASH_KEY, hash)
                .build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
