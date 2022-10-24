package com.project.SIAP.security.service;

import com.project.SIAP.security.dto.UserDto;
import com.project.SIAP.security.entities.Role;
import com.project.SIAP.security.entities.User;
import com.project.SIAP.security.exception.EmailAlreadyExistsException;
import com.project.SIAP.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDto user) {

        User nUser = user.getUserFromDto();

        if(userRepository.existsByEmail(nUser.getEmail()))
            throw new EmailAlreadyExistsException("Email ocupado");

        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if(nUser.getEmail().split("@")[1].equals("ucundinamarcaadmin.edu.co")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        if(nUser.getEmail().split("@")[1].equals("ucundinamarcabiens.edu.co")){
            role = roleService.findByName("BIENS");
            roleSet.add(role);
        }

        if(nUser.getEmail().split("@")[1].equals("ucundinamarcabiblio.edu.co")){
            role = roleService.findByName("BIBLIO");
            roleSet.add(role);
        }

        if(nUser.getEmail().split("@")[1].equals("ucundinamarcasalac.edu.co")){
            role = roleService.findByName("SALC");
            roleSet.add(role);
        }

        if(nUser.getEmail().split("@")[1].equals("ucundinamarcalab.edu.co")){
            role = roleService.findByName("LABT");
            roleSet.add(role);
        }

        if(nUser.getEmail().split("@")[1].equals("ucundinamarcacampu.edu.co")){
            role = roleService.findByName("CAMP");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userRepository.save(nUser);
    }
}
