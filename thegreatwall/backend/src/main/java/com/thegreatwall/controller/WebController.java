package com.thegreatwall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // SPA를 위한 포워딩 설정 - 경로에 확장자가 없는 모든 요청을 index.html로 포워딩
    @GetMapping(value = {
        "/{path:[^\\.]*}",
        "/thegreatwall/{path:[^\\.]*}",
        "/thegreatwall/auth/{path:[^\\.]*}",
        "/auth/{path:[^\\.]*}"
    })
    public String forward() {
        return "forward:/index.html";
    }
    
    // 루트 경로 처리
    @GetMapping("/")
    public String root() {
        return "forward:/index.html";
    }
    
    // WildFly 컨텍스트 루트 경로 처리
    @GetMapping("/thegreatwall")
    public String contextRoot() {
        return "forward:/index.html";
    }
}