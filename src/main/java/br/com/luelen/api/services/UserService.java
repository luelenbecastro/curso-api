package br.com.luelen.api.services;

import br.com.luelen.api.domain.Usuario;

import java.util.List;

public interface UserService {

    Usuario findById (Integer id);
    List<Usuario> findAll();
}
