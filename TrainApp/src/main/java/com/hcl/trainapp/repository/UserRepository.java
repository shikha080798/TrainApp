package com.hcl.trainapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trainapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// public User findByUserId(Long userId);
	// public User findByUserIdAndPassword(int userId,String password);

	public User findByUserName(String userName);

	public User findByUserId(Long userId);

}