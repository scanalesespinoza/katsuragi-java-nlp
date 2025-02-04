import java.util.*;

public class OnTheFlyNLP {
    private Map<String, List<String>> knowledgeBase; // Stores learned associations
    private List<String> contextStack; // Tracks conversation context

    public OnTheFlyNLP() {
        knowledgeBase = new HashMap<>();
        contextStack = new ArrayList<>();
        initializeBaseRules();
    }

    // Initialize with some basic rules
    private void initializeBaseRules() {
        knowledgeBase.put("greeting", Arrays.asList("hello", "hi"));
        knowledgeBase.put("farewell", Arrays.asList("bye", "goodbye"));
        knowledgeBase.put("question", Arrays.asList("what", "how", "why"));
    }

    // Process user input and generate a response
    public String processInput(String input) {
        String response = "I'm not sure how to respond to that.";
        input = input.toLowerCase();

        // Check for known patterns
        for (Map.Entry<String, List<String>> entry : knowledgeBase.entrySet()) {
            for (String keyword : entry.getValue()) {
                if (input.contains(keyword)) {
                    response = generateResponse(entry.getKey());
                    break;
                }
            }
        }

        // Learn from the input (simple example: add new words to the knowledge base)
        learnFromInput(input);

        // Update context
        contextStack.add(input);
        if (contextStack.size() > 5) { // Limit context stack size
            contextStack.remove(0);
        }

        return response;
    }

    // Generate a response based on the matched pattern
    private String generateResponse(String pattern) {
        switch (pattern) {
            case "greeting":
                return "Hello! How can I help you?";
            case "farewell":
                return "Goodbye! Have a great day!";
            case "question":
                return "That's an interesting question. Let me think about it.";
            default:
                return "I'm still learning. Can you tell me more?";
        }
    }

    // Learn from the input (simple example: add new words to the knowledge base)
    private void learnFromInput(String input) {
        String[] words = input.split(" ");
        for (String word : words) {
            if (!knowledgeBase.containsKey(word)) {
                knowledgeBase.put(word, new ArrayList<>());
            }
        }
    }

    public static void main(String[] args) {
        OnTheFlyNLP nlp = new OnTheFlyNLP();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the on-the-fly NLP system! Type 'exit' to quit.");
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Bot: " + nlp.processInput(input));
        }

        scanner.close();
    }
}