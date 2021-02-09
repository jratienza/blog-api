package xyz.mynt.blogapi;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String getNextUserId() {
        return UUID.randomUUID().toString();
    }
}
