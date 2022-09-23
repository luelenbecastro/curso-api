package br.com.luelen.api.repositories;

import br.com.luelen.api.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
}
