package com.spynu.newrestapi.service;

import com.spynu.newrestapi.repository.UserRepository;
import com.spynu.newrestapi.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserService {
    UserRepository userRepository;

    public List<User> showAllUsersService() {
        return userRepository.findAll();
    }

    public void createNewUserService(User user) {
        userRepository.save(user);
    }

    public Optional<User> showUserByIdService(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUserService(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUserService(User updatedUser) {
        userRepository.save(updatedUser);
    }
}
