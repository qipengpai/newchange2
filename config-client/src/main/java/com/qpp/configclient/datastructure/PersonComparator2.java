package com.qpp.configclient.datastructure;

import java.util.Comparator;

public class PersonComparator2 implements Comparator<Person> {
    @Override
    public int compare(Person p, Person p2) {
        return p.getMind().compareTo(p2.getMind());
    }
}
