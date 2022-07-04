package com.company;

import java.util.*;
import java.util.stream.Stream;

class Bus {

    int capacity, width, longitude;
    String routeNumber;

    Bus(int capacity, String routeNumber, int width, int longitude) {
        this.capacity = capacity;
        this.routeNumber = routeNumber;
        this.width = width;
        this.longitude = longitude;
    }
}

class BusStation {
    HashMap<String, Bus> Station;
    int passengerCount = 0, chauffeurCount = 0;
    int total, minimum;

    BusStation() {
        Station = new HashMap<>();

        total = 0;
        minimum = 0;
    }

    void add(Bus b) {
        Station.put(b.routeNumber, b);
        total += b.capacity;
    }

    void add(int capacity, String routeNumber, int width, int longitude) {
        Station.put(routeNumber, new Bus(capacity, routeNumber, width, longitude));
        total += capacity;
    }

    public int distance(int x, int x0, int y, int y0) {
        return Math.abs(Math.abs(x + x0) - Math.abs(y + y0));
    }

    void passengerWave(int count) {
        passengerCount = count;
    }

    public int chauffeur(int capacity, int pC) {
        int min = 0, _pC = pC;
        int cC = 0;

        int bus = capacity;
        while(pC > 0) {
            pC -= bus;

            min++;
        }

        pC = _pC;
        cC += min;

        return cC;
    }

    public Stream<String> coordinateStream(int w, int l) {
        ArrayList<String> result = new ArrayList<>();

        Station.entrySet().stream()
                .filter(x -> Math.abs(x.getValue().width + x.getValue().longitude) < Math.abs(w + l))
                .forEach(x -> result.add(x.getKey()));

        return result.stream();
    }

    public Optional<Bus> getBus(int pW, int units) {
        Optional<Bus> result = Optional.empty();

        Optional<Map.Entry<String, Bus>> tmp = Station.entrySet()
                .stream()
                .filter(x -> x.getValue().capacity * units >= pW)
                .findFirst();

        if (tmp.isPresent())
            result = Optional.ofNullable(tmp.get().getValue());

        return result;
    }
}

class routeNumberComparator implements Comparator<String> {

    public int compare(String a, String b) {
        char a0, b0;
        int _a0, _b0;

        a0 = a.charAt(0);
        b0 = b.charAt(0);

        _a0 = (int)a0;
        _b0 = (int)b0;

        if(_a0 > _b0)
            return 1;
        if(_a0 == _b0)
            return 0;
        return -1;
    }
}

 class distanceComparator implements Comparator<String> {

    public int compare(String _a, String _b) {
        int a = _a.charAt(0);
        int b = _b.charAt(0);

        if(a < b)
            return -1;
        if(a == b)
            return 0;
        return 1;
    }
}