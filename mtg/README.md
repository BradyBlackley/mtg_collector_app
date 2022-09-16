Two profiles: dev, prod
In run configurations add -Dspring.profiles.active=dev to VM options to activate

Set two environment variables {USERNAME}, {PASSWORD}

Business Rules:
    User
    - UserId must be unique
    - Username must not already exist and must be less than 16 characters and must be greater than 2 characters
    - Password must contain an uppercase, lowercase, number, special character (!@#$%^&*), and a minimum of 8 characters

    Library
    - Library name must be unique to user, two libraries can have the same name by different users
    - Library name must be less than 25 characters and must be greater than 2 characters
    - Library name may only contain alphanumeric characters with the exception of spaces
    - Library name may not be empty
    - Library user must exist
