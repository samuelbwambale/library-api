# library-api

This is library API that performs the following functions:
- List all books in the library
- CRUD operations on a single book

Endpoints:
----------

`GET /books`

Returns a list of books in the library

`GET /books/:id`

Returns details of a single book with specified `id`


`POST /books`

Adds a new book to the library

```source-json
{
    "bookNumber": 2300,
    "title": "C++ Programming",
    "author": "Sanjay Gupta",
    "publication_date": "08/13/1987",
    "available": true
}
```
All fields are required


`PUT /books/:id`

Updates details of an existing book in the library

```source-json
{
    "bookNumber": 2311,
    "title": "C++ Programming",
    "author": "Sanjay Gupta",
    "publication_date": "08/13/1987",
    "available": true
}
```
All fields are required


`DELETE /books/:id`

Removes the book with specified `id` from the library

