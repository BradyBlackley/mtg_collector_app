Two profiles: dev, prod
In run configurations add -Dspring.profiles.active=dev to VM options to activate

Set two environment variables {USERNAME}, {PASSWORD}

Business Rules:
    User
    - UserId must be unique
    - Username must not already exist
    - Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), a minimum of 10 characters