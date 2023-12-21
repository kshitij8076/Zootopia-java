 package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceArray;


/** ALL THE DATA STRUCTURE REQUIRED **/
class Attractions_ds {

    private String attraction_name;

    private String description;

    private Double ticket_price = 0.0;

    private int unique_id;

    private int ticketed = 0;

    private String schedule = "CLOSED";

    private int minor_discount = 10;
    private int senior_discount = 20;

    public void setName(String name) {
        attraction_name = name;
    }

    public String getName() {
        return attraction_name;
    }

    public void setDescription(String descriptions) {
        description = descriptions;
    }

    public String getDescription() {
        return description;
    }

    public void setTicket(Double price) {
        ticket_price = price;
    }

    public Double getTicket() {
        return ticket_price;
    }

    public void setId(int id) {
        unique_id = id;
    }

    public int getId() {
        return unique_id;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setMinor(int discount) {
        minor_discount = discount;
    }

    public int getMinor() {
        return minor_discount;
    }

    public void setTicketed(int v) {
        ticketed += v;
    }

    public int getTicketed() {
        return ticketed;
    }

    public void setSenior(int discount) {
        senior_discount = discount;
    }

    public int getSenior() {
        return senior_discount;
    }

}

class Visitor_ds {
    private String name;
    private int age;
    private String phone_no;
    private Double balance;
    private String email;
    private String password;
    private String membership;
    private Double spend = 0.0;
    private String feedback;
    private int ticketed = 0;

    public void setTicketed(int v) {
        ticketed += v;
    }

    public int getTicketed() {
        return ticketed;
    }

