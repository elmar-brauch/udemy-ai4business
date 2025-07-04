# AI 4 Business with Spring AI

This repository show solutions for exercises defined in next sections.<br>
As preparation to start the exercises, you have to:
* Set up a Spring Boot project with https://start.spring.io
  * The required dependencies can be found in pom.xml (you need just one spring-ai-azure-openai or spring-ai-ollama or any other to connect to a different AI service)
  * Connection to LLM service has to be defined in application.properties
* Documentation about Spring AI is here https://docs.spring.io/spring-ai/reference/
* To build this Maven project you need internet connection - set a proxy in Maven config if needed. Build the project with: mvn install
* To connect against Azure OpenAI you need internet connection - set a proxy in ChatServiceTest.java if needed.

## Exercise 1: Send question to LLM
All exercises start by opening file ChatServiceTest.java.
ChatServiceTest contains a single JUnit test for every exercise.
In scope of the exercise open the used class in this test and implement the places marked with TODO.
Exercise can be found in BasicChatService.java in exercise branch.
All exercises start by opening file ChatServiceTest.java.<br>
ChatServiceTest contains a single JUnit test for every exercise.<br>
In scope of the exercise open the used class in this test and implement the places marked with TODO.<br>
Exercise can be found in BasicChatService.java in exercise branch.<br>
Solution can be found in BasicChatService.java in master branch.

## Exercise 2: Send question to LLM using a System Prompt
Exercise can be found in SystemPromptChatService.java in exercise branch.
Exercise can be found in SystemPromptChatService.java in exercise branch.<br>
Solution can be found in SystemPromptChatService.java in master branch.

## Exercise 3: Have a chat with the LLM, so that previous messages are considered
Exercise can be found in MemoryChatService.java in exercise branch.
Exercise can be found in MemoryChatService.java in exercise branch.<br>
Solution can be found in MemoryChatService.java in master branch.

## Exercise 4: Use LLM to parse a text into an instance of a class
Exercise can be found in ParsingChatService.java in exercise branch.
Exercise can be found in ParsingChatService.java in exercise branch.<br>
Solution can be found in ParsingChatService.java in master branch.

## Exercise 5: Send question to LLM, which uses a tool (existing backend functionality)
Exercise can be found in ToolChatService.java in exercise branch.
Solving this exercise with Ollama and a local LLM like llama3.2 is way harder than using GPT 4o-mini.
With llama3.2 you will need tool integration and fine-tuning of system prompt.
Exercise can be found in ToolChatService.java in exercise branch.<br>
Solving this exercise with Ollama and a local LLM like llama3.2 is way harder than using GPT 4o-mini.<br>
With llama3.2 you will need tool integration and fine-tuning of system prompt.<br>
Solution can be found in ToolChatService.java in master branch.

## MCP Exercise: Extend GitHub Copilot with Jira-ID generation by using MCP
Define a tool, which is offered by this Spring Boot application acting as MCP Server.<br>
Setup ToolCallbackProvider Bean in this Spring Boot application.<br>
Implement TODOs defined in classes inside "mcp" package.<br>
Configure GitHub Copilot (Agent Mode) as MCP Client like this:
```json
{
  "servers": {
    "commit-message-generator": {
      "type": "sse",
      "url": "http://localhost:8080/sse"
    }
  }
}
```
This fits to config-values defined in application.properties.
