package com.example.demointerview.service.imp;

import com.example.demointerview.service.MessageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevMessage implements MessageService {
    @Override
    public String getMessage() {
        return "Hello from Development!";
    }
}
