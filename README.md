# spring-boot-graphql

## GraphQL Client

### macOS installation

`brew cask install graphiql`

### Example

GraphQL Endpoint: `http://localhost:8080/graphql`

```
{
  hotelById(id: "hotel-2") {
    id
    name
    address
    room {
      name
      rate
    }
  }
}

```
Output:
```
{
  "data": {
    "hotelById": {
      "id": "hotel-2",
      "name": "name 2",
      "address": "321",
      "room": {
        "name": "name 2",
        "rate": 20
      }
    }
  }
}
```
