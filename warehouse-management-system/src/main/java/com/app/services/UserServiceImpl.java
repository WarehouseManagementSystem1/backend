package com.app.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AddUserDto;
import com.app.dto.AddWarehouseResponse;
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
		
		 String hashedPassword = hashPassword(request.getPassword());
		 request.setPassword(hashedPassword);
		User user = userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials , Invalid Login!!!!!!!!!!!!!"));
		SigninResponse response = convertToSigninResponse(user);
		return response;
	}
	
	
	private SigninResponse convertToSigninResponse(User user) {
		SigninResponse response = new SigninResponse();
		response.setFirstname(user.getFirstName());
		response.setLastname(user.getLastName());
		response.setOwnerId(user.getOwner().getId());
		response.setUserId(user.getId());
		response.setUserType(user.getUser());
		Warehouse warehouse = user.getWarehouse();
		if(warehouse==null) {
			response.setWarehouseId(null);
			return response;
		}
		response.setWarehouseId(user.getWarehouse().getId());
		return response;
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
        
        user.setFirstName(userDto.getFirstname());
        user.setLastName(userDto.getLastname());
        user.setUser(UserType.valueOf(userDto.getUserType().toUpperCase()));
        if (userDto.getOwnerId() != null) {
        	Owner owner = ownerRepository.findById(userDto.getOwnerId()).orElseThrow(()->new ResourceNotFoundException("invalid owner Id "));
            user.setOwner(owner); 
        }
        if (userDto.getWarehouseId() != null) {
        	Warehouse warehouse = warehouseRepository.findById(userDto.getWarehouseId()).orElseThrow(()->new ResourceNotFoundException("invalid warehouse id !!!"));
            user.setWarehouse(warehouse); 
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
