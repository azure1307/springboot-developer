package me.shinsunyoung.springbootdeveloper.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.domain.RefreshToken;
import me.shinsunyoung.springbootdeveloper.repository.RefreshTokenRepository;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
	private final RefreshTokenRepository refreshTokenRepository;

	public RefreshToken findByRefreshToken(@CookieValue("refresh_token") String refreshToken) {
		return refreshTokenRepository.findByRefreshToken(refreshToken)
			.orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
	}
}
