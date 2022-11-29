package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.print("Dia de pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();
        Department depart = new Department(departmentName,payDay,new Address(email,phone));

        System.out.print("Quantos funcionários tem o departamento: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++){
            sc.nextLine();
            System.out.println("Dados do funcionário " + i + ":");
            System.out.print("Nome: ");
            String workerName = sc.nextLine();
            System.out.print("Salário: ");
            double workerSalary = sc.nextDouble();
            depart.addEmployee(new Employee(workerName,workerSalary));
        }
        showReport(depart);
        sc.close();
    }
    public static void showReport(Department depart){
        StringBuilder sb = new StringBuilder();
        sb.append("\nFOLHA DE PAGAMENTO:\n");
        sb.append("Departamento " + depart.getName() + " R$ " + String.format("%.2f",depart.payroll()));
        sb.append("\nPagamento realizado no dia " + depart.getPayDay());
        sb.append("\nFuncionários:\n");
        for (Employee e : depart.getEmployees()){
            sb.append(e.getName() + "\n");
        }
        sb.append("Para duvidas entrar em contato: " + depart.getAddress().getEmail());
        String text = sb.toString();
        System.out.println(text);
    }
}