    public void setFeedback(String feed) {
        feedback = feed;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setMembership(String lvl) {
        membership = lvl;
    }

    public String getMembership() {
        return membership;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpend(Double cash) {
        spend += cash;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone_no = phone;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Double getBalance() {
        return balance;
    }

    public int getAge() {
        return age;
    }

    public Double getSpend() {
        return spend;
    }
}

class Visitor_list {
    private ArrayList<Visitor_ds> visitors = new ArrayList<>();

    public void setVisitor(Visitor_ds visitor) {
        visitors.add(visitor);
    }

    public Boolean exists(Visitor_ds visitor) {
        for (Visitor_ds visitor_ds : visitors) {
            if (Objects.equals(visitor_ds.getEmail(), visitor.getEmail())
                    && Objects.equals(visitor_ds.getPassword(), visitor.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Visitor_ds> getVisitorlist() {
        return visitors;
    }
}

class Animal_ds {
    private String animal_name;

    private String animal_detail = "NO DETAILS";
    private String animal_type;
    private String noise;

    public void setAnimalName(String name) {
        animal_name = name;
    }

    public void setAnimalDetail(String detail) {
        animal_detail = detail;
    }

    public void setAnimalType(String type) {
        animal_type = type;
    }

    public void setAnimalNoise(String n) {
        noise = n;
    }

    public String getAnimalName() {
        return animal_name;
    }

    public String getAnimalDetail() {
        return animal_detail;
    }

    public String getAnimalType() {
        return animal_type;
    }

    public String getAnimalNoise() {
        return noise;
    }
}

class Animal_list {
    private ArrayList<Animal_ds> animals = new ArrayList<>();

    // Setter for animal_list
    public void set_animal(Animal_ds animal) {
        animals.add(animal);
    }

    public ArrayList<Animal_ds> getAnimalList() {
        return animals;
    }

    // Getter for animal list
    public void get_animal() {
        for (Animal_ds animal_ds : animals) {
            System.out.println(
                    "Animal Name: " + animal_ds.getAnimalName() + " || Animal Type: " + animal_ds.getAnimalType()
                            + " || Animal Detail: " + animal_ds.getAnimalDetail());
        }
    }

    public void remove(String name, String type) {
        for (Animal_ds animal_ds : animals) {
            if (Objects.equals(name, animal_ds.getAnimalName()) && Objects.equals(animal_ds.getAnimalType(), type)) {
                animals.remove(animal_ds);
                System.out.println(">> Animal removed");
                break;
            }
        }
    }

    public void modify(String new_name, String new_type, String detail, String noise) {
        for (Animal_ds animal_ds : animals) {
            if (Objects.equals(new_name, animal_ds.getAnimalName())
                    && Objects.equals(animal_ds.getAnimalType(), new_type)) {
                animal_ds.setAnimalNoise(noise);
                animal_ds.setAnimalDetail(detail);
                System.out.println(">> Animal Modified ");
                break;
            }
        }
    }

}

abstract class Structure {
    private String name;
    private String password;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return this.name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    abstract void login_menu();
}

interface manage_attractions {

    public void add_attraction();

    public void view_attraction();

    public void modify_attraction();

    public void remove_attraction();

    public void schedule_event();
}

interface manage_animals {
    public void add_animal();

    public void modify_animal();

    public void view_animal();

    public void remove_animal();
}

interface no_balance{
    public void not_enough_balance();
}

class Admin extends Structure implements manage_attractions, manage_animals , no_balance {

    private ArrayList<Attractions_ds> attraction_list = new ArrayList<Attractions_ds>();
    final Scanner input = new Scanner(System.in);

    private int unique_id = 1;
    private Animal_list animal_list = new Animal_list();
    private Map<String, Double> discounts = new HashMap<>();;
    private Map<Integer, Double> specialdeal = new HashMap<>();;
    private Visitor_list visitor_list;

    public Animal_list getAnimal_list() {
        return animal_list;
    }

    public void setVisitorlist(Visitor_list list) {
        visitor_list = list;
    }

    public Map<String, Double> getDiscount() {
        return discounts;
    }

    public ArrayList<Attractions_ds> getAttractionlist() {
        return attraction_list;
    }

    public Map<Integer, Double> getSpecialDeal() {
        return specialdeal;
    }

    /** ATTRACTION METHODS STARTS HERE **/

    /** THIS METHOD IS ADDING ALL THE ATTRACTION **/
    @Override
    public void add_attraction() {
        input.nextLine();
        System.out.print("Enter Attraction Name: ");
        String name = input.nextLine();
        System.out.print("Enter Attraction Description: ");
        String attraction_description = input.nextLine();
        System.out.print("Enter Ticket price: ");
        Double price = input.nextDouble();
        Attractions_ds event = new Attractions_ds();
        event.setName(name);
        event.setDescription(attraction_description);
        event.setTicket(price);
        event.setId(unique_id);
        unique_id++;
        attraction_list.add(event);
        System.out.println(">> Attraction Added successfully");

    }

    @Override
    public void not_enough_balance(){
        System.out.println("\n>>Not enough Balance ");
    }

    /** THIS METHOD WILL PRINT ALL CURRENTLY THE ATTRACTION **/
    @Override
    public void view_attraction() {
        for (Attractions_ds event : attraction_list) {
            System.out.println(
                    "ID: " + event.getId() + "|| Attraction Name: " + event.getName() + " || Attraction Description: "
                            + event.getDescription()
                            + "|| Attraction Price: " + event.getTicket() + " || Attraction Schedule: "
                            + event.getSchedule());
        }
    }

    /** NOT GIVEN ENOUGH INFO **/
    @Override
    public void modify_attraction() {
        input.nextLine();
        System.out.print("Enter the Attraction name: ");
        String attr_name = input.nextLine();
        System.out.print("Enter New Description: ");
        String des = input.nextLine();
        System.out.print("Enter new Ticket cost: ");
        Double ticket = input.nextDouble();
        input.nextLine();
        for (Attractions_ds attractions_ds : attraction_list) {
            if (Objects.equals(attractions_ds.getName(), attr_name)) {
                attractions_ds.setDescription(des);
                attractions_ds.setTicket(ticket);
            }
        }
    }

    /** IT TAKES THE NAME OF THE ATTRACTION AS INPUT AND REMOVE THE ATTRACTION **/
    @Override
    public void remove_attraction() {
        input.nextLine();
        System.out.print("Enter the attraction name : ");
        String name = input.nextLine();

        for (Attractions_ds event : attraction_list) {
            if (Objects.equals(event.getName(), name)) {
                attraction_list.remove(event);
                System.out.println(">> ! Removed Successfully\n ");
                break;
            }
        }

        System.out.println("NO such Attraction exists\n");
    }

    /** ANIMAL METHODS STARTS HERE **/
    @Override
    public void add_animal() {
        input.nextLine();
        System.out.print("Enter Animal Name: ");
        String name = input.nextLine();
        System.out.print("Enter Animal Type: ");
        String type = input.nextLine();
        System.out.print("Enter Animal Noise: ");
        String noise = input.nextLine();
        Animal_ds animal = new Animal_ds();
        animal.setAnimalName(name);
        animal.setAnimalNoise(noise);
        animal.setAnimalType(type);

        if (Objects.equals(type, "Mammal") || Objects.equals(type, "mammal")) {
            animal_list.set_animal(animal);
        } else if (Objects.equals(type, "Reptile") || Objects.equals(type, "reptile")) {
            animal_list.set_animal(animal);
        } else if (Objects.equals(type, "Amphibian") || Objects.equals(type, "amphibian")) {
            animal_list.set_animal(animal);
        } else {
            System.out.println(">> No such animal category exists \n");
            return;
        }
        System.out.println(">> Animal added to zoo\n");

    }

    // modify_animal will only update animals details takes animal name and its type
    // as input
    @Override
    public void modify_animal() {
        input.nextLine();
        System.out.print("Enter Animal Name to modify: ");
        String new_name = input.nextLine();
        System.out.print("Enter New Animal Type to modify: ");
        String new_type = input.nextLine();
        System.out.print("Enter New Animal Noise : ");
        String noise = input.nextLine();
        System.out.print("Enter New the Detail: ");
        String detail = input.nextLine();
        animal_list.modify(new_name, new_type, detail, noise);

    }

    // remove animal takes the type of the animal to remove as input and the name of
    // the animal
    @Override
    public void remove_animal() {
        input.nextLine();
        System.out.print("Enter Animal Name: ");
        String name = input.nextLine();
        System.out.print("Enter Animal Type: ");
        String type = input.nextLine();
        animal_list.remove(name, type);
    }

    @Override
    public void view_animal() {
        animal_list.get_animal();
    }

    // schedule event takes attraction name as input and scheduled it
    public void schedule_event() {
        input.nextLine();
        System.out.print("Enter Attraction Name: ");
        String name = input.nextLine();
        System.out.print("Enter Schedule Open or Close: ");
        String schedule = input.nextLine();
        System.out.print("Enter Ticket Price: ");
        Double price = input.nextDouble();
        int check = 0;
        for (Attractions_ds event : attraction_list) {
            if (Objects.equals(event.getName(), name)) {
                event.setTicket(price);
                event.setSchedule(schedule);
                check = 1;
                System.out.println("\n>> Scheduled Successfully ");
                break;
            }
        }
        if (check == 0) {
            System.out.println("\n>> NO such Attraction exists");
        }
    }

    public void attraction_menu() {

        while (true) {

            System.out.println("Manage Attractions: " +
                    "\n 1. Add Attraction" +
                    "\n 2. View Attractions" +
                    "\n 3. Modify Attraction " +
                    "\n 4. Remove Attraction " +
                    "\n 5. Exit" +
                    "\n");
            System.out.print("Enter your Choice: ");
            int manage_input = input.nextInt();

            System.out.println();

            if (manage_input == 1) {
                add_attraction();
            } else if (manage_input == 2) {
                view_attraction();
            } else if (manage_input == 3) {
                modify_attraction();
            } else if (manage_input == 4) {
                remove_attraction();
            } else if (manage_input == 5) {
                break;
            }
            System.out.println();
        }
    }

    public void animal_menu() {
        while (true) {
            System.out.println("Manage Animals: " +
                    "\n 1. Add Animal" +
                    "\n 2. Update Animal Details " +
                    "\n 3. Remove Animal " +
                    "\n 4. View Animal " +
                    "\n 5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                add_animal();
            } else if (choice == 2) {
                modify_animal();
            } else if (choice == 3) {
                remove_animal();
            } else if (choice == 4) {
                view_animal();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("\n >> Please choose among the given opions ");
            }
        }
    }

    public void set_discount_menu() {

        while (true) {

            System.out.println("\nSet Discounts: " +
                    "\n1.Add Discount " +
                    "\n2.Modify Discount " +
                    "\n3.Remove Discount" +
                    "\n4.View Discount" +
                    "\n5.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();
            if (choice == 1) {

                // this will add discount for all minor and senior categories and if one
                // particular discount is already added and new discount with same category is
                // added then the latest one will replace also keep aware of space when adding
                // category
                input.nextLine();
                System.out.print("\nEnter Discount Category or Discount Code: ");
                String category = input.nextLine();
                System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                Double discount = input.nextDouble();
                if (discounts.containsKey(category)) {
                    discounts.remove(category);
                }
                discounts.put(category, discount);

            } else if (choice == 2) {
                // this will add new discount
                input.nextLine();
                System.out.print("\nEnter Discount Category: ");
                String category = input.nextLine();
                System.out.print("Enter New Discount Percentage (e.g., 20 for 20%): ");
                Double discount = input.nextDouble();
                if (discounts.containsKey(category)) {
                    discounts.remove(category);
                    discounts.put(category, discount);
                    System.out.println("\n>>Discount modified successfully.");
                } else {
                    System.out.println("\n>>Invalid Discount Category. Please enter a valid category.");
                }
            } else if (choice == 3) {
                // This will remove the discount of specified category
                input.nextLine();
                System.out.print("\nEnter the Category or Discount Code: ");
                String category = input.nextLine();
                if (discounts.containsKey(category)) {
                    discounts.remove(category);
                } else {
                    System.out.println("\n>>Invalid Discount Category. Please enter a valid category.");
                }

            }

            else if (choice == 4) {
                for (Map.Entry<String, Double> entry : discounts.entrySet())
                    System.out.println("Category = " + entry.getKey() +
                            ", Discounts = " + entry.getValue());
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("\n>>Incorrect Choice");
            }
        }

    }

    public void set_special_deal() {
        input.nextLine();
        System.out.print("\nEnter the discount on how many attractino: ");
        int no_attr = input.nextInt();
        input.nextLine();
        System.out.print("Enter Discount: ");
        Double disc = input.nextDouble();
        specialdeal.put(no_attr, disc);
    }

    public void view_feed() {
        int cnt = 1;
        for (Visitor_ds visitor : visitor_list.getVisitorlist()) {
            System.out.println("Feedback " + cnt + " " + visitor.getFeedback());
            cnt++;
        }
    }

    public void view_stats() {
        System.out.println("\nVisitor Statistics: ");
        System.out.println("-Total Visitors: " + visitor_list.getVisitorlist().size());
        Double revenue = 0.0;
        for (Visitor_ds visitor : visitor_list.getVisitorlist()) {
            revenue += visitor.getSpend();
        }
        System.out.println("-Total Revenue: " + revenue);
        int mx = -1;
        String att_name = "None";
        for (Attractions_ds attractions_ds : attraction_list) {
            if (attractions_ds.getTicketed() > mx) {
                mx = attractions_ds.getTicketed();
                att_name = attractions_ds.getName();
            }
        }
        System.out.println("-Most Popular Attraction: " + att_name);

    }

    /** THIS IS MAIN ADMIN LOGIN MENU METHOD **/
    @Override
    public void login_menu() {

        while (true) {

            System.out.println("\nAdmin Menu: "
                    + "\n1.Manage Attractions "
                    + "\n2.Manage Animals "
                    + "\n3.Schedule Events "
                    + "\n4.Set Discounts "
                    + "\n5.Set Special Deals "
                    + "\n6.View Visitor Stats "
                    + "\n7.View Feedback "
                    + "\n8.Exit");
            System.out.print("\nEnter your choice : ");
            int input_choice = input.nextInt();
            if (input_choice == 1) {
                attraction_menu();
            } else if (input_choice == 2) {
                animal_menu();
            } else if (input_choice == 3) {
                schedule_event();
            } else if (input_choice == 4) {
                set_discount_menu();
            } else if (input_choice == 5) {
                set_special_deal();
            } else if (input_choice == 6) {
                view_stats();
            } else if (input_choice == 7) {
                view_feed();
            }
            if (input_choice == 8) {
                System.out.println("\nLogged Out");
                break;
            }
        }

    }
}

class Visitor extends Structure {

    private Scanner input = new Scanner(System.in);
    private Visitor_list visitor_list;
    private Map<String, Double> discounts;
    private ArrayList<Attractions_ds> attraction_list;
    private Map<Integer, Double> specialDeal;
    private Animal_list animal_list;

    Visitor(String email, String password, Visitor_list list, Map<String, Double> dis_list,
            ArrayList<Attractions_ds> attr_list, Map<Integer, Double> deal, Animal_list animal) {
        setEmail(email);
        setPassword(password);
        discounts = dis_list;
        visitor_list = list;
        attraction_list = attr_list;
        specialDeal = deal;
        animal_list = animal;
    }

    @Override
    public void login_menu() {
        while (true) {
            System.out.println("\n1. Explore the Zoo\r\n" + //
                    "2. Buy Membership\r\n" + //
                    "3. Buy Tickets\r\n" + //
                    "4. View Discounts\r\n" + //
                    "5. View Special Deals\r\n" + //
                    "6. Visit Animals\r\n" + //
                    "7. Visit Attractions\r\n" + //
                    "8. Leave Feedback\r\n" + //
                    "9. Log Out\r\n" + //
                    "10 View Profile\n");
            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("\nExplore the Zoo: ");
                System.out.println("1. View Attractions\r\n" + //
                        "2. View Animals\r\n" + //
                        "3. Exit\r\n" + //
                        "");
                while (true) {
                    System.out.print("\nEnter your choice: ");
                    int choice2 = input.nextInt();
                    if (choice2 == 1) {

                        for (Attractions_ds attractions_ds : attraction_list) {
                            System.out.println("Attraction Name: " + attractions_ds.getName() + " Attraction Details: "
                                    + attractions_ds.getDescription() + " Attraction Ticket: "
                                    + attractions_ds.getTicket());
                        }
                    } else if (choice2 == 2) {
                        // call view animal
                        System.out.println("View Animals: ");
                        for (Animal_ds animal_ds : animal_list.getAnimalList()) {
                            System.out.println("Animal Name: " + animal_ds.getAnimalName() + " Animal Type "
                                    + animal_ds.getAnimalType());
                        }

                    } else if (choice2 == 3) {
                        break;
                    } else {
                        System.out.println("\n>>Incorrect choice");
                    }
                }
            } else if (choice == 2) {
                System.out.println("\nBuy Membership:\n" +
                        "1. Basic Membership (₹20)\n" +
                        "2. Premium Membership (₹50)\n" +
                        "3. Exit");
                while (true) {
                    System.out.print("Enter your choice: ");
                    int membership_choice = input.nextInt();
                    if (membership_choice != 1 && membership_choice != 2) {
                        break;
                    }
                    Double cost = 0.0;
                    if (membership_choice == 1) {
                        cost = 20.0;
                    } else if (membership_choice == 2) {
                        cost = 50.0;
                    }
                    input.nextLine();
                    System.out.print("Apply Discount code: ");
                    String code = input.nextLine();
                    for (Visitor_ds visitors : visitor_list.getVisitorlist()) {
                        if (Objects.equals(visitors.getEmail(), this.getEmail())
                                && Objects.equals(visitors.getPassword(), getPassword())) {
                            if (Objects.equals(visitors.getMembership(), "Premium")) {
                                break;
                            } else {// if visitor has basic
                                Double discount = 0.0;
                                if (visitors.getAge() < 18 && discounts.get("minor") != null) {
                                    discount = discounts.get("minor");
                                } else if (visitors.getAge() > 65 && discounts.get("senior") != null) {
                                    discount = discounts.get("senior");
                                }

                                if (discounts.get(code) != null) {
                                    discount += discounts.get(code);
                                }

                                if ((visitors.getBalance() < 20 && membership_choice == 1)
                                        || (visitors.getBalance() < 50 && membership_choice == 2)) {
                                    // POLYMORPHISM
                                    no_balance notBalance = new Admin();
                                    notBalance.not_enough_balance();
                                    break;
                                } else {
                                    Double left = visitors.getBalance() - (cost - (cost * (discount / 100)));
                                    visitors.setBalance(left);
                                    visitors.setSpend(left);
                                    if (membership_choice == 1) {
                                        visitors.setMembership("basic");
                                    } else if (membership_choice == 2) {
                                        visitors.setMembership("premium");
                                    }
                                    System.out.println("\n>>Bought Successfully ");
                                }
                            }
                            break;
                        }
                    }

                }
            }

            else if (choice == 3) {
                System.out.println("Buy Tickets:\r\n" + //
                        "Select an Attraction to Buy a Ticket:\r\n" + //
                        "");
                for (Attractions_ds attractions_ds : attraction_list) {
                    System.out.println(attractions_ds.getId() + ". " + attractions_ds.getName() + "("
                            + attractions_ds.getTicket() + ")");
                }
                input.nextLine();
                System.out.print("Enter your choice: ");
                int att_choice = input.nextInt();
                for (Attractions_ds attractions_ds : attraction_list) {
                    if (Objects.equals(attractions_ds.getId(), att_choice)) {
                        for (Visitor_ds visitor : visitor_list.getVisitorlist()) {
                            if (Objects.equals(visitor.getEmail(), getEmail())
                                    && Objects.equals(visitor.getPassword(), getPassword())) {
                                if (Objects.equals(visitor.getMembership(), "premium")) {
                                    attractions_ds.setTicketed(1);
                                    visitor.setTicketed(1);
                                } else if (Objects.equals(visitor.getMembership(), "basic")) {
                                    Double discount = 0.0;
                                    if (visitor.getAge() < 18 && discounts.get("minor") != null) {
                                        discount += discounts.get("minor");
                                    } else if (visitor.getAge() > 65 && discounts.get("senior") != null) {
                                        discount += discounts.get("senior");
                                    }
                                    if (specialDeal.get(visitor.getTicketed()) != null) {
                                        discount += specialDeal.get(visitor.getTicketed());
                                    }
                                    Double cost = attractions_ds.getTicket()
                                            - (attractions_ds.getTicket() * discount / 100);
                                    if (cost > visitor.getBalance()) {
                                        // POLYMORPHISM
                                        no_balance notBalance = new Admin();
                                        notBalance.not_enough_balance();
                                        break;
                                    } else {
                                        Double spend = visitor.getBalance() - cost;
                                        visitor.setBalance(spend);
                                        visitor.setSpend(spend);
                                        visitor.setTicketed(1);
                                        attractions_ds.setTicketed(1);
                                        System.out.println("\n>>Bought ticket successfully");
                                        break;
                                    }

                                }
                            }
                        }
                        break;
                    }
                }

            } else if (choice == 4) {
                System.out.println("\nSelected Discount: ");
                System.out.println("minor: " + discounts.get("minor"));
                System.out.println("senior: " + discounts.get("senior"));
                System.out.println("\nDiscount Code: ");
                for (Map.Entry<String, Double> entry : discounts.entrySet()) {
                    if (entry.getKey() != "minor" && entry.getKey() != "senior") {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
            } else if (choice == 5) {
                System.out.println("\nSpecial Deal");
                for (Map.Entry<Integer, Double> entry : specialDeal.entrySet()) {
                    System.out.println("Buy " + entry.getKey() + " tickets and get " + entry.getValue() + " off");
                }
            } else if (choice == 6) {
                System.out.println("\nVisit Animal: ");
                for (Animal_ds animal_ds : animal_list.getAnimalList()) {
                    System.out.println(animal_ds.getAnimalName() + " " + animal_ds.getAnimalType());
                }
                input.nextLine();
                System.out.print("Enter Animal Name to Visit: ");
                String name = input.nextLine();
                System.out.print("Enter Animal Type to Visit: ");
                String type = input.nextLine();
                System.out.print("Enter to feed or read the animal ");
                String choice2 = input.nextLine();
                for (Animal_ds animal_ds : animal_list.getAnimalList()) {
                    if (Objects.equals(animal_ds.getAnimalName(), name)
                            && Objects.equals(animal_ds.getAnimalType(), type)) {
                        if (choice2 == "feed") {
                            System.out.println("\nAnimal Noise:" + animal_ds.getAnimalNoise());
                        } else if (choice2 == "read") {
                            System.out.println("\nAnimal History:" + animal_ds.getAnimalDetail());
                        }
                    }
                }

            }

            else if (choice == 7) {
                System.out.println("Visit Attractions:\r\n" + //
                        "Select an Attraction to Visit:\r\n" + //
                        "");
                System.out.println("0. Exit");
                for (Attractions_ds attractions_ds2 : attraction_list) {
                    if (attractions_ds2.getTicketed() > 0 && Objects.equals(attractions_ds2.getSchedule(), "open")) {
                        System.out.println(attractions_ds2.getId() + ". " + attractions_ds2.getName());
                    }
                }
                int choice2 = input.nextInt();
                if (choice2 != 0) {
                    for (Attractions_ds attractions_ds2 : attraction_list) {
                        if (Objects.equals(attractions_ds2.getId(), choice2)) {
                            for (Visitor_ds visitor : visitor_list.getVisitorlist()) {
                                visitor.setTicketed(-1);
                                attractions_ds2.setTicketed(-1);
                                System.out.println("1 Ticket Used");
                                System.out.println("Thank you for visiting " + attractions_ds2.getName()
                                        + ". Hope you Enjoyed the attraction");
                                break;
                            }
                        }
                        break;
                    }
                }

            } else if (choice == 8) {
                input.nextLine();
                System.out.print("Enter your feedback (max 200 characters): ");
                String feed = input.nextLine();
                for (Visitor_ds visitor : visitor_list.getVisitorlist()) {
                    if (Objects.equals(visitor.getEmail(), getEmail())
                            && Objects.equals(visitor.getPassword(), getPassword())) {
                        visitor.setFeedback(feed);
                        break;
                    }

                }
                System.out.println("Thank you for your feedback.");
            }

            else if (choice == 9) {
                System.out.println("\n>>Log out");
                break;
            } else if (choice == 10) {
                for (Visitor_ds visitor_ds : visitor_list.getVisitorlist()) {
                    if (Objects.equals(visitor_ds.getEmail(), getEmail())
                            && Objects.equals(visitor_ds.getPassword(), getPassword())) {
                        System.out.println("Name: " + visitor_ds.getName() + " Balance: " + visitor_ds.getBalance()
                                + " Membership: " + visitor_ds.getMembership());
                    }
                }
            } else {
                System.out.println("\n>>Incorrect Choice");
            }

        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final Visitor_list visitor_list = new Visitor_list();
        final Admin admin = new Admin();
        admin.setVisitorlist(visitor_list);
        while (true) {
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deal");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            int main_input = input.nextInt();
            if (main_input == 1) {
                // call for admin

                System.out.print("\nEnter Admin Username: ");
                String username = input.nextLine();
                admin.setName(username);
                input.nextLine();
                System.out.print("Enter Admin Password: ");
                String password = input.nextLine();
                admin.setPassword(password);
                System.out.println("Logged in as Admin\n");
                admin.login_menu();

            } else if (main_input == 2) {
                // call for visitor

                while (true) {
                    System.out.println("\n1.Register " +
                            "\n2.Login ");
                    System.out.print("\nEnter your choice: ");
                    int choice = input.nextInt();
                    if (choice == 1) {
                        input.nextLine();
                        System.out.print("Enter Visitor Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter Visitor Age: ");
                        int age = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter Visitor Phone Number: ");
                        String phone = input.nextLine();
                        System.out.print("Enter Visitor Balance: ");
                        Double balance = input.nextDouble();
                        input.nextLine();
                        System.out.print("Enter Visitor Email: ");
                        String email = input.nextLine();
                        System.out.print("Enter Visitor Password: ");
                        String password = input.nextLine();
                        Visitor_ds visitor_info = new Visitor_ds();
                        visitor_info.setName(name);
                        visitor_info.setAge(age);
                        visitor_info.setPhone(phone);
                        visitor_info.setBalance(balance);
                        visitor_info.setEmail(email);
                        visitor_info.setPassword(password);
                        if (!visitor_list.exists(visitor_info)) {
                            visitor_list.setVisitor(visitor_info);
                            System.out.println("\n>>User added succesfully ");
                        } else {
                            System.out.println("\n>>User already registered");
                        }
                    } else if (choice == 2) {
                        input.nextLine();
                        System.out.print("\nEnter Visitor Email: ");
                        String email = input.nextLine();
                        System.out.print("Enter Visitor Password: ");
                        String password = input.nextLine();
                        Visitor_ds visitor_info = new Visitor_ds();
                        visitor_info.setEmail(email);
                        visitor_info.setPassword(password);
                        if (!visitor_list.exists(visitor_info)) {
                            System.out.println("\n>>User not Registered");
                        } else {
                            final Visitor visitor = new Visitor(email, password, visitor_list, admin.getDiscount(),
                                    admin.getAttractionlist(), admin.getSpecialDeal(), admin.getAnimal_list());
                            System.out.println("\n>>Logged in ");
                            visitor.login_menu();
                            break;
                        }
                    }
                }

            } else if (main_input == 3) {

                System.out.println("\nSpecial Deal: ");
                // view special deal
                for (Map.Entry<Integer, Double> entry : admin.getSpecialDeal().entrySet()) {
                    System.out.println("Buy " + entry.getKey() + " tickets and get " + entry.getValue() + " off");
                }

            }

            else if (main_input == 4) {
                break;
            } else {
                System.out.println("Incorrect option");
            }
        }
    }
}