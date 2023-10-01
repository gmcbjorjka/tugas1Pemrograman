/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice.oop;

/**
 *
 * @author teguh
 */
public class DuckSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Pilih jenis Duck:");
        System.out.println("1. Mallard Duck");
        System.out.println("2. Rubber Duck");
        System.out.println("3. Decoy Duck");
        System.out.println("4. Model Duck");
        System.out.print("Masukkan nomor pilihan Anda: ");
        
        int choice = scanner.nextInt();
        Duck selectedDuck = null;

        switch (choice) {
            case 1:
                selectedDuck = new MallardDuck();
                break;
            case 2:
                FlyBehavior cantFly = () -> System.out.println("I can't fly");
                QuackBehavior squeak = () -> System.out.println("squeak");
                selectedDuck = new RubberDuck(cantFly, squeak);
                break;
            case 3:
                selectedDuck = new DecoyDuck();
                break;
            case 4:
                selectedDuck = new ModelDuck();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }
        
        System.out.println("Anda telah memilih " + selectedDuck.getClass().getSimpleName());
        
        selectedDuck.performQuack();
        
        if (selectedDuck instanceof ModelDuck) {
            System.out.println("Anda juga dapat mengubah perilaku terbang Model Duck.");
            System.out.println("Apakah Anda ingin Model Duck terbang dengan roket? (ya/tidak)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("ya")) {
                ((ModelDuck) selectedDuck).setFlyBehavior(new FlyRocketPowered());
                selectedDuck.performFly();
            }
        } else {
            selectedDuck.performFly();
        }
        
        scanner.close();
    }
}
