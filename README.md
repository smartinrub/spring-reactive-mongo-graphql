# spring-boot-graphql

## GraphQL Client

`http://localhost:8080/graphiql`

### Example

GraphQL Endpoint: `http://localhost:8080/graphql`

```
{
  hotelById(id: "1") {
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
      "name": "The Venetian Las Vegas",
      "address": "3355 Las Vegas Blvd S, Las Vegas, NV, 89109, United States of America",
      "room": {
        "name": "Standard Double Room",
        "rate": 50
      }
    }
  }
}
```
