package com.yahyabaassou.java8.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LiveCodingParallelStream {

    static List<Integer> myList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        test1();
//        test2();
    }

    private static void test1() {
        for (int i = 0; i < 5000000; i++) myList.add(i);

        int result = 0;
        long loopStartTime = System.currentTimeMillis();
        for (int i: myList) {
            if (i % 2 == 0)
                result += i;
        }
        long loopEndTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Loop total Time = " + (loopEndTime - loopStartTime));

        long streamStartTime = System.currentTimeMillis();
        System.out.println(myList.stream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
        long streamEndTime = System.currentTimeMillis();
        System.out.println("Stream total Time = " + (streamEndTime - streamStartTime));

        long parallelStreamStartTime = System.currentTimeMillis();
        System.out.println(myList.parallelStream().filter(value -> value % 2 == 0).mapToInt(Integer::intValue).sum());
        long parallelStreamEndTime = System.currentTimeMillis();
        System.out.println("Parallel Stream total Time = " + (parallelStreamEndTime - parallelStreamStartTime));
    }

    private static void test2() throws InterruptedException {
        List<Employee> employees = new ArrayList< >();
        for (int i = 1; i < 10000000; i++) employees.add(new Employee(i, "name_" + i));

        Stream<String> employeeNameStreams = employees.stream()
                .filter(employee -> employee.id % 2 == 0)
                .map(employee -> {
                    System.out.println("In Map - " + employee.getName());
                    return employee.getName();
                });

        System.out.println("Nothing has been executed yet");
        Thread.sleep(2000);
        System.out.println("2 sec");

        long streamStartTime = System.currentTimeMillis();

        employeeNameStreams.limit(100).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - streamStartTime);
    }

    private static class Employee {
        int id;
        String name;
        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }


}
