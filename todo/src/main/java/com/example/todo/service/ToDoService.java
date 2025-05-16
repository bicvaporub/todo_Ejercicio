package com.example.todo.service;

import com.example.todo.entity.ToDo;
import com.example.todo.exception.NotFoundException;
import com.example.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository repository;

    public ToDo create(ToDo todo) {
        return repository.save(todo);
    }

    public List<ToDo> findAll() {
        return repository.findAll();
    }

    public ToDo update(Long id, ToDo updated) {
        ToDo existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ToDo no encontrado"));
        existing.setDescription(updated.getDescription());
        existing.setDate(updated.getDate());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    public ToDo patchStatus(Long id, String status) {
        ToDo todo = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ToDo no encontrado"));
        todo.setStatus(status);
        return repository.save(todo);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("ToDo no encontrado");
        }
        repository.deleteById(id);
    }
}
