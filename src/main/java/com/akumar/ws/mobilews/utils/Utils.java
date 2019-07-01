package com.akumar.ws.mobilews.utils;

import java.util.UUID;
import org.springframework.stereotype.Service;


@Service
public class Utils {

    public String getUserId() {
        return UUID.randomUUID().toString();
    }
}
