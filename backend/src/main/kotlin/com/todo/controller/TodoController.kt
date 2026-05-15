package com.todo.controller

import com.todo.model.Todo
import com.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = ["http://localhost:3000"])
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        return ResponseEntity.ok(todoService.getAllTodos())
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<Todo> {
        return try {
            ResponseEntity.ok(todoService.getTodoById(id))
        } catch (e: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        val createdTodo = todoService.createTodo(todo)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo)
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todo: Todo): ResponseEntity<Todo> {
        return try {
            ResponseEntity.ok(todoService.updateTodo(id, todo))
        } catch (e: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            todoService.deleteTodo(id)
            ResponseEntity.noContent().build()
        } catch (e: RuntimeException) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/init-test-data")
    fun initData(): ResponseEntity<List<Todo>> {
        val testTodos = listOf(
            Todo(title = "Купить продукты", completed = false, userId = 1),
            Todo(title = "Позвонить маме", completed = true, userId = 1),
            Todo(title = "Сходить в спортзал", completed = false, userId = 1),
            Todo(title = "Прочитать книгу", completed = true, userId = 1),
            Todo(title = "Написать отчёт", completed = false, userId = 1),
            Todo(title = "Встретиться с друзьями", completed = false, userId = 1),
            Todo(title = "Оплатить счета", completed = true, userId = 1),
            Todo(title = "Записаться к врачу", completed = false, userId = 1),
            Todo(title = "Сделать уборку", completed = false, userId = 1),
            Todo(title = "Приготовить ужин", completed = true, userId = 1),
            Todo(title = "Посмотреть вебинар", completed = false, userId = 1),
            Todo(title = "Обновить резюме", completed = false, userId = 1),
            Todo(title = "Заказать подарок", completed = true, userId = 1),
            Todo(title = "Погулять с собакой", completed = false, userId = 1),
            Todo(title = "Медитация 10 минут", completed = false, userId = 1)
        )
        val savedTodos = testTodos.map { todoService.createTodo(it) }
        return ResponseEntity.ok(savedTodos)
    }
}