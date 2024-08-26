package com.example.BookstoreAPI.service;

import org.springframework.stereotype.Service;
import com.example.BookstoreAPI.entity.Customer;
import com.example.BookstoreAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.getByName(username).get();
        if (customer != null) {
            return org.springframework.security.core.userdetails.User.builder().username(customer.getName())
                    .password(customer.getPassword())
                    .roles(customer.getRoles().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("Customer not found with username: " + username);
    }
}
