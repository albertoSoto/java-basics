package com.learningjava.full.spring.service.currentuser;

import com.learningjava.full.spring.security.auth.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
