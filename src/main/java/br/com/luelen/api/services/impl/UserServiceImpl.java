package br.com.luelen.api.services.impl;

import br.com.luelen.api.domain.Usuario;
import br.com.luelen.api.repositories.UserRepository;
import br.com.luelen.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> obj =repository.findById(id);
        return obj.orElse(null);
    }
}
