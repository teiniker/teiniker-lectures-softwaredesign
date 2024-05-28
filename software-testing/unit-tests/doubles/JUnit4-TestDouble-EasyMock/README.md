# EasyMock

Working with EasyMock’s mocks involves four steps:

1. Creating a mock of the target class
2. Recording its expected behavior, including the action, result, exceptions, etc.
3. Using mocks in tests
4. Verifying if it’s behaving as expected

After our recording finishes, we switch it to **replay mode**, so that the mock 
behaves as recorded when collaborating with any object that will be using it.
Finally, we verify if everything goes as expected.


## References
* [EasyMock](https://easymock.org/)
* [Introduction to EasyMock](https://www.baeldung.com/easymock)
* [Mockito vs EasyMock vs JMockit](https://www.baeldung.com/mockito-vs-easymock-vs-jmockit)

*Egon Teiniker, 2016-2024, GPL v3.0*