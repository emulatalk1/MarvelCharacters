package com.vnspectre.marvelcharacters.data.network.marvelapi;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Spectre on 11/28/17.
 */

public class AuthHashGenerator {
    String generateHash(String timestamp, String publicKey, String privateKey) {
        try {
            String value = timestamp + privateKey + publicKey;
            MessageDigest md5Encoder = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5Encoder.digest(value.getBytes());

            StringBuilder md5 = new StringBuilder();
            for (int i = 0; i < md5Bytes.length; ++i) {
                md5.append(Integer.toHexString((md5Bytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return md5.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
