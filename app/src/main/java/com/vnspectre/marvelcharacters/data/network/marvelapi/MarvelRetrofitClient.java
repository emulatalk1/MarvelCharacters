package com.vnspectre.marvelcharacters.data.network.marvelapi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Spectre on 11/27/17.
 */

public class MarvelRetrofitClient {

    private static MarvelRetrofitClient singleton;
    private final String publicKey;
    private final String privateKey;
    private final Retrofit retrofit;

    MarvelRetrofitClient(String publicKey, String privateKey, Retrofit retrofit) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.retrofit = retrofit;
    }

    public static MarvelRetrofitClient with(String publicKey, String privateKey) {
        if (singleton == null) {
            singleton = new Builder(publicKey, privateKey).build();
        }
        return singleton;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private static class Builder {

        private static final String MARVEL_API_BASE_URL = "http://gateway.marvel.com/v1/public/";
        private final String privateKey;
        private final String publicKey;
        private Retrofit retrofit;
        private String baseUrl = MARVEL_API_BASE_URL;

        public Builder(String publicKey, String privateKey) {
            if (publicKey == null) {
                throw new IllegalArgumentException("publicKey must not be null.");
            }

            if (privateKey == null) {
                throw new IllegalArgumentException("privateKey must not be null.");
            }

            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public Builder baseUrl(String url) {
            this.baseUrl = url;
            return this;
        }

        public Builder retrofit(Retrofit retrofit) {
            if (retrofit == null) {
                throw new IllegalArgumentException("retrofit must not be null.");
            }
            this.retrofit = retrofit;
            return this;
        }

        public MarvelRetrofitClient build() {
            if (retrofit == null) {
                retrofit = buildRetrofit();
            }

            return new MarvelRetrofitClient(publicKey, privateKey, retrofit);
        }

        private Retrofit buildRetrofit() {
            OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(new AuthInterceptor(publicKey, privateKey));

            OkHttpClient client = builder.build();

            return new Retrofit.Builder().baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
}
