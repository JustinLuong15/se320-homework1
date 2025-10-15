1. Explain the approach you took to testing your search routine.
   Tell us if you used equivalence partitions, boundary value analysis, etc.,
   including what order you did these things and what process (if any) you used for each.  We are not
   looking for a particular combination of techniques; we're interested in your record of how you selected and
   applied the chosen techniques.  Please include in your write-up any intermediate results (e.g, your textual breakdown of equivalence partitions, etc.); any closed-box
   technique you apply generates intermediate results that are not literally represented as test
   methods written in Java.  If you're unsure what information to include here, you could of course err
   on the side of more information, but really you should just ask.

   - After reading the README, I started with equivalence partitioning. For valid inputs, I used three positions within the array to test, the first, middle, and last. I also tested duplicates where any matching index is acceptable. For inputs where the element is not in the array, I chose a target that sits between existing values, to document the not-found behavior. For invalid inputs, I made sure to test a null array, an empty array, and a null element, each of which must throw an IllegalArgumentException as mentioned in the README. I then cloned the array before the call to make sure that the array was not modifed. 
   Next, I applied boundary value analysis by focusing on single-element arrays both found and not found. After the closed-box suite, I added open-box tests only as needed to hit every branch (equal, go-left, go-right, etc.) to reach 100% branch coverage by following the codes control flow.

2. One part of the requirements above were (identified as) underspecified, yet you still had to make a decision regarding the behavior for those under-specified inputs. Which tests are related to that choice of behavior? Are those closed-box, or open-box tests? Why?

- The part of the requirements that were underspecified was the the fact that we do not need to check for sortedness and we should assume that the arrays are always sorted correctly. I therefore did not create any tests related to that behavior as I intentionally avoided testing unsorted arrays. These tests would be part of closed-box tests because they come from the README and not necessarily from the code structure.

3. Briefly compare your closed-box and open-box tests. Did either approach find bugs in your implementation that the other did not (or would not have)? If not, can you imagine scenarios where it could have? (Hint: closed-box and code-coverage-driven open-box tests are complementary, each is better at finding certain kinds of bugs the other is not as good at finding; see the lecture slides.)

- In this assignment in particular, I did not have any bugs that one tests approach found over the other. However, I can think of a scenario where this could have happened. That would be when the the binary search could have something like high = high - 1 in the code. Where this may pass some closed-box cases but open-box would uncover this mistake as it makes sure that the search steps into the correct branch.