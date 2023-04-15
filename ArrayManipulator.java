import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split(" ");
            if (command[0].equals("exchange")) {
                if (Integer.parseInt(command[1]) <= numbers.length - 1 && Integer.parseInt(command[1]) >= 0) {
                    numbers = getExchangeArray(command, numbers);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (command[0].equals("max")) {
                if (command[1].equals("even")) {
                    printMaxEvenElement(command, numbers);
                } else if (command[1].equals("odd")) {
                    printMaxOddElement(command, numbers);
                }
            } else if (command[0].equals("min")) {
                if (command[1].equals("even")) {
                    printMinEvenElement(command, numbers);
                } else if (command[1].equals("odd")) {
                    printMinOddElement(command,numbers);
                }
            } else if  (Integer.parseInt(command[1]) == 0) {
                System.out.println("[]");
            } else if (command[0].equals("first")) {
                if (command[2].equals("even")) {
                    printFirstEvenElements(command, numbers);
                } else if (command[2].equals("odd")) {
                    printFirstOddElements(command, numbers);
                }
            } else if (command[0].equals("last")) {
                if (command[2].equals("even")) {
                    printLastEvenElements(command, numbers);
                } else if (command[2].equals("odd")) {
                    printLastOddElements(command, numbers);
                }
            }
            input = scanner.nextLine();
        }
        printArray(numbers);
    }

    public static int[] getExchangeArray(String[] command, int[] numbers) {
        int[] currentNumbersArr = new int[numbers.length];
        for (int i = 0; i < numbers.length - Integer.parseInt(command[1]); i++) {
            for (int j = Integer.parseInt(command[1]) + 1; j < numbers.length; j++) {
                currentNumbersArr[i] = numbers[j];
                i++;
            }
        }
        for (int i = numbers.length - 1 - Integer.parseInt(command[1]); i < numbers.length; i++) {
            for (int j = 0; j <= Integer.parseInt(command[1]); j++) {
                currentNumbersArr[i] = numbers[j];
                i++;
                if (i > numbers.length - 1) {
                    break;
                }
            }
        }
        numbers = currentNumbersArr;
        return numbers;
    }

    public static void printMaxEvenElement(String[] command, int[] numbers) {
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = 0;
        boolean isFound = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] >= maxEven) {
                    maxEven = numbers[i];
                    maxEvenIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(maxEvenIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void printMaxOddElement(String[] command, int[] numbers) {
        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = 0;
        boolean isFound = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                if (numbers[i] >= maxOdd) {
                    maxOdd = numbers[i];
                    maxOddIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void printMinEvenElement(String[] command, int[] numbers) {
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = 0;
        boolean isFound = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                if (numbers[i] <= minEven) {
                    minEven = numbers[i];
                    minEvenIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(minEvenIndex);
        } else {
            System.out.println("No matches");
        }
    }
    public static void printMinOddElement (String[] command, int[] numbers) {
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = 0;
        boolean isFound = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                if (numbers[i] <= minOdd) {
                    minOdd = numbers[i];
                    minOddIndex = i;
                    isFound = true;
                }
            }
        }
        if (isFound) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void printFirstEvenElements(String[] command, int[] numbers) {
        if (Integer.parseInt(command[1]) <= numbers.length && Integer.parseInt(command[1]) > 0) {
            int countEvenElement = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    countEvenElement++;
                    if (countEvenElement == 1) {
                    }
                    if (countEvenElement == Integer.parseInt(command[1])) {
                        break;
                    }
                }
            }
            if (countEvenElement != 0) {
                int[] countEvenArr = new int[countEvenElement];
                int i = 0;
                for (int j = 0; j <= numbers.length; j++) {
                    if (numbers[j] % 2 == 0) {
                        countEvenArr[i] = numbers[j];
                        i++;
                        if (i > countEvenArr.length - 1) {
                            break;
                        }
                    }
                }
                System.out.println(Arrays.toString(countEvenArr));
            } else {
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }

    }

    public static void printFirstOddElements(String[] command, int[] numbers) {
        if (Integer.parseInt(command[1]) <= numbers.length && Integer.parseInt(command[1]) > 0) {
            int countOddElement = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0) {
                    countOddElement++;
                    if (countOddElement == 1) {
                    }
                    if (countOddElement == Integer.parseInt(command[1])) {
                        break;
                    }
                }
            }
            if (countOddElement != 0) {
                int[] countEvenArr = new int[countOddElement];
                int i = 0;
                for (int j = 0; j <= numbers.length; j++) {
                    if (numbers[j] % 2 != 0) {
                        countEvenArr[i] = numbers[j];
                        i++;
                        if (i > countEvenArr.length - 1) {
                            break;
                        }
                    }
                }
                System.out.println(Arrays.toString(countEvenArr));
            } else {
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }

    }

    public static void printLastEvenElements(String[] command, int[] numbers) {
        if (Integer.parseInt(command[1]) <= numbers.length && Integer.parseInt(command[1]) > 0) {
            int countEvenElement = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    countEvenElement++;
                    if (countEvenElement == 1) {
                    }
                    if (countEvenElement == Integer.parseInt(command[1])) {
                        break;
                    }
                }
            }
            if (countEvenElement != 0) {
                int[] countEvenArr = new int[countEvenElement];
                int counter = 0;
                int i = countEvenArr.length - 1;
                for (int j = numbers.length - 1; j >= 0; j--) {
                    if (numbers[j] % 2 == 0) {
                        countEvenArr[i] = numbers[j];
                        i--;
                        counter++;
                        if (counter == countEvenElement) {
                            break;
                        }
                    }
                }
                System.out.println(Arrays.toString(countEvenArr));
            } else {
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }

    }

    public static void printLastOddElements(String[] command, int[] numbers) {
        if (Integer.parseInt(command[1]) <= numbers.length && Integer.parseInt(command[1]) > 0) {
            int countOddElement = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0) {
                    countOddElement++;
                    if (countOddElement == 1) {
                    }
                    if (countOddElement == Integer.parseInt(command[1])) {
                        break;
                    }
                }
            }
            if (countOddElement != 0) {
                int[] countEvenArr = new int[countOddElement];
                int counter = 0;
                int i = countEvenArr.length - 1;
                for (int j = numbers.length - 1; j >= 0; j--) {
                    if (numbers[j] % 2 != 0 ) {
                        countEvenArr[i] = numbers[j];
                        i--;
                        counter++;
                        if (counter == countOddElement) {
                            break;
                        }
                    }
                }
                System.out.println(Arrays.toString(countEvenArr));
            } else {
                System.out.println("[]");
            }
        } else {
            System.out.println("Invalid count");
        }

    }

    public static void printArray(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

}

