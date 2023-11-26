package com.github.user_service;

import com.github.user_service.model.Usuario;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public void testGetUsuarios() {
        when(usuariosRepository.findAll()).thenReturn(Stream.of(new Usuario(2L, "Luis", 35)).collect(Collectors.toList()));
        Assertions.assertThat(usuariosService.listaUsuarios()).hasSize(1);
    }


   /* @Test
    public void deleteUsuarioTest() {
        Usuario usuario = new Usuario(5L, "Marta", 45);
        usuariosService.deleteUsuario(5L);
        verify(usuariosRepository, times(1)).delete(5L);
        assertThat(usuariosService.listaUsuarios()).doesNotContain(usuario);
    }*/

}
