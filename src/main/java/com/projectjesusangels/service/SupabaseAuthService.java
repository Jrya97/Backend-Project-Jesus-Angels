package com.projectjesusangels.service;

import com.projectjesusangels.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class SupabaseAuthService {

    private final RestClient restClient;
    private final String supabaseKey;

    public SupabaseAuthService(@Value("${supabase.url}") String supabaseUrl,
                               @Value("${supabase.key}") String supabaseKey) {
        this.supabaseKey = supabaseKey;
        this.restClient = RestClient.builder()
                .baseUrl(supabaseUrl)
                .build();
    }

    public Map<String, Object> signUp(AuthRequest request) {
        return restClient.post()
                .uri("/auth/v1/signup")
                .header("apikey", supabaseKey)
                .header("Authorization", "Bearer " + supabaseKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(Map.class);
    }
}
