package com.yahyabaassou.java8.examples;

import java.util.Optional;

public class LiveCodingOptional {


    public static void main(String[] args) {
        Country newZealand = new Country("NZ");
        Address address = new Address(newZealand);
        Person person = new Person("Ross", "98700987");
        person.setAddress(address); //comment this line to check the NullPointerException before adding if conditions

        //Without Optional and with NPE
//        System.out.println(person.getAddress().getCountry().getCountryCode());

        //Without Optional and without NPE
//        if (person != null) {
//            Address address1 = person.getAddress();
//            if (address != null) {
//                Country country = address.getCountry();
//                if (country != null) {
//                    System.out.println(country.getCountryCode());
//                }
//            }
//        }

        //With Optional
        Optional.ofNullable(person)
                .flatMap(Person::getAddress)
                .flatMap(Address::getCountry)
                .flatMap(Country::getCountryCode)
                .ifPresent(System.out::println);

    }

    private static class Address {

        private Country country;

        //With Optional
        public Optional<Country> getCountry() {
            return Optional.ofNullable(country);
        }

        //Without Optional
//        public Country getCountry() {
//            return country;
//        }

        public Address(Country country) {
            this.country = country;
        }
    }

    private static class Country {

        private String countryCode;

        public Country(String countryCode) {
            this.countryCode = countryCode;
        }

        //With Optional
        public Optional<String> getCountryCode() {
            return Optional.ofNullable(countryCode);
        }

        //Without Optional
//        public String getCountryCode() {
//            return countryCode;
//        }

    }

    private static class Person {

        private String name;
        private String contactNo;
        private String profession;
        private Address address;

        public Person(String name, String contactNo) {
            this.name = name;
            this.contactNo = contactNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContactNo() {
            return contactNo;
        }

        public void setContactNo(String contactNo) {
            this.contactNo = contactNo;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getProfession(){
            return profession;
        }

        //With Optional
        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }

        //Without Optional
//        public Address getAddress() {
//            return address;
//        }

        public void setAddress(Address address) {
            this.address = address;
        }

    }

}
