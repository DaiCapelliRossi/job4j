package lessons;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Lessonseven {
    public static void main(String[] args) {

        System.out.println("First massive");
        int[] numbers = new int[5];
        for(int i = 0; i !=5;i++){
            int value = numbers[i];
            System.out.println(value);
        }
        System.out.println("Second massive");
        for(int i = 0; i != 5; i++){
            numbers[i] = numbers.length - i;
            System.out.println(numbers[i]);
        }


/*
TEST
В тестовом классе нужно прямо инициализировать ячейки:
String[] flats = new String [3];
flats[0] = "a";
flats[1] = "b";
flats[2] = "c";

Улучшенная запись:
String[] flats = {
"a", "b", "c"
};
*/

        // поменять местами 2 элемента
        System.out.println("Changing places");
        int[] data = {5, 3, 2, 1, 4};
        int tmp = data[0]; //tmp для хранения временной переменной
        data[0] = data[3];
        data[3] = tmp;
        System.out.println(Arrays.toString(data));

        System.out.println("Matrix");
        int[][] table = new int [5][5];
        int count = 0;
        for (int out = 0; out != 5; out++) {
            for (int inner = 0; inner != 5; inner++) {
                table[out][inner] = count++;
            }
        }
        for (int index = 0; index != 5; index++) {
            System.out.println(Arrays.toString(table[index]));
        }

        System.out.println("Short way to make Matrix");
        int[][] field = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 1, 0}
        };
        // переместим вторую и третью единицу, чтобы получить линию из единиц ( 1-е [] - индекс внешнего массива, 2-е - значение в массиве)
        int temp = field[1][1]; // 0
        field[1][1] = field[2][1]; // 0 => 1
        field [2][1] = temp; // 1 => 0

        temp = field [0][2]; // 1
        field[0][2] = field[1][2]; // 1 => 0
        field[1][2] = temp; // 0 => 1
        for (int index = 0; index != 3; index++) {
            System.out.println(Arrays.toString(field[index]));
        }
    }
}
