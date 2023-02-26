package io.github.jonathan.sequence.cache;

import io.quarkus.cache.CacheResult;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class SequenceService {

    private final static int DEFAULT_VALUE = 3;

    @CacheResult(cacheName = "sequenceValue")
    public Integer calculatingSequence(Integer n){
        int sequence[] = new int[n + 4];
        sequence[0] = 0;
        sequence[1] = 1;
        sequence[2] = 0;
        sequence[3] = 1;
        for (int i = 4; i <= n; i++) {
            sequence[i] = sequence[i - 4] + sequence[i - 3];
        }
        return sequence[n];
    }
}
