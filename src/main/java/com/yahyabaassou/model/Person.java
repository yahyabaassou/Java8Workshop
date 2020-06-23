package com.yahyabaassou.model;

import java.util.Calendar;
import java.util.Date;

public class Person {

	private final String firstName;
	private final String lastName;
	private final Date birthDate;
	private final String birthCity;
	private final String birthCountry;
	private final Date deathDate;
	private final String deathCity;
	private final String deathCountry;

	private final int birthYear;
	private final int deathYear;

	public Person(String lastName, String firstName, Date birthDate, String birthCity, String birthCountry,
                  Date deathDate, String deathCity, String deathCountry) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.birthCity = birthCity;
		this.birthCountry = birthCountry;
		this.deathDate = deathDate;
		this.deathCity = deathCity;
		this.deathCountry = deathCountry;

		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);
		this.birthYear = cal.get(Calendar.YEAR);
		cal.setTime(deathDate);
		this.deathYear = cal.get(Calendar.YEAR);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public String getDeathCity() {
		return deathCity;
	}

	public String getDeathCountry() {
		return deathCountry;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public int getDeathYear() {
		return deathYear;
	}

	@Override
	public String toString() {
		return String.format("%s %s", lastName, firstName);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return birthDate.equals(person.birthDate) && firstName.equals(person.firstName)
				&& lastName.equals(person.lastName);

	}

	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + birthDate.hashCode();
		return result;
	}

}
