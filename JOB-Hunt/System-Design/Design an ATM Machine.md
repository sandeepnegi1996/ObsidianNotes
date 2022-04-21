# Design an ATM Machine
#systemdesign 


https://github.com/tssovi/grokking-the-object-oriented-design-interview/blob/master/object-oriented-design-case-studies/design-an-atm.md


# Lets Design an ATM

## ATM
1. automated Teller Machine
2.  It provides the clients of banks to withdraw money in a public space
3. Since bank branches cannot be established in all the places, such as remote areas.
4. Moreover not all the customers are wiling to visit bank and fill form to withdraw money since it is inconvenient


![[Pasted image 20220420200028.png]]


## System Requirement 
### Main Components
- main components that will affect user interactions with ATM are
- things going to play major role when user interacts with ATM
1. Card Reader
2. Screen
3. Keypad
4. Cash Dispenser
5. Printer --> print receit
6. Communication / Network Infrastructre : once we are making a transaction we need some kind of communication with the bank for that we need some kind of connectivity

7. Deposit Slot  : usually not available


- User can have Current and Saving accounts 

### Transactions
1. Withdraw money
2. Deposit money
3. Deposit Check : not in indian ATM machines 
4. Transer money
5. Check balance 


## How ATM works
1. operator from bank : that will put cash and receit in the ATM
2. ATM will serve one customer at a time
3. It should not fail or shutdown while someone is using
4. Once user put their card it will ask for pin and that pin and card information will be send to the back for authentication and once authenticated then only user can provess with transactions
5. if we deposit cheque it will not be showing immediately


## Use Case Diagram
- Actors of the ATM machine

1. Operator 
2. Customer
3. Bank Manager
4. Bank
![[Pasted image 20220420210230.png]]



Bank : block / unblock account 
Manager : check remaining cash  and generate report 



## Class Diagram

1. ATM : atm id and location 
2. CardReader :
3. Cash Dispenser :
4. Keypad
5. Screen
6. Printer
7. DepositSlot:
8. Bank : will have all the account information, ATM will communicate with Bank to do customer transactions
9. Account : Current and Saving
10. Customer : all the details of the customer 
11. Card : Encapsulatin of the ATM Card and each customer will have one card
12. Transaction



![[Pasted image 20220420211157.png]]



![[Pasted image 20220420211336.png]]





## Activity Diagram
![[Pasted image 20220420211433.png]]






























