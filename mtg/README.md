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

    Color
    - Don't need this as a repository - refactor as an Enum somehow

    Expansion (Rename to Set?)
    - Cannot add a duplicate set name, check if it already exists in db
    - Magic the Gathering started in August of 1993, so Expansion.releasedDate cannot have a date earlier than that
    - Sets are announced some time in advance so it's reasonable to enter a released date that's a few years in the future,
      but to prevent bad data from entering the db, we'll make it a rule that the releasedDate can be no more than two 
      years into the future
    - Set names cannot contain special characters other than :
    - All set codes must be a unique combination of exactly 3 alphanumeric characters, (can't add a duplicate set code)

    Type
    - Type names are usually not much longer than 5-10 characters so 25 characters should be a safe bet, anything beyond
      that is probably a bad record
    - A type must be unique when being added, a duplicate record cannot exist with the same type name
    - Type names can only contain alphabetic characters (no numbers, special chars)
    - Type must already exist before attempting to update, in order to fail early