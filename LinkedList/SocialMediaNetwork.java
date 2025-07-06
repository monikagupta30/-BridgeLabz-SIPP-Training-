import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    UserNode head = null;

    // Add a new user to the list
    void addUser(int userId, String name, int age) {
        if (findUserById(userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }
        UserNode newNode = new UserNode(userId, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("User added: " + name);
    }

    // Find user by ID
    UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by name
    void searchUserByName(String name) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("No user found with name: " + name);
    }

    // Display a user's details
    void displayUser(UserNode user) {
        System.out.println("ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
    }

    // Add friend connection (bi-directional)
    void addFriendConnection(int userId1, int userId2) {
        if (userId1 == userId2) {
            System.out.println("Cannot add self as friend.");
            return;
        }

        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove friend connection
    void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove((Integer) userId2);
        user2.friendIds.remove((Integer) userId1);

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a user
    void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
            return;
        }

        for (int fid : user.friendIds) {
            UserNode friend = findUserById(fid);
            if (friend != null)
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
        }
    }

    // Count number of friends per user
    void countFriendsForAll() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Find mutual friends
    void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutual = new ArrayList<>();
        for (int fid : user1.friendIds) {
            if (user2.friendIds.contains(fid)) {
                mutual.add(fid);
            }
        }

        System.out.println("Mutual friends of " + user1.name + " and " + user2.name + ":");
        if (mutual.isEmpty()) {
            System.out.println("None");
        } else {
            for (int id : mutual) {
                UserNode f = findUserById(id);
                if (f != null)
                    System.out.println("- " + f.name + " (ID: " + f.userId + ")");
            }
        }
    }
}

public class SocialMediaNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        int choice;

        do {
            System.out.println("\n--- Social Media Friend Manager ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display All Friends of User");
            System.out.println("5. Search User by Name");
            System.out.println("6. Search User by ID");
            System.out.println("7. Count Friends of All Users");
            System.out.println("8. Find Mutual Friends");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id1, id2, age;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: "); id1 = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); name = sc.nextLine();
                    System.out.print("Enter Age: "); age = sc.nextInt();
                    sm.addUser(id1, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: "); id1 = sc.nextInt();
                    System.out.print("Enter User ID 2: "); id2 = sc.nextInt();
                    sm.addFriendConnection(id1, id2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: "); id1 = sc.nextInt();
                    System.out.print("Enter User ID 2: "); id2 = sc.nextInt();
                    sm.removeFriendConnection(id1, id2);
                    break;
                case 4:
                    System.out.print("Enter User ID: "); id1 = sc.nextInt();
                    sm.displayFriends(id1);
                    break;
                case 5:
                    System.out.print("Enter Name to Search: "); name = sc.nextLine();
                    sm.searchUserByName(name);
                    break;
                case 6:
                    System.out.print("Enter User ID to Search: "); id1 = sc.nextInt();
                    UserNode user = sm.findUserById(id1);
                    if (user != null)
                        sm.displayUser(user);
                    else
                        System.out.println("User not found.");
                    break;
                case 7:
                    sm.countFriendsForAll();
                    break;
                case 8:
                    System.out.print("Enter User ID 1: "); id1 = sc.nextInt();
                    System.out.print("Enter User ID 2: "); id2 = sc.nextInt();
                    sm.findMutualFriends(id1, id2);
                    break;
                case 9:
                    System.out.println("Exiting System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
