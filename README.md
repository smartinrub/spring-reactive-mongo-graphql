# spring-boot-graphql

## GraphQL Client

`http://localhost:8080/graphiql`

### Example
- Simple Query:
```
query {
  findAllHotels {
    name
    address
    room {
      type
    }
  }
}
```
- Query with Query Variables:

```
query($hotelId:ID) {
  findHotelById(id:$hotelId) {
    name
    room {
      type
    }
  }
  countHotels
  findAllPayments {
    name
  }
}
```
```
{
  "hotelId": "5d290660a48e64543d7fcb17"
}
```
- Mutation
```
mutation {
  newHotel(name: "myHotel", address: "test") {
    id
    creationDate
  }
}
mutation {
  newRoom(type: "test", occupants: 2, hotelId: "5d290660a48e64543d7fcb17") {
    id
  }
}
```

## Graphql Subscription page

`http://localhost:8080/index.html`

## Notes

To use subscriptions with Reactive MongoDB the Hotel collection must be capped.

```shell
mongo
use test
db.runCommand( { convertToCapped: 'hotel', size: 8192 } )
```