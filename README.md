# product-buy-strategy

Application provide an interface to perform following operations:

* Scoring all products on how well they match their product definitions.
* Filter the potential products to just those that pass a given threshold (assume 50% as the cutoff).
* Calculate the total and average prices for all the products that score sufficiently highly.

Application can be run using command line and will print out the total and average prices that score sufficiently
highly.

## UML
<img src="https://github.com/Sarvesh27Sharma/product-buy-strategy/blob/master/uml/uml.png" alt="design" type="image/png" width="900">

## Design

* Design is simple yet easy to scale.
* Since Condition is an interface, it can be extended to allow new conditions which would mean New rules can be easily
  added.
* ProductStrategy provide functions declaration for all 3 operations. Since it is also an interface, implementation can
  be extended.

## Implementation

* Spring boot is used with command line runner.
* Latest springboot and java versions are used.
* All Classes are immutable.

## Improvements

* Current implementation requires new condition to be created for adding a new rule. This can be even extended with
  generalising Condition interface with attributes, operators & values.
* Can be even more extensible with storing rules in a database with application periodically refreshes it.

## Assumptions

* There is no need for an endpoint.
* Focus is on design so no real need to have proper implementation with working testcases covering all edge cases
