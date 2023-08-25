package com.app.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AddUserDto;
import com.app.dto.SigninRequest;
import com.app.dto.SigninResponse;
import com.app.entities.Owner;
import com.app.entities.User;
import com.app.entities.UserType;
import com.app.entities.Warehouse;
import com.app.repository.OwnerRepository;
import com.app.repository.UserRepository;
import com.app.repository.WarehouseRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public SigninResponse authenticate(SigninRequest request) {
		// invoke dao's method
		User user = userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials , Invalid Login!!!!!!!!!!!!!"));
		return modelMapper.map(user, SigninResponse.class);
	}
	@Override
	public User createUser(AddUserDto user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        System.out.println(user);
        User newUser = convertToEntity(user);
        System.out.println(newUser);
        return userRepo.save(newUser);
    }
	
	
	private User convertToEntity(AddUserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        
        user.setUser(UserType.valueOf(userDto.getUser().toUpperCase()));
        if (userDto.getOwnerId() != null) {
            user.setOwner(new Owner(userDto.getOwnerId())); 
        }
        if (userDto.getWarehouseId() != null) {
            user.setWarehouse(new Warehouse(userDto.getWarehouseId())); 
        }
        
        return user;
    }

	private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());

            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }
            return hashString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not available.", e);
        }
    }
}
