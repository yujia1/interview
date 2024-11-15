package com.example.demointerview.service.imp;

import com.example.demointerview.service.MessageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "Hello from Production!";
    }

    public static void main(String[] args) {
        String text = "world";

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
        }
    }
}
