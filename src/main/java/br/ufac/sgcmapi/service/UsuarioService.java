package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Usuario;
import br.ufac.sgcmapi.repository.UsuarioRepository;

@Service
public class UsuarioService implements ICrudService<Usuario> {

    private final UsuarioRepository repo;

    @Autowired
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    private Usuario removeSenha(Usuario usuario) {
        usuario.setSenha(null);
        return usuario;
    }

    private List<Usuario> removeSenha(List<Usuario> usuarios) {
        usuarios.forEach(item -> removeSenha(item));
        return usuarios;
    }

    public Usuario getByNomeUsuario(String nomeUsuario) {
        Usuario usuario = repo.findByNomeUsuario(nomeUsuario);
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        List<Usuario> registros = repo.findAll();
        registros = removeSenha(registros);
        return registros;
    }

    @Override
    public Usuario getById(Long id) {
        Usuario registro = repo.findById(id).orElse(null);
        registro = removeSenha(registro);
        return registro;
    }

    @Override
    public List<Usuario> getByAll(String termoBusca) {
        List<Usuario> registros = repo.findByAll(termoBusca);
        registros = removeSenha(registros);
        return registros;
    }

    @Override
    public Usuario save(Usuario objeto) {
        if (objeto.getSenha() == null) {
            Long id = objeto.getId();
            Usuario usuario = repo.findById(id).orElse(null);
            if (usuario != null) {
                objeto.setSenha(usuario.getSenha(), false);
            }
        }
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
