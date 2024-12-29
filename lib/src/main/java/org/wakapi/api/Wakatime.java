/*
 * This is intended to cover compatible Wakatime API in docs
 */

package org.wakapi.api;

import jakarta.json.JsonObject;
import jakarta.json.Json;

public class Wakatime extends AbstractAPI {

    public int getLeaders() {

        JsonObject response = Json.createObjectBuilder()
                .add("te", "st")
                .build();

        return 2;
    }
}
