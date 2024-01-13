## gateway-api-service

Сервис с котором взаимодействует пользователь через UI React.
Сервис выполняет rest запросы в book-service, purchase-service, проводит аутентификацию пользователей.

### Создание пользователя
```
curl -X POST -H "Content-Type: application/json" -d '{"name": "Petr Petrov","username": "ppetrov","password": "123456"}' http://localhost:5555/api/authentication/sign-up 
```

### Аутентификация
```
curl -X POST -H "Content-Type: application/json" -d '{"username": "admin","password": "admin"}' http://localhost:5555/api/authentication/sign-in
```

### Добавление книги (только админ)
```
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer <token>" -d '{"title": "book1","description": "some description","price": 15}' http://localhost:5555/gateway/book
```

### Список книг
```
curl -X GET http://localhost:5555/gateway/book
```

### Удаление книги (только админ)
```
curl -X POST http://localhost:5555/gateway/book/1
```

### Покупка книги
```
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer <token>" -d '{"userId": 1,"bookId": 2,"title": "book1","price": 11}' http://localhost:5555/gateway/purchase
```

### Список покупок
```
curl -X GET -H "Content-Type: application/json" -H "Authorization: Bearer <token>" http://localhost:5555/gateway/purchase
```
