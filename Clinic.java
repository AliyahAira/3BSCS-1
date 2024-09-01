import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Dog");
            System.out.println("[2] Cat");
            System.out.println("[3] Exit");
            System.out.print("\nChoose your pet number: ");
            int choice = input.nextInt();

            if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            }

            PetRecord petFile = new PetRecord();
            Pet pet = null;

            switch (choice) {
                case 1:
                    pet = new Dog();
                    petFile.setPetId("D01");
                    petFile.setPetName("Bantay");
                    petFile.setPet(pet);
                    ((Dog) pet).setBreed("German Shepherd");
                    displayPetDetails(petFile, ((Dog) pet).getBreed());
                    break;
                case 2:
                    pet = new Cat();
                    petFile.setPetId("C01");
                    petFile.setPetName("Muning");
                    petFile.setPet(pet);
                    ((Cat) pet).setNoOfLives(9);
                    displayPetDetails(petFile, ((Cat) pet).getNoOfLives());
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        input.close();
    }

    private static void displayPetDetails(PetRecord petFile, Object specificDetail) {
        System.out.println("Pet id is " + petFile.getPetId());
        System.out.println("Pet name is " + petFile.getPetName());
        System.out.println("Pet kind: " + petFile.getPet().getClass().getSimpleName());
        System.out.println("Communication sound: " + petFile.getPet().makeSound());
        System.out.println("Play mode: " + petFile.getPet().play());

        // Display specific detail based on the pet type
        if (specificDetail instanceof String) {
            System.out.println("Breed: " + specificDetail);
        } else if (specificDetail instanceof Integer) {
            System.out.println("Number of lives: " + specificDetail);
        }
    }
}
