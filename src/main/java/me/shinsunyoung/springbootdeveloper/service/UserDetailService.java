package me.shinsunyoung.springbootdeveloper.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

	private final UserRepository userRepository;

	//사용자 이름으로 사용자의 정보를 가져오는 메서드
	@Override
	public UserDetails loadUserByUsername(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new IllegalArgumentException((email)));
	}
}
