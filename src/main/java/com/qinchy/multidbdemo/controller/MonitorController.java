package com.qinchy.multidbdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    private Logger logger = LoggerFactory.getLogger(MonitorController.class);

    @PostMapping("/receive")
    public boolean receive(@RequestBody Map<String,Object> message){
        logger.error(message.toString());
        return true;
    }
}
