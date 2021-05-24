package demo;
/*
 * A - exposed some endpoint
 * takes a data model
 * ex: createEmployee
 * 
 * Employee
 * {
 *  "firstName" : "aa"
 *  "lastName" : "bb"
 * }
 * 
 * Response
 * {
 *  "id" : 111,
 *  "designation" : "sde"
 *  "firstName" : "aa",
 *  "lastName" : "bb",
 * }

 * */

public class ServiceA {
    @RequestMapping("/createEmployee")
    public Data creatEmployee(Data data) {
        // save the data in database
        
        // return updated response
    }
}

