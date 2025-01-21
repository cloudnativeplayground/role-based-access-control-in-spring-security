package com.cloudnativeplayground.rbac.service;

import com.cloudnativeplayground.rbac.entity.User;
import com.cloudnativeplayground.rbac.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Get all users from the database.
     *
     * @return List of users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get a user by its ID.
     *
     * @param id User ID.
     * @return Optional User.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Create or update a user in the database.
     *
     * @param user User to save.
     * @return Saved User.
     */
    public User saveUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Update a user in the database.
     *
     * @param id User ID.
     * @param user User to update.
     * @return Updated User.
     */
    public User updateUser(Long id, User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(id);
        return userRepository.save(user);
    }

    /**
     * Delete a user by its ID.
     *
     * @param id User ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Get a user by their username.
     *
     * @param username Username of the user.
     * @return Optional User.
     */
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
