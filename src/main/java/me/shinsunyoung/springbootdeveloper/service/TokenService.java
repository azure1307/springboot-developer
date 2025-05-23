package me.shinsunyoung.springbootdeveloper.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.config.jwt.TokenProvider;
import me.shinsunyoung.springbootdeveloper.domain.User;

@RequiredArgsConstructor
@Service
public class TokenService {
	private final TokenProvider tokenProvider;
	private final RefreshTokenService refreshTokenService;
	private final UserService userService;

	public String createNewAccessToken(String refreshToken) {
		//토큰 유효성검사에 실패하면 예외 발생
		if (!tokenProvider.validToken(refreshToken)) {
			throw new IllegalArgumentException("Unexpected token");
		}

		Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
		User user = userService.findById(userId);

		return tokenProvider.generateToken(user, Duration.ofHours(2));
	}
}
