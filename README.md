# Programming notes

Ideally implement the solution in two parts
 - a Spring REST API
 - an Angular front end to call the REST api
 
### Backend

* Use spring initializr to create skeleton REST API project
* outline the REST call, name it ‘calculate’
  * quick test to call ‘calculate’

* create a ‘distance’ package for the actual calculation
  * parameters:
    * distanceA
    * distanceB
    * unitA: yards/meters
    * unitB: yards/meters
    * returnUnit: yards/meters
    
* attempt some TTD
  * write test cases for
  * adding meter to meter : return meter
  * adding yard to yard : return yard
  * adding meter to yard : return meter
  * adding yard to meter : return yard
  * other combos are possible, but let’s start with these
  * invalid distance
  * invalid units
  * invalid returnUnit

### Frontend
* If there’s time, a simple angular project to call the REST API

### Future improvements
* Instead of parameters, I really should have put the distances in the request body
  * didn't realise until the end
* Been wanting to try parameterized tests




