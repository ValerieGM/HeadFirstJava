package SimpleDotComGame;

class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        // for every cell IN locationCells
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length) {
            result = "kill";
        }

        System.out.println(result);

        return result;
    }

    void setLocationCells(int[] locs) {
        locationCells = locs;
    }
}
