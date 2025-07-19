import exceptions.WrongInputValues;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String[][] digitsPatterns = {
                {
                        "  ###  ",
                        " #   # ",
                        "#     #",
                        "#     #",
                        "#     #",
                        " #   # ",
                        "  ###  "
                },
                {
                        "   #   ",
                        "  ##   ",
                        " # #   ",
                        "   #   ",
                        "   #   ",
                        "   #   ",
                        " ##### "
                },
                {
                        " ##### ",
                        "#     #",
                        "      #",
                        " ##### ",
                        "#      ",
                        "#      ",
                        "#######"
                },
                {
                        " ##### ",
                        "#     #",
                        "      #",
                        " ##### ",
                        "      #",
                        "#     #",
                        " ##### "
                },
                {
                        "#    # ",
                        "#    # ",
                        "#    # ",
                        "#######",
                        "     # ",
                        "     # ",
                        "     # "
                },
                {
                        "#######",
                        "#      ",
                        "#      ",
                        " ##### ",
                        "      #",
                        "#     #",
                        " ##### "
                },
                {
                        " ##### ",
                        "#     #",
                        "#      ",
                        "###### ",
                        "#     #",
                        "#     #",
                        " ##### "
                },
                {
                        "#######",
                        "     # ",
                        "    #  ",
                        "   #   ",
                        "  #    ",
                        "  #    ",
                        "  #    "
                },
                {
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ##### "
                },
                {
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ######",
                        "      #",
                        "#     #",
                        " ##### "
                }
        };
        String input = null;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Enter a number: ");
            input = scanner.nextLine();

            try {
                validateInput(input);
            } catch (WrongInputValues e) {
                System.err.println(e.getMessage());
                continue;
            }
            break;
        } while(true);

        prettyPrintDigits(digitsPatterns, input);
    }

    private static void prettyPrintDigits(String[][] digitsPatterns, String input) {
        for (int j = 0; j < 7; j++ ) {
            StringBuilder line = new StringBuilder();
            for(char currentChar : input.toCharArray()) {
                int index = Character.getNumericValue(currentChar);
                line.append(digitsPatterns[index][j]).append("  ");
            }
            System.out.println(line);
            try {
                TimeUnit.MILLISECONDS.sleep(350);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void validateInput(String input) throws WrongInputValues {
        if(input == null || input.isEmpty()) {
            throw new WrongInputValues("There are no input");
        }
        for(int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new WrongInputValues("Only digits required");
            }
        }
    }
}