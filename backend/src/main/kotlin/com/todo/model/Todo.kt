package com.todo.model

import jakarta.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var completed: Boolean = false,

    @Column(name = "user_id")
    var userId: Long = 1
)