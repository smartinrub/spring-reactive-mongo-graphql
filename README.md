# spring-boot-graphql

## H2 Dashboard

`http://localhost:8080/h2`

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
      occupants
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
  "hotelId": "1"
}
```
- Mutation
```
mutation {
  newHotel(name:"test 1", address: "test 1"){
    name
    address
  }
}
```

## Notes

To use subscriptions with Reactive MongoDB the Hotel collection must be capped.

```shell
mongo
use test
db.runCommand( { convertToCapped: 'hotel', size: 8192 } )
```