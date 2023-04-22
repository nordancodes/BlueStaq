# BlueStaq

This is the Elevator project for BlueStaq implemented using Java.

NOTE : Commented code was left in-place to serve as base for some of the future implementations below.

Assumptions/Features : 
1. There is only 1 elevator being used.
2. The elevator can only handle 1 request at a time. It takes the passenger(s) to the desired floor, then resumes availability.
3. The current hardcoded maxFloor is 10 for clean print-out purposes. This can be changed in getSpecs().
4. maxCapacity is not used. This implementation does not enforce how many may be getting on at each floor.
5. The elevator will continue accepting floor change requests until the user enters 'STOP'(case dis-regarded).



Future Implementations :
1. Add support for more than 1 elevator.
2. Use multi-threading + queue to allow multiple inputs of floor requests while elevator is busy handling other requests.
3. Implement GUI that shows animated elevator moving up/down between requests(currently simple print-out).
4. Add custom specifications for maxCapacity and maxFloor.
5. Add logic for maxCapacity, skipping a floor request if stopping + loading would exceed maxCapacity.
