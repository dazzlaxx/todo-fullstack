# Todo Fullstack Application

Полноценное Fullstack-приложение для управления задачами с бэкендом на Kotlin + Spring Boot и фронтендом на React.

## Функционал

- Просмотр списка задач
- Добавление новых задач
- Редактирование задач
- Отметка выполнения
- Удаление задач
- Фильтрация (все / активные / завершённые)
- Сохранение данных в базе данных
- Нежный лавандовый дизайн
- Адаптивная вёрстка

## Технологии

### Backend
- **Kotlin** 1.9.22
- **Spring Boot** 3.2.0
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Maven**

### Frontend
- **React** 18
- **React Router** 6
- **CSS3** (анимации, градиенты)
- **Fetch API**

## Структура проекта

todo-fullstack/
├── backend/
│   ├── src/main/kotlin/com/todo/
│   │   ├── TodoApplication.kt
│   │   ├── model/Todo.kt
│   │   ├── repository/TodoRepository.kt
│   │   ├── service/TodoService.kt
│   │   └── controller/TodoController.kt
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── TodoList.js
│   │   │   ├── TodoList.css
│   │   │   ├── TodoDetail.js
│   │   │   └── TodoDetail.css
│   │   ├── services/api.js
│   │   ├── App.js
│   │   └── App.css
│   └── package.json
└── README.md

## Запуск

### Backend
cd backend
./mvnw spring-boot:run
Сервер: http://localhost:8080

### Frontend
cd frontend
npm install
npm start
Приложение: http://localhost:3000

## 📡 API

Метод | URL | Описание
GET | /api/todos | Все задачи
GET | /api/todos/{id} | Задача по ID
POST | /api/todos | Создать
PUT | /api/todos/{id} | Обновить
DELETE | /api/todos/{id} | Удалить

## 🗄 База данных

H2 In-Memory. Таблица todos:
- id (Long, PK)
- title (String)
- completed (Boolean)
- userId (Long)

H2 Console: http://localhost:8080/h2-console
URL: jdbc:h2:mem:tododb
User: sa, Password: пусто