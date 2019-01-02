package com.company;


import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }


    public boolean addNewContact(Contacts contacts) {
        if (findContact(contacts.getName()) >= 0) {
            System.out.println("Contact already of file");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }


    private int findContact(Contacts contacts) {
        return this.myContacts.indexOf(contacts);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contacts contacts = this.myContacts.get(i);
            if (contacts.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found on the list");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact already exists. Update was not successful");
            return false;
        }

        myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        System.out.println("Successfully updated contact");
        return true;
    }

    public boolean removeContact(Contacts contacts) {
        int position = findContact(contacts);
        if (findContact(contacts) < 0) {
            System.out.println(contacts.getName() + " not found");
            return false;
        }
        this.myContacts.remove(position);
        System.out.println(contacts.getName() + " was removed");
        return true;
    }

    public String queryContact(Contacts contacts) {
        if (findContact(contacts) >= 0) {
            return contacts.getName();
        }
        return null;
    }

    public Contacts queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void listOfContacts() {
        System.out.println("Contacts list");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ".Name : " + this.myContacts.get(i).getName() +
                    ", phone number : " + this.myContacts.get(i).getPhoneNumber());
        }

    }


}


