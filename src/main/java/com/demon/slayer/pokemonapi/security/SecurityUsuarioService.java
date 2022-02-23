package com.demon.slayer.pokemonapi.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.demon.slayer.pokemonapi.models.Usuario;
import com.demon.slayer.pokemonapi.repositories.UsuarioRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUsuarioService implements UserDetailsService{

    UsuarioRepository usuarioRepository;

    public SecurityUsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username);
        return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getPassword(), mapRolesToAuthorities(usuario.getRol()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(String rol){
        List<String> roles = new ArrayList<>();
        roles.add(rol);
        return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
    }
    
}
