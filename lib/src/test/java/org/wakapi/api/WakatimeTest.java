/*
 * This is test for wakatime compatible API
 */

package org.wakapi.api;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WakatimeTest {

    @Test
    void getLeaders() {
        assertEquals(2, getLeaders());
    }

}
