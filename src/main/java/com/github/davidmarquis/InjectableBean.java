package com.github.davidmarquis;


public class InjectableBean {

    public boolean isEmailAddressUnique(String email) {
        System.out.println(String.format("Would check if [%s] address is unique...", email));
        return false;
    }
}
