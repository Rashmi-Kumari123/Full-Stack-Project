package com.saloon.service;

import com.saloon.modal.User;
import com.saloon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    @Autowired // Explicitly inject the dependency
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new Exception("user not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("user not found with requested id" + id);
        }

        User existingUser = otp.get();
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setRole(updatedUser.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("user not found with requested id" + id );
        }
        userRepository.deleteById(otp.get().getId());
    }
}
