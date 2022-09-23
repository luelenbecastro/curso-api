package br.com.luelen.api.config;

import br.com.luelen.api.domain.Usuario;
import br.com.luelen.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        Usuario u1 = new Usuario(null, "Luelen", "thomazluelen@gmail.com", "123");
        Usuario u2 = new Usuario(null, "Luana", "luana@gmail.com", "123");

        repository.saveAll(List.of(u1, u2));
    }
}
