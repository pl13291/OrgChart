# OrgChart

Organisation Chart developed as for requirements. Due to time constrains and simplicity of the project plenty of functionalities
are missing (or been found not crucial). Todo list below:

1. Implement GUI to manipulate Employee and Company information, prettify prints etc
2. Add caching where necessary (retrieval of employee's HashMap for example)
3. Add EmployeeFactory and CompanyFactory methods. Currently creating employees is unreliable
4. Create separate classes for CEO, VP etc. extending Employee. 
    Not implemented cause they share precisely the same responsibilities atm
5. Add database layer and a service retriving data from db
6. Concurrency not implemented as of now. Company is not thread safe
7. Create Node class and make Employee extend it. Node class will be responsible to keeping the structure.

Most of the above haven't been implemented because it made no sense to over-complicate this simple Organisation Chart.

