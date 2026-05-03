# Working with Lecture Repositories 

The following lecture repositories are intended as tools for self-directed learning:

* [Java Programming by Example](https://github.com/teiniker/teiniker-lectures-java)
* [Software Design by Example](https://github.com/teiniker/teiniker-lectures-softwaredesign)
* [Software Architectures by Example](https://github.com/teiniker/teiniker-lectures-softwarearchitectures)

These repositories consist of MD files, demo examples, exercises, and model 
solutions.

To support self-directed learning with GitHub Copilot, the following activities 
are recommended for each content type:

* **Markdown Files**: MD files explain key concepts and programming techniques 
    to provide foundational knowledge.
    
    - Read the MD files and follow the references.
    
    - Use **Copilot Chat** to ask questions about the concepts and explanations. 
        Discuss the respective answers.

* **Demo Examples**: These are working examples with test cases that demonstrate    
    implementation variants of a specific concept.

    - Read the source code and test cases of the example to understand 
        the concrete implementation of a concept.

    - Use **Copilot Chat** to ask questions about the implementation or 
        possible implementation variants.
    
    - Use **Inline Chat** to refactor parts of the example (verify success 
        by running the tests).

* **Exercises**: Practice examples that include test cases and require you to add       
    specific implementation artifacts to make the tests pass. Each exercise focuses 
    on a particular concept.
    
    - Read the `TODO.txt` file and implement the missing source code artifacts.
        Verify your implementation step by step by running the existing test cases.

    - **Focus on Implementation**: To learn and practice the fundamentals of Java       
        programming, disable **Code Suggestions** and work without **Inline Chat**.
        Ask in **Copilot Chat** if you need specific programming constructs or 
        libraries. Compare your solution with the Model Solution.

    - **Focus on Design and Architecture**: To efficiently implement different 
        design and architectural patterns, use **Code Suggestions** and 
        **Inline Chat**.
        You should be able to understand and evaluate the generated code. 
        
    - **Don't copy the `TODO.txt` file into a Chatbot to generate the solution**:
        It's faster to simply review the Model Solution instead. However, be 
        aware that the learning outcome is minimal if you only skim the finished 
        solution.

* **Model Solutions**: They demonstrate one (of several possible) approaches 
    to solve a particular exercise. 

    - Use **Copilot Chat** to ask questions about the implementation or 
        possible implementation variants.

    - Use **Copilot Chat** to analyze the differences between your solution and 
        the Model Solution. Discuss the different approaches.

This approach works particularly well for working through many small examples and exercises. For larger tasks affecting many source files simultaneously, we will use **Coding Agents**.

*Egon Teiniker, 2024-2026, GPL v3.0*