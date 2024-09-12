# Руты апишки

## api
### status
`/api/status`

Возвращает ok

## user
### POST
#### login
`/api/user/auth/signin`

Принимает Body в формате
```json
{
    "login": "login",
    "password": "password"
}
```
Возвращает accessToken
```json
{
  "accessToken": str
}
```

#### registration
`/api/user/auth/signup`

Принимает Body в формате
```json
{
    "login": "login",
    "password": "password"
}
```

### DELETE
#### delete
`/api/user/{id}/delete`

Удаляет пользователя по id

(требуется аутентификация)

### PATCH
#### Частичное обновление
`/api/user/{id}/update`

обновить по айди пользователя отдельные параметры (пока не реализовано)

(требуется аутентификация)

### GET
#### get user by id
`/api/user/{id}`

возвращает данные пользователя в формате UserModel по id

#### get many users
`/api/user/get`

Возвращает список [UserModel] по query параметрам
(пока только firstName и lastName)

#### get all
`/api/user/getAll`

возвращает всех пользователей из бд
