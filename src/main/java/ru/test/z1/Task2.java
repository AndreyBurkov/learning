package ru.test.z1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n, m, k: ");
        String inputString = scanner.nextLine().trim();
//        String inputString = "3 4 240";
//        String inputString = "3 4 730";

        String[] s = inputString.split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

//        inputString = "60 90 120";
        System.out.print("Input timestamps for ProjectA: ");
        inputString = scanner.nextLine().trim();
        Queue<Ticket> ticketsA = new LinkedList<>();
        for (String str : inputString.split(" ")) {
            Ticket ticket = new Ticket(Integer.parseInt(str));
            ticketsA.add(ticket);
        }
        Project projectA = new Project(ticketsA);

//        inputString = "80 150 80 150";
        System.out.print("Input timestamps for ProjectB: ");
        inputString = scanner.nextLine().trim();
        Queue<Ticket> ticketsB = new LinkedList<>();
        for (String str : inputString.split(" ")) {
            Ticket ticket = new Ticket(Integer.parseInt(str));
            ticketsB.add(ticket);
        }
        Project projectB = new Project(ticketsB);

        System.out.println("k=" + k);
        int elapsedTime = 0;
        int count = 0;
        Ticket ticketToResolve;
        Project project;
        do {
            Ticket ticketA = projectA.ticketQueue.peek();
            Ticket ticketB = projectB.ticketQueue.peek();
            if (ticketA == null && ticketB == null) {
                break;
            } else if (ticketA == null) {
                ticketToResolve = ticketB;
                project = projectB;
            } else if (ticketB == null) {
                ticketToResolve = ticketA;
                project = projectA;
            } else if (ticketA.time <= ticketB.time) {
                ticketToResolve = ticketA;
                project = projectA;
            } else if (ticketA.time > ticketB.time) {
                ticketToResolve = ticketB;
                project = projectB;
            } else {
                System.out.println("ASDFASDFS");
                break;
            }

            if (ticketToResolve.time + elapsedTime > k) {
                break;
            }

            project.ticketQueue.poll();
            System.out.println("ticketToResolve: " + ticketToResolve);
            elapsedTime += ticketToResolve.time;
            count++;
        } while (true);


        System.out.println(count);
    }

    private static class Project {
        final Queue<Ticket> ticketQueue;

        public Project(Queue<Ticket> ticketQueue) {
            this.ticketQueue = ticketQueue;
        }
    }

    private static class Ticket {
        int time;

        public Ticket(int time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Ticket{" +
                    "time=" + time +
                    '}';
        }
    }
}


