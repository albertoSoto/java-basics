package com.learningjava.full.spring.service.user;

import com.learningjava.full.spring.form.UserCreateForm;
import com.learningjava.full.spring.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
