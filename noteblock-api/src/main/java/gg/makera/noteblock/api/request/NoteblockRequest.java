package gg.makera.noteblock.api.request;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Map;

/**
 * Represents an API request
 */
public interface NoteblockRequest {

    @NotNull
    String getResource();

    default Map<String, Object> getBody() {
        return Collections.emptyMap();
    }
}
