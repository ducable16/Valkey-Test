package com;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class CacheRequest {
    String key;
    String value;
}
