Two profiles: dev, prod
In run configurations add -Dspring.profiles.active=dev to VM options to activate

Set two environment variables {USERNAME}, {PASSWORD}

Business Rules:
    User
    - UserId must be unique
    - Username must not already exist and must be less than 16 characters and must be greater than 3 characters
    - Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), and a minimum of 8 characters