import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        gerenciadordearquivos gerenciador = new gerenciadordearquivos("resultados.txt");

        while (true) {
            System.out.println("\n=== Calculadora ===");
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Ver resultados salvos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            }

            if (opcao == 5) {
                gerenciador.lerResultados();
                continue;
            }

            System.out.print("Digite o primeiro número: ");
            double a = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double b = scanner.nextDouble();

            try {
                double resultado;
                String operacao;
                switch (opcao) {
                    case 1:
                        resultado = calc.somar(a, b);
                        operacao = "Soma";
                        break;
                    case 2:
                        resultado = calc.subtrair(a, b);
                        operacao = "Subtração";
                        break;
                    case 3:
                        resultado = calc.multiplicar(a, b);
                        operacao = "Multiplicação";
                        break;
                    case 4:
                        resultado = calc.dividir(a, b);
                        operacao = "Divisão";
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        continue;
                }
                System.out.printf("Resultado: %.2f\n", resultado);
                gerenciador.salvarResultado(operacao, a, b, resultado);
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
