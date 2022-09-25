package br.com.luelen.api.services.impl;

import br.com.luelen.api.domain.Usuario;
import br.com.luelen.api.domain.dto.UserDTO;
import br.com.luelen.api.repositories.UserRepository;
import br.com.luelen.api.services.UserService;
import br.com.luelen.api.services.exceptions.DataIntegratyViolationException;
import br.com.luelen.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> obj =repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<Usuario> findAll() {
        return repository.findAll();
    }
    @Override
    public Usuario create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Usuario.class));
    }

    @Override
    public Usuario update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Usuario.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<Usuario> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
