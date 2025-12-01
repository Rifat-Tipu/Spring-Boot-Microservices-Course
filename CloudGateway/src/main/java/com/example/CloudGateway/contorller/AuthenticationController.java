
package com.example.CloudGateway.contorller;
import com.example.CloudGateway.model.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @GetMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @AuthenticationPrincipal OidcUser oidcUser,
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient authorizedClient
    ) {
        // ✅ Handle possible null refresh token safely
        String refreshToken = null;
        if (authorizedClient.getRefreshToken() != null) {
            refreshToken = authorizedClient.getRefreshToken().getTokenValue();
        }

        // ✅ Build response
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .userId(oidcUser.getEmail())
                .accessToken(authorizedClient.getAccessToken().getTokenValue())
                .refreshToken(refreshToken) // safe even if null
                .expiresAt(authorizedClient.getAccessToken().getExpiresAt().getEpochSecond())
                .authorityList(
                        oidcUser.getAuthorities()
                                .stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList())
                )
                .build();

        // ✅ Return JSON response
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}

