package org.avpa.fakehacking;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Quick menu prompter class for HyperSkill's banking project
 */
public class MenuSelector {
    /**
     * Response option for {@link MenuSelector}
     * @param <T> The type of the return type/description
     */
    public static class ResponseOption <T> {
        String identifier;
        T description;
        Runnable validityConsumer;
        Class<?> resultClass;

        /**
         * Create a response (answer) to a prompt.
         * @param identifier The text by which this option should be referred to with.
         * @param description Further elaborate on this text.
         * @param validityConsumer if the option is picked, this code will be run.
         * @param resultCast the type the description should be cast to, if it is picked in {@link #prompt()}.
         */
        public ResponseOption(String identifier, T description, Runnable validityConsumer, Class<?> resultCast) {
            this.identifier = identifier;
            this.description = description;
            this.validityConsumer = validityConsumer;
            this.resultClass = resultCast;
        }

        /**
         * Shorthand for {@link #ResponseOption(String, Object, Runnable, Class)}
         * @return a new {@link ResponseOption} instance.
         */
        public static <T> ResponseOption<T> of(String identifier, T description, Runnable individualValidityConsumer) {
            return new ResponseOption<>(identifier, description, individualValidityConsumer, description.getClass());
        }

        @Override
        public String toString() {
            return String.format("%s %s", identifier, description);
        }
    }

    List<ResponseOption<?>> responseOptions;
    String menuTitle;

    public MenuSelector(String menuTitle, ResponseOption<?>... responseOptions) {
        this.responseOptions = List.of(responseOptions);
        this.menuTitle = menuTitle;
    }

    public void print() {
        System.out.printf("%s%s%n", menuTitle, responseOptions.stream()
                .map(ResponseOption::toString)
                .reduce("", (x, y) -> String.format("%s\n%s", x, y)));
    }

    @SuppressWarnings("unchecked")
    public <T> T prompt() {
        print();
        System.out.printf("%nType Your Response:%n>> ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        Optional<ResponseOption<?>> selected = handleInput(response);

        if (selected.isPresent()) {
            ResponseOption<?> actualSelection = selected.get();
            actualSelection.validityConsumer.run();
            return ((T) actualSelection.resultClass.cast(actualSelection.description));
        } else {
            System.out.printf("%n%s was not a valid descriptor, please try again.%n%n", response);
            return prompt();
        }
    }

    public Optional<ResponseOption<?>> handleInput(String input) {
        for (ResponseOption<?> responseOption : responseOptions) {
            if (responseOption.identifier.replaceAll("\\.$", "").equals(input)) {
                return Optional.of(responseOption);
            }
        }
        return Optional.empty();
    }


}
