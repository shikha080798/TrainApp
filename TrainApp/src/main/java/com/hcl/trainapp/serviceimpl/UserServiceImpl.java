package com.hcl.trainapp.serviceimpl;

import java.util.Optional;
import java.util.Random;

 

import javax.transaction.Transactional;

 

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

 

import com.hcl.trainapp.controller.UserController;
import com.hcl.trainapp.exception.InvalidCredentialsException;
import com.hcl.trainapp.exception.UserIdNotFoundException;
import com.hcl.trainapp.model.User;
import com.hcl.trainapp.repository.UserRepository;
import com.hcl.trainapp.service.UserService;
	@Service
	public class UserServiceImpl implements UserService {
	    @Autowired
	    UserRepository userRepository;
	    @Autowired
	    JavaMailSender javaMailSender;
	    static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	 


	    @Override
	    @Transactional
	    public ResponseEntity<?> userLogin(String userName) {
	        User user = userRepository.findByUserName(userName);
	        if (!ObjectUtils.isEmpty(user)) {
	            Random rand = new Random();
	            Long otp = rand.nextLong();
	            user.setOtp(Math.abs(otp));
	            User newUser = userRepository.save(user);
	            SimpleMailMessage msg = new SimpleMailMessage();
	            msg.setFrom("mucharla.navee98@gmail.com");
	            msg.setTo(user.getMailId());
	            user.setOtp(user.getOtp());
	            msg.setSubject("OTP For Login Purpose");
	            msg.setText("this is otp" + otp);
	            javaMailSender.send(msg);
	            return new ResponseEntity<Long>(newUser.getUserId(), HttpStatus.OK);
	        } else {
	            throw new UserIdNotFoundException("User does not Exist in");
	        }

	 

	    }

	 

	    @Override
	    public ResponseEntity<String> otp(Long userId, long otp) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        if (!userOptional.isPresent())
	            throw new UserIdNotFoundException("User detials not Exist please enter correct detials");
	        logger.info(otp+"     "+userOptional.get().getOtp());
	        if (otp == userOptional.get().getOtp())
	            return new ResponseEntity<String>("Login Success", HttpStatus.OK);

	 

	        throw new InvalidCredentialsException("Invalid Login Detials pleae verify once");

	 

	    }
	}
	 
