package com.todo.service

import com.todo.model.Todo
import com.todo.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun getAllTodos(): List<Todo> = todoRepository.findAll()

    fun getTodoById(id: Long): Todo = todoRepository.findById(id)
        .orElseThrow { RuntimeException("Todo не найден с id: $id") }

    fun createTodo(todo: Todo): Todo = todoRepository.save(todo)

    fun updateTodo(id: Long, todoDetails: Todo): Todo {
        val todo = getTodoById(id)
        todo.title = todoDetails.title
        todo.completed = todoDetails.completed
        todo.userId = todoDetails.userId
        return todoRepository.save(todo)
    }

    fun deleteTodo(id: Long) {
        val todo = getTodoById(id)
        todoRepository.delete(todo)
    }
}