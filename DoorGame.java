import java.util.Random;

public class DoorGame {
    Random rand = new Random();
    private final int trials = 10000;

    public void sameChoice() {
        int winsCar = 0;

        for (int i = 1; i <= trials; i++) {
            Door[] doors = assignDoors();
            int fistChoice = rand.nextInt(3);
            if (doors[fistChoice].hasCar()) {
                winsCar++;

            }
        }


        System.out.println("The total percentage of times you won the car is:" + (winsCar / (double) trials) * 100);
    }

    public void differentChoice() {
        int winsCar = 0;

        for (int i = 1; i <= trials; i++) {
            Door[] doors = assignDoors();
            int firstChoice = rand.nextInt(3);
            int revealDoor = revealGoat( doors, firstChoice);
            for(int j = 0; j < doors.length; j++){
                if(j != revealDoor && j != firstChoice){
                    int secondChoice = j;
                    if(doors[secondChoice].hasCar()){
                        winsCar++;
                    }
                }

                }



        }

        System.out.println("The total percentage of times you won the car is:" + (winsCar / (double) trials) * 100);

    }


    public Door[] assignDoors() {
        String[] prizes = {"goat", "goat", "car"};
        Random rand = new Random();

        for (int i = prizes.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = prizes[i];
            prizes[i] = prizes[j];
            prizes[j] = temp;
        }
        Door[] doors = new Door[3];
        for (int i = 0; i < 3; i++) {
            doors[i] = new Door();
            doors[i].setPrize(prizes[i]);

        }

        return doors;


    }

    public int revealGoat(Door[] doors, int firstChoice) {
        for (int i = 0; i < doors.length; i++) {
            if (i != firstChoice && !doors[i].hasCar()) {
                return i;

            }

        }

        throw new IllegalStateException("No valid goat to reveal.");
    }


}
