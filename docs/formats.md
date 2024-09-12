# Схемы и модели

## UserModel:
```json
"id": int,
"login": str,
"email": str,
"firstName": str,
"lastName": str,
"role": UserRoleEnum,
"username": str,
"enabled": bool,
"accountNonLocked": bool,
"accountNonExpired": bool,
"credentialsNonExpired": bool
```