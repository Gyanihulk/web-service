package com.rest.webservice.webservice.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin ( origins = "http://localhost:4200")
public class TodoResource {
    @Autowired
    private TodoHardcodedService todoService;

@GetMapping("/user/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        //  throws InterruptedException
    //Thread.sleep(3000);
    return todoService.findAll();
}

    @GetMapping("/user/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username,@PathVariable long id){
        //  throws InterruptedException
        //Thread.sleep(3000);
        return todoService.findById(id);}


@DeleteMapping(value = "/user/{username}/todos/{id}")
        public ResponseEntity<Void> deleteTodo
        (@PathVariable String username,@PathVariable long id) {
    Todo todo = todoService.deletedById(id);
    if (todo != null) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();


}


@PutMapping("/user/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo
        (@PathVariable String username,@PathVariable long id, @RequestBody Todo todo)
{
    Todo todoUpdate =todoService.save(todo);
    return  new ResponseEntity<Todo>(todo,HttpStatus.OK);
}

@PostMapping("/user/{username}/todos")
public ResponseEntity<Void> updateTodo
        (@PathVariable String username,@RequestBody Todo todo)
{
    Todo createTodo =todoService.save(todo);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(createTodo.getId()).toUri();
    return ResponseEntity.created(uri).build();
}


}

