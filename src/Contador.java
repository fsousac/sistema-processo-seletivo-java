import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner dataIn = new Scanner(System.in);
        System.out.println("Digite o primeiro numero:");
        int firstNum = dataIn.nextInt();
        System.out.println("Digite o segundo numero:");
        int secondNum = dataIn.nextInt();

        try {
            contar(firstNum,secondNum);
        } catch (ParametrosInvalidosException e){
            System.out.println("O primeiro parametro deve ser menor que o segundo!");
        }
    }

    static void contar(int num1, int num2) throws ParametrosInvalidosException{
        if (num2<num1){
            throw new ParametrosInvalidosException();
        }
        else {
            int total = num2 - num1;
            for (int i= 1;i<=total; i++){
                System.out.println("Imprimindo o número " + i);
            }
        }


    }



}
