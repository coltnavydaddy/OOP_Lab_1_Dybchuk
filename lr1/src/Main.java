import java.util.Scanner; // щоб приймати дату від користувача;
import java.util.Arrays; // щоб працювати с масивом;

public class Main {

    // завдання №1 : метод, який буде приймати масив цілих чисел та повертати true,
    //якщо кожен наступнийелемент більше чи дорівнює попередньому;

    private static boolean taskFirst (int[] array) {

        boolean resultOfTask1 = true; // булева змінна для результату;

        for (int i = 0; i < array.length-1; i++) {

            // якщо наступний елемент менше за попередній, то false
            if (array[i + 1] < array[i]) {

                resultOfTask1 = false;
                break;
            }
        }

        return resultOfTask1;
    }

    // завдання №2: гра FizzBuzz. замість чисел які діляться на три програма має виводити Fizz, якщо діляться 5, то Buzz.
    // якщо обидві умови виконуються, то виведеться «FizzBuzz»

    private static void Fizz_BuzzGame() {
        int stringScore = 0;
        for (int i = 1; i <= 100; i++) {

            if(i %3 == 0 && i %5 == 0) {
                System.out.print("FizzBuzz ");

                stringScore++;
            }

            else if(i%3 == 0) {
                System.out.print("Fizz ");

                stringScore++;
            }

            else if(i%5 == 0) {
                System.out.print("Buzz ");

                stringScore++;
            }

            else {
                System.out.print(i + " ");

                stringScore++;
            }
            // якщо кількість чисел та слів ділиться націло на 10, то робимо "Enter"
            if (stringScore % 10 == 0) {
                System.out.println();
            }
        }
    }

    // завдання №3: зробити метод, який приймає масив цілих чисел і повертає true якщо масив можна розділити так,
    // що сума цих чисел в обо частинах була рівною та false якщо це не так.


    // ідемо по масиву починаючи з другого елементу, і порівнюємо : припустимо елементів буде три, це 1 2 3.
    // функція порівнює суму між 1 2 та 3. 3 буде == 3, тому повернеться true.в інших випадках алгоритм повториться.

    private static boolean SumSeparation(int[] array){
        for (int i = 1; i < array.length; i++){

            if ( GetArraySum(0, i, array) == GetArraySum(i,array.length,array) ) {

                return true;
            }
        }
        return false;
    }

    // функція, якою будемо рахувати суму від початку до кінця у масиві (початок та кінець - наші аргументи, тому
    // в основній функції використаємо це належним чином;
    private static int GetArraySum(int start, int end, int[] array) {

        int sum = 0;

        for (int i =start; i < end; i++) {

            sum+=array[i];
        }

        return sum;
    }


    public static void main(String[] args) {

        //cтворимо сканер,яким будемо вводити числа з клавіатури;
        Scanner scan = new Scanner(System.in);

        System.out.println("Розмір масиву:");
        int count = scan.nextInt();

        System.out.println("Введіть цілочисельний масив:");

        //створимо динамічний масив, який заповнимо через цикл for
        int[] Array = new int[count];
        for (int i = 0; i < Array.length; i++) {
            Array[i] = scan.nextInt();
        }

        System.out.println("Масив:");
        //виведемо масив за допомогою метода toString з класу Arrays:
        System.out.print(Arrays.toString(Array) );


        System.out.print("\nКожен елемент у масиві більше або дорівнює попередньому?: " + taskFirst(Array) );

        System.out.println("\nFizz_Buzz");
        Fizz_BuzzGame();

        System.out.println("\nСуми обох частин масиву рівні?:");
        System.out.println(SumSeparation(Array) );
    }
}



