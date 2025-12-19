package com.sujon.SpringBootRestAPI.controller;


import com.sujon.SpringBootRestAPI.dto.JavaIterationHelpRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/help")
@CrossOrigin(origins = "http://localhost:5173")
public class JavaIterationHelpController {
    @GetMapping("/java/iteration/{topic}")
    public JavaIterationHelpRecord getHelpOnJavaIterationStatement(@PathVariable String topic) {

        return switch (topic.toLowerCase()) {

            case "if" -> new  JavaIterationHelpRecord(
                    "if",
                    "if(condition) statement; else statement;",
                    """
                    Example:
                    int x = -100;
                    if (x > 0) {
                        System.out.println("Positive");
                    } else {
                        System.out.println("Non-positive");
                    }
                    """
            );

            case "switch" -> new JavaIterationHelpRecord(
                    "switch",
                    "switch(expression) { case constant: statement; break; }",
                    """
                    Example:
                    int day = 2;
                    switch (day) {
                        case 1:
                            System.out.println("Monday");
                            break;
                        case 2:
                            System.out.println("Tuesday");
                            break;
                    }
                    """
            );

            case "while" -> new JavaIterationHelpRecord(
                    "while",
                    "while(condition) statement;",
                    """
                    Example:
                    int i = 1;
                    while (i <= 5) {
                        System.out.println(i);
                        i++;
                    }
                    """
            );

            case "do-while" -> new JavaIterationHelpRecord(
                    "do-while",
                    "do { statement; } while(condition);",
                    """
                    Example:
                    int i = 1;
                    do {
                        System.out.println(i);
                        i++;
                    } while (i <= 5);
                    """
            );

            case "for" -> new JavaIterationHelpRecord(
                    "for",
                    "for(init; condition; iteration) statement;",
                    """
                    Example:
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(i);
                    }
                    """
            );

            default -> new JavaIterationHelpRecord(
                    "invalid",
                    "Invalid topic",
                    ""
            );
        };
    }
}