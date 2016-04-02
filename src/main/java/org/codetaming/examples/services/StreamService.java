package org.codetaming.examples.services;

import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StreamService {

    private final List<String> uuids;

    public StreamService()
    {
        uuids = new ArrayList<>();
        for (int i=0; i<1000; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
    }

    public Observable<String> stream () throws InterruptedException {
        Thread.sleep(1000);
        return Observable.from(uuids);
    }
}
