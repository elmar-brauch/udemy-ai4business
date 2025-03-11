# AI 4 Business with Spring AI

This repository show solutions for exercises defined in next sections.<br>
As preparation to start the exercises, you have to:
* Setup a Spring Boot project with https://start.spring.io
  * The required dependencies can be found in pom.xml (you need just one spring-ai-azure-openai or spring-ai-ollama or any other to connect to a different AI service)
  * Connection to LLM service has to be defined in application.properties
* Documentation about Spring AI is here https://docs.spring.io/spring-ai/reference/
* To build this Maven project you need internet connection - set a proxy in Maven config if needed. Build the project with: mvn install
* To connect against Azure OpenAI you need internet connection - set a proxy in ChatServiceTest.java if needed.

## Exercise 1: Send question to LLM
Solution can be found in BasicChatService.java
It is tested with ChatServiceTest.java

## Exercise 2: Send question to LLM using a System Prompt
Solution can be found in SystemPromptChatService.java

## Exercise 3: Have a chat with the LLM, so that previous messages are considered
Solution can be found in MemoryChatService.java

## Exercise 4: Send question to LLM, which uses a tool (existing backend functionality)
Solution can be found in ToolChatService.java

## Exercise 5: Use LLM to parse a text into an instance of a class
Solution can be found in ParsingChatService.java
