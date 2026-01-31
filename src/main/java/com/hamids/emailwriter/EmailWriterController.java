package com.hamids.emailwriter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/email-writer")
@RequiredArgsConstructor
public class EmailWriterController {

    private final EmailWriterService emailWriterService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        String response = emailWriterService.generateEmailReply(emailRequest);
        return ResponseEntity.ok(response);
    }
}
