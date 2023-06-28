//*********************************************************************************
//  Main.java (RPG Project)    Created by: Jaden Mathew
//
//  Main.java includes all the necessary classes to complete my very own RPG Project namely Cyber Nexus. Abstract classes are used to create Players and Enemies (using Abstract Character class) and Levels. 
// Users can play this game by entering their name, player choice, difficulty level, and range of actions like Attack, Super Attack, and Taunt. Once they start playing, there are levels you must complete to complete the game! Enjoy!
//*********************************************************************************
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Abstract Character Class
abstract class Character {
    protected String name;
    protected int health;
    protected int armor;
    protected int energy;
    protected int damage;

    // Constructor
    public Character(String name, int health, int armor, int energy, int damage) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.energy = energy;
        this.damage = damage;
    }

    // Getters for the character's name, armor, energy, and health
    public String getName() {
        return name;
    }

    public int getArmor() {
        return armor;
    }
    public int getEnergy() {
        return energy;
    }
    public int getHealth() {
        return health;
    }

    // Reduces the character's health by the given damage
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    // Checks if the character is alive (health greater than 0)
    public boolean Die() {
        return health > 0;
    }

    // Abstract methods that subclasses must implement
    public abstract void move();

    public abstract void attack(Character target);

    public abstract void superAttack(Character target);

    public abstract void taunt(Character target);

    public abstract void showLevels();
}

// Player Class (Character inheritance)
abstract class Player extends Character {
    protected ClassType classType;

    // Constructor
    public Player(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }

    // Abstract method to get the player's class type
    public abstract ClassType getClassType();
}


// Technomancer Class (Player inheritance)
class Technomancer extends Player {

  private String weapon = "Sword";
    // Constructor
    public Technomancer(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }

    // Overrides the abstract methods from the parent class
    public void move() {
        System.out.println("***** Congratulations! " + name + " moves to the next room. *****");
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + ". Damage: " + damage);
        target.takeDamage(damage);
    }

    public void superAttack(Character target) {
        System.out.println(name + " super attacks " + target.getName() + ". Damage " + damage * 2);
        target.takeDamage(damage * 2);
    }

    public void taunt(Character target) {
        System.out.println(name + " taunts " + target.getName());
    }

    public void equipWeapon() {
        System.out.println(name + " is equipped with weapon" + weapon);
    }

    public void showLevels() {
        System.out.println("Stats for " + name + ": " + "Health: " + this.health + " | Armor: " + this.armor + " | Energy: " + this.energy + " | Damage: " + this.damage);
    }

    // Overrides the abstract method from the parent class
    public ClassType getClassType() {
        return ClassType.TECHNOMANCER;
    }
}

// Shadown Agent Class (Player inheritance)
class ShadowAgent extends Player {

  private String weapon = "Sword";
    // Constructor
    public ShadowAgent(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }

    // Overrides the abstract methods from the parent class
    public void move() {
        System.out.println("***** Congratulations! " + name + " moves to the next room. *****");
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + ". Damage " + damage);
        target.takeDamage(damage);
    }

    public void superAttack(Character target) {
        System.out.println(name + " super attacks " + target.getName() + ". Damage " + damage * 2);
        target.takeDamage(damage * 2);
    }

    public void taunt(Character target) {
        System.out.println(name + " taunts " + target.getName());
    }

    public void equipWeapon() {
        System.out.println(name + " is equipped with weapon" + weapon);
    }

    public void showLevels() {
        System.out.println("Stats for " + name + ": " + "Health: " + this.health + " | Armor: " + this.armor + " | Energy: " + this.energy + " | Damage: " + this.damage);
    }

    // Overrides the abstract method from the parent class
    public ClassType getClassType() {
        return ClassType.SHADOWAGENT;
    }
}

// Mech Trooper class (Player inheritance)
class MechTrooper extends Player {

  private String weapon = "Sword";
    // Constructor
    public MechTrooper(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }

