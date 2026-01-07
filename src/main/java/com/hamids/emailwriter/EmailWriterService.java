package com.hamids.emailwriter;

import org.springframework.stereotype.Service;

@Service
public class EmailWriterService {

    public String generateEmailReply(EmailRequest emailRequest) {
        // todos->
        // build prompt
        String prompt = buildPrompt(emailRequest);
        // prepare new json body
        String requestBody = String.format("""
                {
                    "contents": [
                      {
                        "parts": [
                          {
                            "text": "%s"
                          }
                        ]
                      }
                    ]
                }
                """, prompt);
        // Send request
        // extract response
        return "";
    }

    public String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate the Professional email reply for the below email:");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("Use a ").append(emailRequest.getTone()).append("tone.");
            // works as: Use a Professional tone.
        }
        prompt.append("Original Email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
