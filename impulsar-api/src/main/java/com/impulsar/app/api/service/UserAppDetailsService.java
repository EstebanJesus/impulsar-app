package com.impulsar.app.api.service;

import org.springframework.stereotype.Service;

@Service
public class UserAppDetailsService {

}/*implements UserDetailsService {*/

    /*private final UserRepository userRepository;

    public UserAppDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findOneWithAuthoritiesByLogin(userName.toLowerCase())
                .map(this::createSpringSecurityUser)
                .orElseThrow(() -> new UsernameNotFoundException("UserApp " + userName.toLowerCase() + " was not found in the database"));
    }

    private User createSpringSecurityUser(UserApp userApp) {
        List<GrantedAuthority> grantedAuthorities = userApp.authoritiesStream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toList());
        return new User(userApp.getLogin(), userApp.getPassword(), grantedAuthorities);
    }
}*/
