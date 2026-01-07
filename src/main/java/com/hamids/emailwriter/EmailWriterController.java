package com.hamids.emailwriter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/email-writer")
@RequiredArgsConstructor
public class EmailWriterController {

    private final EmailWriterService emailWriterService;

    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest) {
        emailWriterService.generateEmailReply(emailRequest);
        return ResponseEntity.ok("Email generated successfully");
    }
}
