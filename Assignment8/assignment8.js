////////////////////////////////////////////////////////////
//  CSCE 3193
//  Fall 2019
//  Assignment 8
//  Name: Robert Johnson
////////////////////////////////////////////////////////////


//  You must complete the implementation of the six functions below.
//  In all cases where it is given that the arguments to a function are
//  numbers (or an array of numbers), you can assume that the correct types
//  of values are passed as arguments and don't have to check for the wrong
//  types or invalid input in the script used for testing.


////////////////////////////////////////////////////////////
//  Recursion

function reverseArray(arr) {
	//  Write the body of reverseArray so that it takes an arbitrary
	//  array "arr" as an argument and returns an array with the elements
	//  of arr in the exact opposite order.  For example, if arr = [1,2,3,4]
	//  then this function must return the array [4,3,2,1].
	//  THIS FUNCTION MUST USE RECURSION OR 60% WILL BE DEDUCTED.  Also, for
	//  full credit you must not define inner functions (i.e. reverseArray must
	//  be the recursive function) and it must not use more than one parameter.
	
	
	var n = arr.length;
    // Base case
	if (n < 2) {
		return arr;
	}
	
	// Save first and last elements of array
	var first = arr[0];
	var last = arr[n-1];

	// Recursive call with array, minus first and last elements
	var array1 = reverseArray(arr.slice(1, n-1));
	
	// Add first and last elemtns back on, switched
	array1.unshift(last);
	array1.push(first);
	
	// Return finished array
	return array1;
}

function findMin(arr) {
	//  Write the body of findMin so that it takes a single argument
	//  which is an array of integers (whose length can be assumed
	//  to be at least 1). findMin should return the smallest integer
	//  in the input array.
	//  For example, findMin([8,22,4,58,481]) should return 4, and
	//  findMin([23,4438,23,5,14,3,583,24,7]) should return 3.
	//  THIS FUNCTION MUST USE RECURSION OR 60% WILL BE DEDUCTED
	//  (e.g. there must not be any loops).  Also, for full credit
	//  you must not define inner functions (i.e. findMin must be
	//  the recursive function) and it must not use more than one parameter.
	//  See http://www.w3schools.com/jsref/jsref_obj_array.asp for useful
	//  array functions in JavaScript.
	
	// Base case
	if (arr.length == 1) {
		return arr[0];
	}

	// Compare first element to rest of array
	// If first element is smaller, return that
	if (arr[0] < findMin(arr.slice(1, arr.length)) ) {
		return arr[0];
	}
	// Else, call findMin() on rest of array
	else {
		return findMin(arr.slice(1, arr.length));
	}
}

function stringFromArrays(arr, arr2) {
	//  Write the body of stringFromArrays so that it takes two arguments
	//  which can be assumed to be two arrays of equal length containing strings
	//  and/or numbers. stringFromArrays should return a single string formed
	//  by concatenating the interleaved elements of the two arrays (treating
	//  all elements as strings).
	//  For example, stringFromArrays(["b",221,4],[1,"foo",22]) should return
	//  "b1221foo422" and stringFromArrays([1,"a",3],[2,"b",4]) should return "12ab34".
	//  THIS FUNCTION MUST USE RECURSION OR 60% WILL BE DEDUCTED
	//  (e.g. there must not be any loops).  Also, for full credit
	//  you must not define inner functions (i.e. stringFromArrays must be
	//  the recursive function) and it must not use more than one parameter.
	//  See http://www.w3schools.com/jsref/jsref_obj_array.asp for useful
	//  array functions in JavaScript.
	
	// Base case, return with the element in arr1 added to element in arr2
	if(arr.length == 1 || arr2.length == 1) {
		return arr.concat(arr2);
	}
	
	// Similar to reverseArray
	// Save first and last elements
	var firstArr = arr[0];
	var firstArr2 = arr2[0];
	
	// Then call stringFromArrays() with both arrays reduced by one
	var returnString = stringFromArrays(arr.slice(1, arr.length), arr2.slice(1, arr2.length));
	
	// Join the first elements of both arrays to the returnString, then use .join() to format
	return [arr[0]].concat([arr2[0]].concat(returnString)).join('');
}


////////////////////////////////////////////////////////////
//  Higher order functions

