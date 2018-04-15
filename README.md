# math-service
math service example

This math-service created to find prime numbers till given number for example, If you supply 10 as input then it should return list of number as 2,3,5,7

Service endpoint : http://localhost:8080/primes/{number}
                   example : http://localhost:8080/primes/10
                   
Response :      {
                    Initials: 10,
                    Primes: [
                             2,
                             3,
                             5,
                             7
                            ]
                    }
                    
RESTful-API-Swagger-endpoint : http://localhost:8080/swagger-ui.html
Management Actuator Endpoints : http://localhost:8080/actuator/
