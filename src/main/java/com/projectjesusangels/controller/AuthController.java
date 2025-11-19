package com.projectjesusangels.controller;

import com.projectjesusangels.dto.AuthRequest;
import com.projectjesusangels.service.SupabaseAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SupabaseAuthService supabaseAuthService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(supabaseAuthService.signUp(request));
    }
}
