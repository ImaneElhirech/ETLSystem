package com.services;


	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.bo.User;


	@Service
	@Transactional
	public interface UserService {
		
		
		@Transactional(readOnly=true)
		User   getUserById(Long pId);

	}

