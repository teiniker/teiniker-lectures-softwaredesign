# GitHub Copilot 

GitHub Copilot is an AI-powered coding assistant developed by GitHub 
in collaboration with OpenAI, it uses large language models (LLMs) 
to suggest code, functions, and documentation in real-time within 
our Integrated Development Environment (IDE).

Core capabilities of GitHub Copilot:

* **Code Suggestions**: As we type, Copilot predicts the next 
    lines of code based on our current file, open tabs, and even 
    comments.  

	We can write a comment like 
    `// function to calculate distance between two GPS coordinates` 
    and Copilot will generate the implementation.


* **Copilot Chat**: A conversational sidebar that allows us to ask 
    questions like `"How does this function work?"` or 
    `"Refactor this to use async/await."`.  

* **Inline Chat**: A real-time conversational interface within our 
	code editor that allows us to ask GitHub Copilot questions and 
	receive contextual suggestions without leaving your editor window. 
	We can use it to explain code, generate snippets, refactor 
	existing code, or ask for help debugging. 
	
	Simply we highlight code or position our cursor and start a 
	chat session to get immediate assistance tailored to our 
	current work.

* **Agentic Workflows**: In its latest 2026 updates, Copilot can 
    act as an "AI Agent," autonomously planning multi-step tasks, 
    running tests, and opening Pull Requests.

## Code Suggestions

* [Getting code suggestions in your IDE with GitHub Copilot](https://docs.github.com/en/copilot/how-tos/get-code-suggestions/get-ide-code-suggestions)
	- Getting code suggestions:
		- Start typing code... `[Tab]`
		- Describe somethin you want within a comment... `[Tab]` 

	- Showing alternative suggestions: 
		- Next: `[Alt]+ ]` 
		- Previous: `[Alt]+ [`
		
		To accept a suggestion, click `[Accept]` in the Copilot command palette, or press `[Tab]`.

	- Accepting partial suggestions: ´[Ctrl] + [→]´


## Copilot Chat  

* [Getting started with prompts for GitHub Copilot Chat](https://docs.github.com/en/copilot/how-tos/chat-with-copilot/get-started-with-chat)

	You can ask Copilot Chat specific questions about your project or general software questions. You can also ask Copilot Chat to write code, fix errors, write tests, and document code.

	- **Ask general software questions**: You can ask Copilot Chat general software questions. 
	
		_Example_: tell me about nodejs web server frameworks

	- **Ask questions about your project**: You can ask Copilot Chat questions about your project.

		_Example_: what sorting algorithm does this function use

		To give Copilot the correct context, try some of these strategies:
		- Highlight relevant lines of code.
		- Use chat variables like `#selection`, `#file`, `#editor`, `#codebase`, or `#git`.
		- Use the `@workspace` chat participant.

	- **Write code**: You can ask Copilot to write code for you. 
	
		_Example_: write a function to sum all numbers in a list

		When Copilot returns a code block, the response includes options to copy the code, 
		or to insert the code at your cursor, into a new file, or into the terminal.

	GitHub Copilot Chat offers **several modes**, each designed for a different
    level of autonomy and interaction:

	| Mode | Purpose | File Changes | Tool Use |
	|------|---------|--------------|----------|
	| **Ask** | Answer questions, explain code, navigate codebase | None (read-only) | Read-only tools |
	| **Edit** | Apply targeted edits to specific files | Yes, direct edits | Limited |
	| **Agent** | Autonomous multi-step task execution | Yes | Full (terminal, files, search) |
	| **Plan** | Reason through a task and produce a plan before acting | Deferred | Reasoning only |

	**Ask vs. Plan**:

	- **Ask** is for *understanding* — "how does X work?", "where is Y defined?". It never modifies anything.

	- **Plan** is for *designing before doing* — you describe a complex task, the model reasons through it and produces a structured execution plan for your review *before* any code is written or commands are run.


## Prompt Engineering 

* [Prompt engineering for GitHub Copilot Chat](https://docs.github.com/en/copilot/concepts/prompting/prompt-engineering)


## References 

* [Get to know GitHub Copilot in VS Code and be productive IMMEDIATELY](https://youtu.be/jXp5D5ZnxGM?si=jJsmeyDQFjkbAwR_):

* [Best practices for using GitHub Copilot](https://docs.github.com/en/copilot/get-started/best-practices)


*Egon Teiniker, 2024-2026, GPL v3.0*