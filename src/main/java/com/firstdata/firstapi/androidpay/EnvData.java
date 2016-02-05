package com.firstdata.firstapi.androidpay;

import java.util.HashMap;
import java.util.Map;

/**
 *  Prepare for support of multiple environments
 */
public class EnvData {

    private static Map<String, EnvProperties> envMap = new HashMap<>();

    private static class EnvPropertiesImpl implements EnvProperties {

        private String envName;
        private String url;
        private String apiKey;
        private String token;
        private String publicKey;
        private String publicKeyHash;
        private String apiSecret;

        public EnvPropertiesImpl(String envName, String url, String apiKey, String token,
                                 String publicKey, String publicKeyHash, String apiSecret) {
            this.envName = envName;
            this.url = url;
            this.apiKey = apiKey;
            this.token = token;
            this.publicKey = publicKey;
            this.publicKeyHash = publicKeyHash;
            this.apiSecret = apiSecret;
        }

        @Override
        public String getEnvName() {
            return envName;
        }

        @Override
        public String getUrl() {
            return url;
        }

        @Override
        public String getApiKey() {
            return apiKey;
        }

        @Override
        public String getToken() {
            return token;
        }

        @Override
        public String getPublicKey() {
            return publicKey;
        }

        @Override
        public String getPublicKeyHash() {
            return publicKeyHash;
        }

        @Override
        public String getApiSecret() {
            return apiSecret;
        }
    }

    static {
        envMap.put("CERT", new EnvPropertiesImpl(
                        "CERT",
                        "https://api-cert.payeezy.com/v1/transactions",
                        "y6pWAJNyJyjGv66IsVuWnklkKUPFbb0a",
                        "fdoa-a480ce8951daa73262734cf102641994c1e55e7cdf4c02b6",
                        "BAcuCtcmGXqVrVUUmyFbsAoC4+MZ80V5AVmm4rm/tj+7lV3KxYAe9xOWASR13nJZf9CxLenkBAdMz8I5EKefCPk=",
                        "9FpDBkszQZrwrFjdh9agu2FLIpNYcyn6OjsfomDoxMg=",
                        "86fbae7030253af3cd15faef2a1f4b67353e41fb6799f576b5093ae52901e6f7"
                )
        );
    }

    public static EnvProperties getProperties(String envName) {
        return envMap.get(envName);
    }
}
