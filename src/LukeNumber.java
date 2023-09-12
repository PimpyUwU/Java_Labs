public class LukeNumber {
    private static int number = 1;
    private static int value = 2;
    private static int prevValue = 0;

    /**
     * Method to calculate the next Lucas number and update the state.
     */
    public static void nextValue() {
        if (number == 1) {
            value = 1;
            prevValue = 2;
        } else {
            value = prevValue + value;
            prevValue = value - prevValue;
        }

        number++;
    }

    /**
     * Method to get the current Lucas number.
     *
     * @return The current Lucas number.
     */
    public static int getValue() {
        return value;
    }

    /**
     * Method to get the previous Lucas number.
     *
     * @return The previous Lucas number.
     */
    public static int getPrevValue() {
        return prevValue;
    }

    /**
     * Method to get the number of the current Lucas number.
     *
     * @return The number of the current Lucas number.
     */
    public static int getNumber() {
        return number;
    }
}