    // Overrides the abstract methods from the parent class
    public void move() {
        System.out.println("***** Congratulations! " + name + " moves to the next room. *****");
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + ". Damage " + damage);
        target.takeDamage(damage);
    }

    public void superAttack(Character target) {
        System.out.println(name + " super attacks " + target.getName() + ". Damage " + damage * 2);
        target.takeDamage(damage * 2);
    }

    public void taunt(Character target) {
        System.out.println(name + " taunts " + target.getName());
    }

   public void equipWeapon() {
        System.out.println(name + " is equipped with weapon" + weapon);
    }
    public void showLevels() {
        System.out.println("Stats for " + name + ": " + "Health: " + this.health + " | Armor: " + this.armor + " | Energy: " + this.energy + " | Damage: " + this.damage);
    }

    // Overrides the abstract method from the parent class
    public ClassType getClassType() {
        return ClassType.MECHTROOPER;
    }
}


// Enemy Class (inherits from Character)
abstract class Enemy extends Character {
    // Constructor
    public Enemy(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }
}

// Mob Class (inherits from Enemy)
class Mob extends Enemy {
    public Mob(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }

    // Overrides the abstract methods from the parent class
    public void move() {
        System.out.println("***** Congratulations! " + name + " moves to the next room. *****");
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + ". Damage " + damage);
        target.takeDamage(damage);
    }

    public void superAttack(Character target) {
        System.out.println(name + " super attacks " + target.getName() + ". Damage " + damage * 2);
        target.takeDamage(damage * 2);
    }

    public void taunt(Character target) {
        System.out.println(name + " taunts " + target.getName());
    }

    public void showLevels() {
        System.out.println("Stats for " + name + ": " + "Health: " + this.health + " | Armor: " + this.armor + " | Energy: " + this.energy + " | Damage: " + this.damage);
    }
}

// Warrior class (placeholder)
class Warrior
  {
    public Warrior(){
      
    }
    public String Attack(){
      return "Player attacks Warrior.";
    }
    public String toString()
    {
      return "Hello, I am a Warrior!";
    }
  }

// Ranger class (placeholder)
class Ranger
  {
    public Ranger(){
      
    }
    public String Attack(){
      return "Player attacks Ranger.";
    }
    public String toString()
    {
      return "Hello, I am a Ranger!";
    }
  }

// Mage class (placeholder)
class Mage
  {
    public Mage(){
      
    }
    public String Attack(){
      return "Player attacks Mage.";
    }
    public String toString()
    {
      return "Hello, I am a Mage!";
    }
  }

// Abstract Level class
abstract class Level {

    // Protected instance variables
    protected int levelNumber;
    protected Difficulty difficulty;

    // Level constructor
    public Level(int levelNumber, Difficulty difficulty) {
        this.levelNumber = levelNumber;
        this.difficulty = difficulty;
    }

  public String toString()
  {
    return "Hello";
  }
    // Getter methods
    public int getLevelNumber() {
        return levelNumber;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public abstract List<Enemy> getEnemies();
}

// Regular class (Inherited from Level)
class RegularLevel extends Level {

    // Constructor
    public RegularLevel(int levelNumber, Difficulty difficulty) {
        super(levelNumber, difficulty);
    }

    // Overrides the abstract method from the parent class
    public List<Enemy> getEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Mob("Warrior", 30, 10, 10, 10));
        enemies.add(new Mob("Ranger", 35, 12, 10, 10));
        enemies.add(new Mob("Mage", 40, 15, 10, 10));
        return enemies;
    }
}

// BossLevel class (inherited from Level)
class BossLevel extends Level {
    private Boss boss;

    // Constructor
    public BossLevel(int levelNumber, Difficulty difficulty, Boss boss) {
        super(levelNumber, difficulty);
        this.boss = boss;
    }

    // BossLevel getters
    public Boss getBoss() {
        return boss;
    }

