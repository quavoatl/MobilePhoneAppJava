package com.company;


import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0720 165 989");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        while (!quit) {

            printInstructions();
            int choice = 0;
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    mobilePhone.listOfContacts();
                    break;
                case 1:
                    addNewContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    findContact();
                    break;
                case 5:
                    quit = true;
                    System.out.println("Shutting off phone...");

            }
        }
    }

    public static void startPhone() {

        System.out.println("Starting phone...");

    }

    public static void printInstructions() {


        System.out.println("\n Press :");
        System.out.println("\t 0 - To print list of contact.");
        System.out.println("\t 1 - To add new contact");
        System.out.println("\t 2 - To update existing contact");
        System.out.println("\t 3 - To remove a contact");
        System.out.println("\t 4 - To find a contact");
        System.out.println("\t 5 - To exit the application");

        System.out.println("Please chose an option :\r");
    }

    public static void addNewContact() {
        System.out.print("Please enter the name :\n");
        String name = scanner.nextLine();
        System.out.println("Please enter phone number : ");
        String phoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phoneNumber);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("Contact created. Name: " + newContact.getName()
                    + ", phone number: " + newContact.getPhoneNumber());
        } else System.out.println("Contact already exists");

    }

    public static void updateContact() {
        System.out.println("Enter contact name you want to update : ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact does not exists");
            return;
        } else
            System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newPhoneNumber);
        mobilePhone.updateContact(existingContactRecord, newContact);

    }

    public static void removeContact() {
        System.out.println("Enter contact name you want to remove : ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact does not exists");
            return;
        }
        mobilePhone.removeContact(existingContactRecord);
    }

    public static void findContact() {
        System.out.println("Enter contact name : ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found");
            return;
        } else
            System.out.println("Found contact. Name " + existingContact.getName()
                    + ", phone number: " + existingContact.getPhoneNumber());

    }
}