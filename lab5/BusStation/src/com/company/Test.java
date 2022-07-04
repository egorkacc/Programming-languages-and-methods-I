package com.company;

public class Test {
    public static void main(String[] args) {

        BusStation st = new BusStation();
        int pW = 137;

        st.passengerWave(pW);
        st.add(27, "276", 4, 3);
        st.add(41, "142-f", 5, 5);
        st.add(33, "b-9", 6, 7);
        st.add(41, "142-f", 1, 1);
        st.add(38, "722", 1, 0);
        st.add(33, "b-9", 2, 3);
        st.add(45, "hr-73y", 2, 3);

        System.out.println(st.chauffeur(45, pW) + " hr-73y's" + " route busses are needed to transport " + pW + " people");
        System.out.println("=====================");

        pW = 214;
        st.passengerWave(pW);

        int station_coordinateX = 5, station_coordinateY = 5;

        st.coordinateStream(station_coordinateX, station_coordinateY)
                .sorted(new routeNumberComparator())
                .forEach(System.out :: println);
        System.out.println("=====================");

        int Dist1 = st.distance(1, station_coordinateX,
                                0, station_coordinateY);
        int Dist2 = st.distance(4, station_coordinateX,
                                3, station_coordinateY);

        System.out.println("The closest bus is: ");
        st.coordinateStream(Dist1, Dist2)
                .sorted(new distanceComparator())
                .forEach(System.out :: println);
        System.out.println("=====================");

        System.out.println(st.chauffeur(27, pW) + " 276's" + " route busses are needed to transport " + pW + " people");
        System.out.println(st.chauffeur(33, pW) + " b-9's" + " route busses are needed to transport " + pW + " people");
        System.out.println(st.chauffeur(41, pW) + " 142-f's" + " route busses are needed to transport " + pW + " people");
    }
}