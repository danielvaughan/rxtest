package org.codetaming.examples.controllers;

import org.codetaming.examples.services.StreamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReactiveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveController.class);

    @Autowired
    private StreamService streamService;

    @RequestMapping("/stream")
    public DeferredResult<String> stream() {
        DeferredResult<String> result = new DeferredResult<>();
        streamService.stream().subscribe(uuid -> result.setResult(uuid), error -> result.setErrorResult(error));
        return result;
    }

}
