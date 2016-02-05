package com.firstdata.firstapi.androidpay;

/**
 * First Data constants related to a specific environment
 */
public interface EnvProperties {
    String getEnvName();
    String getUrl();
    String getApiKey();
    String getToken();
    String getPublicKey();
    String getPublicKeyHash();
    String getApiSecret();
}
