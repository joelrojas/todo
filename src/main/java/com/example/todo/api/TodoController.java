package com.example.todo.api;

import com.example.todo.bl.TodoBl;
import com.example.todo.dao.TodoEntity;
import com.example.todo.dto.TodoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/v1/api/todo")
public class TodoController {
    private static Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    private TodoBl todoBl;

    @Autowired
    public TodoController(TodoBl todoBl) {
        this.todoBl = todoBl;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TodoEntity>> getTodos() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de TODO's");
        List<TodoEntity> result = todoBl.getTodos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<TodoEntity> getTodo(@PathVariable Integer id) {
        LOGGER.info("REQUEST: Iniciando petición para obtener un TODO");
        TodoEntity result = todoBl.getTodo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TodoEntity> saveTodo(@RequestBody TodoDto todoDto) {
        LOGGER.info("REQUEST: Iniciando petición para guardar un TODO");
        TodoEntity result = todoBl.saveTodo(todoDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<TodoEntity> updateTodo(@RequestBody TodoDto todoDto) {
        LOGGER.info("REQUEST: Iniciando petición para actualizar un TODO");
        TodoEntity result = todoBl.updateTodo(todoDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TodoEntity> deleteTodo(@PathVariable Integer id) {
        LOGGER.info("REQUEST: Iniciando petición para eliminar un TODO");
        TodoEntity result = todoBl.deleteTodo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "pagination", method = RequestMethod.GET)
    public ResponseEntity<PageImpl<TodoEntity>> getTodosWithPagination(
        @RequestParam Integer page,
        @RequestParam Integer size) {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de TODO's paginados");
        PageImpl<TodoEntity> result = todoBl.getTodosWithPagination(page, size);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