    public List<Enemy> getEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(boss);
        return enemies;
    }
}

// Boss class (inherited from Enemy)
class Boss extends Enemy {

    // Constructor
    public Boss(String name, int health, int armor, int energy, int damage) {
        super(name, health, armor, energy, damage);
    }

    // Overrides the abstract methods from the parent class
    public void move() {
        System.out.println("Boss moves to the next room.");
    }

    public void attack(Character target) {
        System.out.println("Boss attacks " + target.getName() + " with damage " + damage);
        target.takeDamage(damage);
    }

    public void superAttack(Character target) {
        System.out.println("Boss super attacks " + target.getName() + " with damage " + damage * 2);
        target.takeDamage(damage * 2);
    }

    public void taunt(Character target) {
        System.out.println("Boss taunts " + target.getName());
    }

    public void showLevels() {
        System.out.println("Stats for " + name + ": " + "Health: " + this.health + " | Armor: " + this.armor + " | Energy: " + this.energy + " | Damage: " + this.damage);
    }
}

// Items Class
class Items {
    // Private instance variables
    private String name;
    private int damageGain;
    private int armorGain;
    private int healthGain;
    private int energyGain;
    private ClassType classType;

    // Constructor
    public Items(String name, int damageGain, int armorGain, int healthGain, int energyGain, ClassType classType) {
        this.name = name;
        this.damageGain = damageGain;
        this.armorGain = armorGain;
        this.healthGain = healthGain;
        this.energyGain = energyGain;
        this.classType = classType;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getDamageGain() {
        return damageGain;
    }

    public int getArmorGain() {
        return armorGain;
    }

    public int getHealthGain() {
        return healthGain;
    }

    public int getEnergyGain() {
        return energyGain;
    }

    public ClassType getClassType() {
        return classType;
    }

    public String toString() {
        return " earned new reward " + name + "! Gained Health: " + healthGain + " Armor: " + armorGain + " | Energy: " + energyGain + " | Damage Reversal: " + damageGain;
    }
}

// Uses enum to chart difficulty (easy, medium, or hard)
enum Difficulty {
    EASY,
    MEDIUM,
    HARD
}

// Uses enum for ClassType (Technomancer, ShadowAgent, MechTrooper)
enum ClassType {
    TECHNOMANCER,
    SHADOWAGENT,
    MECHTROOPER
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reads the player's name from the console
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.println("Select a class:");
        System.out.println("1. Technomancer");
        System.out.println("2. Shadow Agent");
        System.out.println("3. Mech Trooper");
        System.out.print("Enter your choice (1, 2 or 3): ");
        int classChoice = scanner.nextInt(); // Reads the player's class choice from the console
        scanner.nextLine();

        System.out.println("Select a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter your choice (1, 2 or 3): ");
        int difficultyChoice = scanner.nextInt(); // Reads the difficulty level choice from the console
        scanner.nextLine();

        Difficulty difficulty;
        switch (difficultyChoice) { // Determines the selected difficulty based on the choice
            case 1:
                difficulty = Difficulty.EASY;
                break;
            case 2:
                difficulty = Difficulty.MEDIUM;
                break;
            case 3:
                difficulty = Difficulty.HARD;
                break;
            default:
                System.out.println("Invalid difficulty choice. Defaulting to Easy difficulty.");
                difficulty = Difficulty.EASY;
                break;
        }

        Player player;
        switch (classChoice) { // Determines the player's class based on the choice
            case 1:
                player = new Technomancer(playerName, 500, 20, 10, 10);
                break;
            case 2:
                player = new ShadowAgent(playerName, 300, 15, 10, 10);
                break;
            case 3:
                player = new MechTrooper(playerName, 100, 10, 10, 10);
                break;
            default:
                System.out.println("Invalid class choice. Defaulting to Technomancer class.");
                player = new Technomancer(playerName, 100, 20, 10, 10);
                break;
        }

