/*
 * test for AbstractAPI.java
*/

package org.wakapi.api;

import org.apache.commons.math3.analysis.function.Abs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

class AbstractAPITest {
    @Test
    void buildAuthValTest() {
        String apiKey = "Some Random String of char";
        String expectied_AuthVal = "Basic U29tZSBSYW5kb20gU3RyaW5nIG9mIGNoYXI=";
        assertEquals(expectied_AuthVal, AbstractAPI.buildAuthVal(apiKey));
    }

    @Test
    void buildHttpRequest() {
        // setup initial condition
        String url = "https://example.com/api/test/me";
        String authVal = "authentication value";
        HttpRequest request = AbstractAPI.buildHttpRequest(url, authVal);

        // setup expeted values for uri test
        URI uri = request.uri();
        String expectedScheme = "https";
        String expectedHost = "example.com";
        String expectedPath = "/api/test/me";
        int expectedPort = 443;

        // setup expeted values for header test
        int expectedNumOfHeaders = 1;
        int expectedNumOfAuthHeaderValue = 1;
        String expectedAuthHeaderValue = authVal;

        // test uri
        assertEquals(expectedScheme, uri.getScheme());
        assertEquals(expectedHost, uri.getHost());
        assertEquals(expectedPath, uri.getPath());
        assertEquals(expectedPort, uri.getPort());

        // test headers
        //
        HttpHeaders headers = request.headers();
        List<String> headersList = headers.allValues("Authorization");
        Map<String, List<String>> allHeaders = headers.map();
        assertEquals(expectedNumOfHeaders, allHeaders.size());
        assertEquals(expectedNumOfAuthHeaderValue, headersList.size());
        assertEquals(expectedAuthHeaderValue, headersList.get(0));

    }

}
