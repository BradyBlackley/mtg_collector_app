# mtg_collector_app

Two profiles: dev, prod In run configurations add -Dspring.profiles.active=dev to VM options to activate

Set two environment variables {USERNAME}, {PASSWORD}

Open API docs:

http://localhost:9191/swagger-ui/index.html
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
- Type must already exist before attempting to update or delete, in order to fail early

Keyword (Keyword Ability)
- Keyword abilities are usually not much longer than 5-10 characters so 25 characters should be a safe bet, anything beyond
  that is probably a bad record
- A keyword ability must be unique when being added, a duplicate record cannot exist with the same keyword ability name
- Keyword ability names can only contain alphabetic characters (no numbers, special chars)
- Keyword ability must already exist before attempting to update or delete, in order to fail early

Card
- Card find methods must return message if no records are found
- Card add/update methods must validate card values
- Card add method must validate expansion must already exist
- Card delete must verify that the record exists before attempting to delete

CardCopy
- Card copies must be unique
- Card that a card copy references must already exist and be valid
- User that owns the card copy must exist and be valid
- Card copy must not already exist when being added
- Card copy must already exist when attempting to update or delete it

Typeline
- Typelines must be unique and must not already exist if being added
- Typelines must already exist if being updated/deleted
- Typeline types must each already exist, and be valid (from TypeService) 
- Typeline card must already exist, and be valid (from CardService)

ColorIdentity
- A color identity must not already exist when being added (i.e. only one color identity per card)
- A color identity must already exist when being updated
- A color identity must reference a valid and existing card
- Since color enums are already in an expected format there is no need to validate each color in the color list

KeywordList
- A keyword list must not already exist when being added
- A keyword list must already exist when being updated
- A keyword list must reference a valid and existing card
- A keyword list keyword must each already exist, and be valid (from KeywordService)

CardCopyToLibrary
- A card copy to library must not already exist when being added
- A card copy to library must already exist when being updated
- A card copy to library must reference a valid and existing card copy
- A card copy to library must reference a valid and exisiting library
