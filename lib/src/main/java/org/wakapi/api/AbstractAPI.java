/*
 * This is abstract api which defines the common methods that's done in every api call.
 */

package org.wakapi.api;

import java.net.http.*;
import java.net.URI;
import java.util.Base64;

abstract class AbstractAPI {

    public AbstractAPI() {
    }

    public static HttpRequest buildHttpRequest(String uri, String authVal) {

        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .header("Authorization", authVal)
                .build();
    }

    public static String buildAuthVal(String apiKey) {
        // as apears in the api docs
        StringBuilder authVal = new StringBuilder("Basic ");
        // followd by Base64 of the apiKey
        byte[] apiKeyAsByteArray = apiKey.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedAPIKey = encoder.encodeToString(apiKeyAsByteArray);
        // return the authVal
        return authVal.append(encodedAPIKey).toString();
    }

}
