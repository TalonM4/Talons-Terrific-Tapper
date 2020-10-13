package model;

// Represents the innerworkings of the game. Consists of upgrade cost, balance, weapon level, prestige level
// prestige level, stage, level, current enemy health, max enemy health, and list of Bosses
public class GameBackend {

    public  int upgradeCost;
    public int balance;
    public int weaponLevel;
    public double prestigeLevel;
    public int stage;
    public int level;
    public double currentEnemyHealth;
    public double maxEnemyHealth;
    public AllBosses listOfBosses;

    /*EFFECTS: Prestige
    */
    public GameBackend() {
        this.prestigeLevel = 0;
        this.weaponLevel = 1;
        this.balance = 0;
        this.stage = 1;
        this.level = 1;
        this.currentEnemyHealth = 3;
        this.upgradeCost = 1;
        this.maxEnemyHealth = 3;
        this.listOfBosses = new AllBosses();
    }

    //MODIFIES: this
    //EFFECTS: essentially resets the backend, except adding a prestigeLevel
    public void onPrestige() {
        this.prestigeLevel += 1;
        this.balance -= 100;
        stage = 1;
        weaponLevel = 1;
        balance = 0;
        level = 1;
        currentEnemyHealth = 3;
        upgradeCost = 1;
        maxEnemyHealth = 3;

    }

    //MODIFIES: this
    //EFFECTS: returns the amount of damage calculated by the formula 3 x weapon level x (1.05^prestige level)
    public double attackDamageCalculator() {
        return 3 * weaponLevel * (Math.pow(1.05, prestigeLevel));
    }


    public int getBalance() {
        return this.balance;
    }

    public void increaseStageByOne() {
        this.stage += 1;
    }

    //MODIFIES: this
    //EFFECTS: if the damage is greater or equal than the current health of the enemy, the enemy will get killed
    //         if not, the enemy loses the damage calculated
    public boolean onAttack() {
        if (Math.round(currentEnemyHealth - attackDamageCalculator()) <= 0) {
            onKill();
            return true;
        } else {
            currentEnemyHealth -= attackDamageCalculator();
            currentEnemyHealth = Math.round(currentEnemyHealth);
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: creates the next enemy, by taking the current max health and multiplying it by 1.15 and the stage
    //         and set current health to that number. Increases the level by one. Increases balance by the stage
    public void onKill() {
        maxEnemyHealth *= 1.15 * stage;
        currentEnemyHealth = maxEnemyHealth;
        balance += stage;
        if (level + 1 == 10) {
            increaseStageByOne();
            level = 0;
        } else {
            level += 1;
        }
    }


    //REQUIRES: Name to have an associated boss
    //MODIFIES: this
    //EFFECTS:
    public void summonBoss(String name) {
        Boss currentBoss = listOfBosses.stringToBoss(name);
        currentEnemyHealth = currentBoss.health;
    }

}
