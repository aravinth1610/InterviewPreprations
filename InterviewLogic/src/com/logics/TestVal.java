package com.logics;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TestVal {

	public static void main(String[] args) {
		Set<person> set = new HashSet<>();

		set.add(new person("ram", 1));
		set.add(new person("ram", 1));
		set.add(new person("ram", 1));
		set.add(new person("ram", 1));

		System.out.println(set.toString());
	}

}

class person {

	String name = "";
	int id = 0;

	public person( String name, int id ) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "person [name=" + name + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		person other = (person) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

}