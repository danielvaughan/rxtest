package org.codetaming.examples.services;

import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Subscriber;

import java.util.UUID;

@Service
public class StreamService {

    public Observable<String> stream() {
        Observable<String> observable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext(UUID.randomUUID().toString());
                        sub.onCompleted();
                    }
                }
        );
        return observable;
    }
}
