import java.util.*;
/**
 * SkillLink Platform Engine
 * Covers: CO3 (Heaps), CO4 (HashMaps), and CO1 (Algorithmic Logic).
 */
public class SkillLinkEngine {
// CO4: HashMap for O(1) retrieval of project data
private Map<Integer, Project> projectDb = new HashMap<>();
// CO3: Max-Heap (Priority Queue) to show highest budget projects first
private PriorityQueue<Project> projectHeap = new PriorityQueue<>(
(p1, p2) -> Double.compare(p2.getBudget(), p1.getBudget())
);
public static void main(String[] args) {
SkillLinkEngine platform = new SkillLinkEngine();
platform.runApp();
}
public void runApp() {
Scanner sc = new Scanner(System.in);
while (true) {
System.out.println("\n--- SkillLink Platform ---");
System.out.println("1. Task Completer (Apply) | 2. Task Provider (Post)");
System.out.println("3. Pricing Calculator     | 4. Exit");
System.out.print("Select: ");
String choice = sc.nextLine();
if (choice.equals("1")) {
handleTaskCompleter(sc);
} else if (choice.equals("2")) {
postTask(sc);
} else if (choice.equals("3")) {
runPricingCalc(sc);
} else if (choice.equals("4")) {
System.out.println("Exiting SkillLink...");
break;
} else {
System.out.println("Invalid choice. Please try again.");
}
}
}
// --- TASK COMPLETER MODE (CO1: Iteration/Searching) ---
private void handleTaskCompleter(Scanner sc) {
System.out.println("\n--- Available Tasks (Highest Budget First) ---");
if (projectHeap.isEmpty()) {
System.out.println("No tasks available.");
return;
}
// CO3: Display projects from the Max-Heap
for (Project p : projectHeap) {
System.out.println(p + " | Contact: " + p.getContact());
}
System.out.print("\nEnter Project ID to apply for: ");
try {
int applyId = Integer.parseInt(sc.nextLine());
// CO4: O(1) lookup in the project database
if (projectDb.containsKey(applyId)) {
System.out.println("Successfully applied for: " + projectDb.get(applyId).getTitle());
System.out.println("The client will reach out via the contact details provided.");
} else {
System.out.println("Invalid Project ID.");
}
} catch (NumberFormatException e) {
System.out.println("Please enter a valid numeric ID.");
}
}
// --- TASK PROVIDER MODE (CO3: Heap Insertion) ---
private void postTask(Scanner sc) {
System.out.print("Enter Task Title: ");
String title = sc.nextLine();
System.out.print("Enter Budget ($): ");
try {
double budget = Double.parseDouble(sc.nextLine());
System.out.print("Enter Contact Details (Email/Phone): ");
String contact = sc.nextLine();
int id = projectDb.size() + 1;
Project p = new Project(id, title, budget, contact);
// CO4: Store in HashMap
projectDb.put(id, p);
// CO3: Add to PriorityQueue (Heap)
projectHeap.add(p);
System.out.println("Project Live! ID: " + id);
} catch (NumberFormatException e) {
System.out.println("Invalid budget format. Project not posted.");
}
}
// --- PRICING CALCULATOR (CO1: Simple Algorithm) ---
private void runPricingCalc(Scanner sc) {
System.out.print("Estimated Hours: ");
try {
int hrs = Integer.parseInt(sc.nextLine());
System.out.print("Hourly Rate ($): ");
int rate = Integer.parseInt(sc.nextLine());
// CO1: Basic algorithmic logic for price estimation
double total = hrs * rate * 1.5;
System.out.printf("Recommended Price: $%.2f\n", total);
} catch (NumberFormatException e) {
System.out.println("Invalid numeric input.");
}
}
}
class Project {
private int id;
private String title;
private double budget;
private String contact;
public Project(int id, String title, double budget, String contact) {
this.id = id;
this.title = title;
this.budget = budget;
this.contact = contact;
}
public double getBudget() { return budget; }
public String getTitle() { return title; }
public String getContact() { return contact; }
@Override
public String toString() {
return "ID: " + id + " | " + title + " ($" + budget + ")";
}
}