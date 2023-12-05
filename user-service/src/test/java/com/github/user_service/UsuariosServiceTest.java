package com.github.user_service;

import com.github.user_service.model.Usuario;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import com.github.user_service.service.UsuariosService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UsuariosServiceTest {

    @Autowired
    @InjectMocks
    private UsuariosService usuariosService;

    @MockBean
    private UsuariosRepository usuariosRepository;

    @Test
    public void testGetUsuario() {
        when(usuariosRepository.findAll()).thenReturn(Stream.of(new Usuario(2L, "Luis", 35)).collect(Collectors.toList()));
        Assertions.assertThat(usuariosService.listaUsuarios()).hasSize(1);
    }

    @Test
    public void testAddUsuario() {
        Usuario usuario = new Usuario(3L, "Luan", 21);

        when(usuariosRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario resultado = usuariosService.addUsuario(usuario);

        verify(usuariosRepository).save(usuario);
        assertEquals(usuario, resultado);
    }

    @Test
    public void testAddUsuarioComExcecao() {
        Usuario usuario = new Usuario(3L, "Luan", 21);

        when(usuariosRepository.save(any(Usuario.class))).thenThrow(new RuntimeException("Erro ao salvar usuário"));

        try {
            Usuario resultado = usuariosService.addUsuario(usuario);
            fail("Esperava uma exceção");
        } catch (RuntimeException e) {
            assertEquals("Erro ao salvar usuário", e.getMessage());
        }

        verify(usuariosRepository).save(usuario);
    }

    /*@Test
    public void testAddUsuarioComIdInvalido() { // Teste funciona, mas o banco sempre vai gerar um ID automático, então ele nunca vai ser negativo.
        Usuario usuario = new Usuario(-1L, "Luan", 21);

        try {
            usuariosService.addUsuario(usuario);
            fail("Esperava uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("ID inválido: " + usuario.getId(), e.getMessage());
        }
    }*/

    @Test
    public void testUpdateUsuario() {
        Usuario usuario = new Usuario(6L, "Nolan", 38);

        when(usuariosRepository.findById(usuario.getId())).thenReturn(Optional.of(usuario));
        when(usuariosRepository.save(any(Usuario.class))).thenReturn(usuario);

        RequestUsuario requestUsuario = new RequestUsuario("Nolan", 39);
        Usuario resultado = usuariosService.updateUsuario(requestUsuario, usuario.getId());

        assertEquals(requestUsuario.nome(), resultado.getNome());
        assertEquals(requestUsuario.idade(), resultado.getIdade());
        verify(usuariosRepository).save(usuario);
    }

    @Test
    public void testdeleteUsuario() {
        Usuario usuario = new Usuario(6L, "Nolan", 38);
        when(usuariosRepository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        Usuario resultado = usuariosService.deleteUsuario(usuario.getId());
        assertEquals(usuario, resultado);
        verify(usuariosRepository).delete(usuario);
    }
}
