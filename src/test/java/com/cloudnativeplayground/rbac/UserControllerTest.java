package com.cloudnativeplayground.rbac;

import com.cloudnativeplayground.rbac.controller.UserController;
import com.cloudnativeplayground.rbac.entity.Role;
import com.cloudnativeplayground.rbac.entity.User;
import com.cloudnativeplayground.rbac.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController();
        userController.setUserService(userService);
    }

    @Test
    void testGetAllUsers() {
        // Arrange
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User(1L, "John Doe",  "password123"));
        mockUsers.add(new User(2L, "Jane Doe",  "password456"));
        Role role = new Role("ROLE_USER");
        role.setId(3L);
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        mockUsers.get(0).setRoles(new HashSet<>(roleList));
        mockUsers.get(1).setRoles(new HashSet<>(roleList));
        when(userService.getAllUsers()).thenReturn(mockUsers);

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(2, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getUsername());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        // Arrange
        User mockUser = new User(1L, "John Doe", "password123");
        Role role = new Role("ROLE_USER");
        role.setId(3L);
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        mockUser.setRoles(new HashSet<>(roleList));
        when(userService.getUserById(1L)).thenReturn(Optional.of(mockUser));

        // Act
        ResponseEntity<User> response = userController.getUserById(1L);

        // Assert
        assertEquals("John Doe", response.getBody().getUsername());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testCreateUser() {
        // Arrange
        User newUser = new User(4L, "User1", "password123");
        User savedUser = new User(3L, "User2",  "password123");
        Role role = new Role("ROLE_USER");
        role.setId(3L);
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        savedUser.setRoles(new HashSet<>(roleList));
        when(userService.saveUser(newUser)).thenReturn(savedUser);

        // Act
        ResponseEntity<User> response = userController.createUser(newUser);

        // Assert
        assertEquals(3L, response.getBody().getId());
        assertEquals("User1", response.getBody().getUsername());
        verify(userService, times(1)).saveUser(newUser);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        ResponseEntity<Void> response = userController.deleteUser(userId);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(userService, times(1)).deleteUser(userId);
    }
}
