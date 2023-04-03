# ECsite_Structure

## Project subject 
- EC Site Using SpringBoot

## Project structure
![image](https://user-images.githubusercontent.com/94863168/229589421-829e0ea0-a89b-4494-a4d8-91b9cb952c5e.png)

## Tech Stack
Language : Java  
DBMS : MySQL, Redis
Java Version : Java 11  
IDE : Intellij IDEA 2023.3.2 (Ultimate Edition)  
Test Program : Intellij .http


etc : Logback, Swagger(API document)  

Goal : Build a commerce server that mediates between sellers and buyers.


## User Server
### Common
- [x] Sign up for membership through the verification link via email

### Customer
- [x]  Join the membership
- [x]  Authentication (E-mail)
- [x]  Issuance of login tokens
- [x]  Check control through login token (simplified using JWT, Filter)
- [x]  Deposit Management

### Seller
- [x] Join the membership


## Order Server

### Seller
- [x] Product registration, modification
- [x] Delete product

### Buyer
- [x] Redis Integration for Shopping Cart
- [x] Product search & detail page
- [x] Add item to cart
- [x] Check cart
- [x] Order
- [ ] Send order details by email

