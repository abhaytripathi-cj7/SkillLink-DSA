The SkillLink Platform Engine is a Java-based console application designed to simulate a simple freelancing platform where task providers can post tasks and task completers can apply for them.

The system organizes projects based on their budget priority, allowing freelancers to easily view the highest-paying tasks first. It also includes a pricing calculator to help estimate the cost of completing a project.

This project demonstrates the use of Data Structures and Algorithms concepts such as HashMaps, Heaps (Priority Queues), and basic algorithmic logic.

Features

Task Provider Mode

Post a new project/task

Enter task title, budget, and contact information

Automatically generates a project ID

Task Completer Mode

View all available tasks

Tasks are sorted by highest budget first

Apply to tasks using project ID

Pricing Calculator

Estimates recommended project price

Uses hours and hourly rate input

Efficient Data Management

Fast retrieval of projects

Priority-based task display

Data Structures Used
1. HashMap

Used to store project details for O(1) lookup time.

Map<Integer, Project> projectDb = new HashMap<>();
2. Priority Queue (Max Heap)

Used to show highest budget tasks first.

PriorityQueue<Project> projectHeap
3. Basic Algorithmic Logic

Used in the pricing calculator to estimate project price.

total = hours × rate × 1.5
How the Program Works

When the program starts, the user sees a menu:

Task Completer (Apply)

Task Provider (Post)

Pricing Calculator

Exit

Task Provider

Enters task title, budget, and contact details

The system stores the task in a HashMap and PriorityQueue

Task Completer

Views available tasks sorted by highest budget

Selects a project ID to apply

Pricing Calculator

Calculates recommended price using estimated hours and hourly rate.

Technologies Used

Java

Data Structures

HashMap

Priority Queue (Heap)

Console-based User Interface
