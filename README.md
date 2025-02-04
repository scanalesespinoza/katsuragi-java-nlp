# On-the-Fly NLP Library in Java

Welcome to the **On-the-Fly NLP Library**! This library demonstrates a **foundational** Natural Language Processing (NLP) system in Java that learns dynamically without requiring a traditional offline training phase.

---

## Overview

- **Rule-Based System**: Responds to user input based on predefined patterns.
- **On-the-Fly Learning**: Learns new words or phrases from user input in real time.
- **Context Handling**: Maintains a simple conversation history to support coherent responses.

**Current Stage**: Stage 1 (Foundational)

---

## File Download

Click the link below to view or download the Java source file:

- **[OnTheFlyNLP.java](OnTheFlyNLP.java)**

<details>
<summary>Alternatively, copy the complete code here:</summary>

\`\`\`java
/**
 * OnTheFlyNLP.java
 *
 * A simple Java program demonstrating foundational, on-the-fly NLP:
 * - Basic rule-based responses for greetings/farewells/questions
 * - Dynamic learning of new words
 * - Simple context handling
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnTheFlyNLP {

    // A map to store known patterns and responses
    private Map<String, String> knowledgeBase;

    // A simple list to store context or conversation history
    private List<String> context;

    public OnTheFlyNLP() {
        knowledgeBase = new HashMap<>();
        context = new ArrayList<>();

        // Preload some basic knowledge
        knowledgeBase.put("hello", "Hello! How can I help you?");
        knowledgeBase.put("hi", "Hi there! What can I do for you?");
        knowledgeBase.put("bye", "Goodbye! Have a great day!");
        knowledgeBase.put("exit", "Exiting the conversation.");

        // You can add more initial rules as needed
    }

    /**
     * Process user input and generate a response.
     *
     * @param input The user input string
     * @return A response based on the knowledge base or learned data
     */
    public String processInput(String input) {
        // Add to context (conversation history)
        context.add(input);

        // Normalize the input (simple lowercase trimming)
        String normalizedInput = input.trim().toLowerCase();

        // Check if the knowledgeBase contains a response
        for (Map.Entry<String, String> entry : knowledgeBase.entrySet()) {
            if (normalizedInput.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        // If there's no direct match, learn from it
        learnNewWord(normalizedInput);

        // Return a generic response if no direct rule is found
        return "I haven't learned how to respond to that yet, but I'll remember it.";
    }

    /**
     * Learn a new word or pattern from user input.
     * You can customize how the system learns.
     *
     * @param newWord The word or phrase to learn
     */
    private void learnNewWord(String newWord) {
        // Simple approach: if it's not in the knowledgeBase, store it with a placeholder
        if (!knowledgeBase.containsKey(newWord) && !newWord.isEmpty()) {
            // For demonstration, categorize anything with "hey" as a greeting
            if (newWord.contains("hey")) {
                knowledgeBase.put("hey", "Hey there! How's it going?");
            } else {
                // Add a placeholder response for everything else
                knowledgeBase.put(newWord, "Interesting! Can you tell me more?");
            }
        }
    }

    public static void main(String[] args) {
        OnTheFlyNLP bot = new OnTheFlyNLP();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the on-the-fly NLP system! Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            // Check for exit condition
            if (userInput.trim().equalsIgnoreCase("exit")) {
                System.out.println("Bot: " + bot.processInput(userInput));
                break;
            }

            // Process the input and print the bot's response
            String response = bot.processInput(userInput);
            System.out.println("Bot: " + response);
        }

        scanner.close();
        System.out.println("Conversation ended.");
    }
}
\`\`\`
</details>

---

## Requirements

- **Java Development Kit (JDK)** 8 or later
- **Git** (optional, for cloning the repository)

---

## Installation & Usage

1. **Clone or Download** this repository.
   \`\`\`bash
   git clone https://github.com/your-username/on-the-fly-nlp-java.git
   \`\`\`
2. **Navigate** into the project folder.
   \`\`\`bash
   cd on-the-fly-nlp-java
   \`\`\`
3. **Compile** the Java file.
   \`\`\`bash
   javac OnTheFlyNLP.java
   \`\`\`
4. **Run** the program.
   \`\`\`bash
   java OnTheFlyNLP
   \`\`\`
5. **Interact** with the bot. Type messages and see how it responds. Type \`exit\` to quit.

---

## Example Interaction

\`\`\`
Welcome to the on-the-fly NLP system! Type 'exit' to quit.
You: Hello
Bot: Hello! How can I help you?
You: What's your name?
Bot: I'm just a simple chatbot. I don't have a name yet!
You: Bye
Bot: Goodbye! Have a great day!
\`\`\`

---

## Contributing

1. **Fork** the repository.
2. Create a **new branch** for your feature or fix.
3. **Commit** your changes.
4. **Submit** a pull request.

---

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, or distribute the code.

---

### Acknowledgments

- Inspired by the need for lightweight, dynamic NLP systems.
- Built with ❤️ for learners and developers.