        List<Level> levels = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            if (i == 5) { // Adds a boss level at the end
                levels.add(new BossLevel(i, difficulty, new Boss("Boss", 50, 75, 10, 30)));
            } else {
                levels.add(new RegularLevel(i, difficulty)); // Adds regular levels
            }
        }

        Random random = new Random();
        for (Level level : levels) { // Iterates over each level
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Welcome " + player.getName() + ", to Level " + level.getLevelNumber() + " (" + level.getDifficulty() + "). You are a " + player.getClassType());
            player.showLevels(); // Displays player's levels
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            List<Enemy> enemies = level.getEnemies(); // Retrieves the enemies for the level
            for (Enemy enemy : enemies) { // Iterates over each enemy
                System.out.println("There are " + enemies.size() + " enemies in this room. You are fighting " + enemy.getName());
                while (enemy.Die() && player.Die()) { // Continue the battle while both the enemy and the player are alive
                    player.showLevels(); // Displays player's levels
                    enemy.showLevels(); // Displays enemy's levels
                    System.out.print("You can either Attack (A), Super Attack (SA), or Taunt (T) : ");
                    String choice = scanner.nextLine(); // Reads the player's choice of action
                    switch (choice) {
                        case "A", "a" -> player.attack(enemy); // Player attacks the enemy
                        case "SA", "sa", "Sa", "sA" -> player.superAttack(enemy); // Player uses super attack against the enemy
                        case "T", "t" -> player.taunt(enemy); // Player taunts the enemy
                        default -> System.out.println("Invalid Input. You have lost your opportunity");
                    }
                    if (enemy.Die()) { // Checks if the enemy died after the player's action
                        enemy.attack(player); // Enemy attacks the player
                    }
                }
                if (!player.Die()) { // Player is alive, continues to the next room
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println(player.getName() + " Dead. Game Over!"); // Player died, game over
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    return;
                } else {
                    System.out.println();
                    player.move(); // Player moves to the next room
                    System.out.println(player.getName() + generateRandomItem(player, player.getClassType()));
                }
            }
            System.out.println();
        }
        // Implementing three enemy classes
        Warrior a = new Warrior();
        System.out.println(a.Attack());
        System.out.println(a);
        Ranger b = new Ranger();
        System.out.println(b.Attack());
        System.out.println(b);
        Mage c = new Mage();
        System.out.println(c.Attack());
        System.out.println(c);
      // Congrats for finishing the game!
        System.out.println("Congratulations! You have completed all levels.");
            }

    private static Items generateRandomItem(Player player, ClassType classType) { // Generates a random item for the player
        Random random = new Random();
        String itemName;
        int damageGain;
        int armorGain;
        int healthGain;
        int energyGain;

        if (classType == ClassType.TECHNOMANCER) {
            itemName = "Technomancer's Item";
            damageGain = random.nextInt(10) + 5;
            armorGain = random.nextInt(5) + 10;
            healthGain = random.nextInt(20) + 10;
            energyGain = random.nextInt(10) + 5;
        } else if (classType == ClassType.SHADOWAGENT) {
            itemName = "Shadow Agent's Item";
            damageGain = random.nextInt(10) + 10;
            armorGain = random.nextInt(5) + 5;
            healthGain = random.nextInt(10) + 5;
            energyGain = random.nextInt(20) + 10;
        } else if (classType == ClassType.MECHTROOPER) {
            itemName = "Mech Trooper's Item";
            damageGain = random.nextInt(5) + 5;
            armorGain = random.nextInt(10) + 5;
            healthGain = random.nextInt(10) + 10;
            energyGain = random.nextInt(20) + 20;
        } else {
            return null;
        }

        player.health+= healthGain; // Increase player's health
        player.armor += armorGain; // Increase player's armor
        player.energy+= energyGain; // Increase player's energy

        return new Items(itemName, damageGain, armorGain, healthGain, energyGain, classType);
    }
}