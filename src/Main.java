import exceptions.WrongInputValues;

import java.util.Scanner;

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
                {  // 2
                        " ##### ",
                        "#     #",
                        "      #",
                        " ##### ",
                        "#      ",
                        "#      ",
                        "#######"
                },
                {  // 3
                        " ##### ",
                        "#     #",
                        "      #",
                        " ##### ",
                        "      #",
                        "#     #",
                        " ##### "
                },
                {  // 4
                        "#    # ",
                        "#    # ",
                        "#    # ",
                        "#######",
                        "     # ",
                        "     # ",
                        "     # "
                },
                {  // 5
                        "#######",
                        "#      ",
                        "#      ",
                        " ##### ",
                        "      #",
                        "#     #",
                        " ##### "
                },
                {  // 6
                        " ##### ",
                        "#     #",
                        "#      ",
                        "###### ",
                        "#     #",
                        "#     #",
                        " ##### "
                },
                {  // 7
                        "#######",
                        "     # ",
                        "    #  ",
                        "   #   ",
                        "  #    ",
                        "  #    ",
                        "  #    "
                },
                {  // 8
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ##### ",
                        "#     #",
                        "#     #",
                        " ##### "
                },
                {  // 9
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