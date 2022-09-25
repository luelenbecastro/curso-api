package br.com.luelen.api.services;

import br.com.luelen.api.domain.Usuario;
import br.com.luelen.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    Usuario findById (Integer id);
    List<Usuario> findAll();
    Usuario create(UserDTO obj);
}
