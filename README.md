# miniBankHomework
Create new user:
//
fetch(
  '/users', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ password: '123', email: '456@mail.bla'})
  }
).then(result => result.json().then(console.log))
**********************************************************************
List of users:

fetch('/users/').then(response => response.json().then(console.log))

***********************************************************************
Get user by ID

fetch('/users/1').then(response => response.json().then(console.log))

***********************************************************************
User login: get userId 
userId is used to execute bank operations

fetch(
  '/user', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ password: 'User123', email: 'user@mail.bla'})
  }
).then(result => result.json().then(console.log))

**********************************************************************
User do deopsit
Sets the userId and deposit amount

fetch(
  '/deposit', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ userId: '1', deposit: '123', withdrawal: '0', balance: '0'})
  }
).then(result => result.json().then(console.log))


*************************************************************************
User do withdrawal
Sets the userId and withdrawal amount

fetch(
  '/withdrawal', 
  { 
    method: 'POST', 
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ userId: '1', deposit: '0', withdrawal: '23', balance: '0'})
  }
).then(result => result.json().then(console.log))

**************************************************************************
List of user account statement by userId

fetch('/statement/1').then(response => response.json().then(console.log))

*************************************************************************

User account balance by userId
Returns the last transaction and the balance after it is completed

fetch('/balance/1').then(response => response.json().then(console.log))


