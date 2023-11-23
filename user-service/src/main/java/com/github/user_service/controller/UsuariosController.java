package com.github.user_service.controller;


import com.github.user_service.model.Usuario;
import com.github.user_service.model.records.RequestUsuario;
import com.github.user_service.repository.UsuariosRepository;
import com.github.user_service.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private UsuariosService usuariosService;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @GetMapping
    public ResponseEntity listarUsuarios() {
        List<Usuario> usuarios = usuariosService.listaUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @PostMapping("/add")
    public ResponseEntity adicionarUsuario(@Valid @RequestBody @ResponseBody Usuario) {
        try {
            Usuario usuario = new Usuario(RequestUsuario);
            NinjasModel ninjaCadastrado = ninjasService.addNinja(ninja);
            return ResponseEntity.status(HttpStatus.CREATED).body("Ninja cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

//    private final List<TaskModel> tasks = new ArrayList<>();
//
//    @GetMapping
//    public List<TaskModel> getAllTasks() {
//        return taskServices.getAllTasks();
//    }
//
//    @PostMapping("/add")
//
//    public ResponseEntity<String> addTask(@RequestBody TaskModel task) {
//        try {
//            taskServices.addTask(task);
//            return new ResponseEntity<>("Tarefa adicionada com sucesso.", HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>("Erro.", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping("/edit/{taskId}")
//    public ResponseEntity<String> editTask(@PathVariable int taskId, @RequestBody TaskModel task) {
//        try {
//            taskServices.editTask(taskId, task);
//            return new ResponseEntity<>("Tarefa editada com sucesso.", HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>("Erro ao editar a tarefa.", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/delete/{taskId}")
//    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
//        try {
//            taskServices.deleteTask(taskId);
//            return new ResponseEntity<>("Tarefa removida com sucesso.", HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>("Erro ao remover a tarefa.", HttpStatus.BAD_REQUEST);
//        }
//    }
//}
}
