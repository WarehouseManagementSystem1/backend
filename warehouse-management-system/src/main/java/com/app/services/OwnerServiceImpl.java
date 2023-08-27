package com.app.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.RegisterRequest;
import com.app.entities.Owner;
import com.app.entities.User;
import com.app.entities.UserType;
import com.app.repository.OwnerRepository;
import com.app.repository.UserRepository;
import com.app.repository.WarehouseRepository;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	OwnerRepository ownerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	WarehouseRepository warehouseRepository;
	
	@Override
	public Long addOwner(RegisterRequest newOwner) {
		
		String hashedPassword = hashPassword(newOwner.getPassword());
        newOwner.setPassword(hashedPassword);
        Owner detachedOwner = mapRegisterDtoToOwner(newOwner);
        Owner savedOwner= ownerRepository.save(detachedOwner);
        User detachedUser = mapRegisterDtoToUser(savedOwner,newOwner.getPassword());
        User savedUser = userRepository.save(detachedUser);
        return savedOwner.getId();
        		
		
	}
	

	private User mapRegisterDtoToUser(Owner savedOwner,String hasedPassword) {
		User user = new User();
		user.setEmail(savedOwner.getEmail());
		user.setFirstName(savedOwner.getFirstName());
		user.setLastName(savedOwner.getLastName());
		user.setPhoneNumber(savedOwner.getPhoneNumber());
		user.setUser(UserType.ADMIN);
		user.setWarehouse(null);
		user.setOwner(savedOwner);
		user.setPassword(hasedPassword);
		return user;
		
	}


	private Owner mapRegisterDtoToOwner(RegisterRequest newOwner) {
		Owner owner = new Owner();
		owner.setFirstName(newOwner.getFirstname());
		owner.setLastName(newOwner.getLastname());
		owner.setEmail(newOwner.getEmail());
		owner.setPhoneNumber(newOwner.getContactnumber());
		owner.setWarehouse(null);
		return owner;
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