function applyToArray(arr) {
	//  Write the body of applyToArray so that it takes a single
	//  argument which is an array and returns a new function.
	//
	//  Input: The argument 'a' can be assumed to be an array
	//  (which may or may not be empty).
	//
	//  Output: applyToArray must return a function which itself takes a
	//  single argument which can be assumed to be a function (which
	//  we will call 'f' here). 'f' can be assumed to take a single
	//  argument and return a single value.  The function returned
	//  by applyToArray should return an array which is the result of
	//  applying the function f individually to each element of array a.
	//
	//  Examples: Given the definitions of add2 and mult4 at the bottom
	//  of this page, if var f1 = applyToArray([1,2,3,4]), then f1(add2)
	//  returns [3,4,5,6], if var f2 = applyToArray([10,-20,8,0]),
	//  f2(mult4) returns [40,-80,32,0], and if var f3 = applyToArray([]),
	//  f3(add2) returns []
    
    // Define function to return
    return function (f) {
        // Temp array to store results
        var b = [];
        for (elem of arr) {
            // For each element of a, apply f() to it
            // and push it to b
            b.push(f(elem));
        }
        // Return resulting array
        return b;
    }
}

function computeMaxArr(f1, f2) {
	//  Write the body of computeMaxArr so that it takes two functions as arguments
	//  and returns a new function.
	//
	//  Input: Arguments f1 and f2 are assumed to be functions which each take
	//  a single integer argument and return a single integer.
	//
	//  Output: The function returned by computeMaxArr must take a single argument,
	//  an array of integers, and return an array which is the result of
	//  applying either f1 or f2 to each of the elements, where the
	//  the selection of f1 or f2 for each element is determined by which one
	//  returns the larges number.  So, for a three element array arr, the output
	//  would be the array consisting of:
	//  [max(f1(arr[0]), f2(arr[0])), max(f1(arr[1]), f2(arr[1])), max(f1(arr[2]), f2(arr[2]))]
	//  THIS FUNCTION MUST USE RECURSION OR 30% WILL BE DEDUCTED
	//  (e.g. there must not be any loops).
	//
	//  Example: Given the definitions of add2 and mult4 at the bottom of
	//  this page, if var fx = computeMaxArr(add2, mult4), then
	//  fx([-3,-2,-1,0,1,2,3]) = -1,0,1,2,4,8,12
    
    function result(arr) {
        if(arr.length == 1) {
            return [(f1(arr[0]) > f2(arr[0])) ? f1(arr[0]) : f2(arr[0])];
        }

        return result([arr[0]]).concat(result(arr.slice(1)));
    }

    return result;
}


////////////////////////////////////////////////////////////
//  Common closure

function makeClosure() {
	//  Write the body of makeClosure so that it takes no arguments and
	//  returns an array of exactly two functions.  These two functions must be
	//  contained within the same closure.  The closure should contain two variables
	//  which are accessible to both functions.  The first should be called "counter"
	//  and should be initialized to 0.  The second should be called "arr" and should
	//  be initialized to an empty array.
	//  Assuming that the variable "funcs" was used to store the return value from
	//  makeClosure, (i.e."var funcs = makeClosure();"), then the
	//  first function in funcs, which can be referenced as funcs[0], must take exactly
	//  two numbers as arguments (arg1 and arg2).  If the value of "counter" is less
	//  than 3, it should add (arg1 + arg2) and put that sum onto the end of the array "arr".
	//  Otherwise, it should not change "arr".  Then, it should return the array "arr".
	//  The second function returned from makeClosure, funcs[1] from the above
	//  example, must take no arguments and simply increment the value of "counter" by 1
	//  and return nothing.

	//  Example:  If the following series of function calls were made, the correct resulting
	//  output is given.
	//
	//	var funcs = makeClosure();
	//  outStr = funcs[0](1, 2) + "<br>";			// outStr will equal "3"
	//  outStr = funcs[0](3, 4) + "<br>";			// outStr will equal "3, 7"
	//  funcs[1]();									// counter will now equal 1
	//  funcs[1]();									// counter will now equal 2
	//  outStr = funcs[0](5, 6) + "<br>";			// outStr will equal "3, 7, 11"
	//  funcs[1]();									// counter will now equal 3
	//  outStr = funcs[0](7, 8) + "<br>";			// outStr will equal "3, 7, 11"

    var counter = 0;
    var arr = [];

    var returnFunc = [2];

    function func1(arg1, arg2) {
        if( counter < 3 ) {
            arr.push(arg1 + arg2);
        }
        return arr;
    }

    function func2() {
        counter++;
    }

    returnFunc[0] = func1;
    returnFunc[1] = func2;
    return returnFunc;
}

////////////////////////////////////////////////////////////
//  Auxiliary functions (used for testing)

function mult4(i) {
	return i*4;
}

function add2(j) {
	return j+2;
}

function square(k) {
	return k*k;
}