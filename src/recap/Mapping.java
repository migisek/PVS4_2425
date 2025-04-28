package recap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Mapping {

    static class Movie{
        String name;
        int year;
        String genre;
        double rating;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public Movie(String name, int year, String genre, double rating) {
            this.name = name;
            this.year = year;
            this.genre = genre;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name + " " + year;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movies = Files.lines(Paths.get("movieList.txt"))
//                .skip(1)
                .map(line -> line.split(";"))
                .map(split -> new Movie(
                        split[0],
                        Integer.parseInt(split[1]),
                        split[2],
                        Double.parseDouble(split[3])
                )).toList();

        System.out.println(movies);

        movies.forEach(m -> System.out.println(m.getName() + " " + "(" + m.getYear() + ")"));
        //zvedni vsem filmum rating o 1
//        movies.forEach(m -> m.setRating(m.getRating()+1.0));

//        Comparator<Movie> BY_RATING = new Comparator<Movie>() {
//            @Override
//            public int compare(Movie o1, Movie o2) {
//                return Double.compare(o1.getRating(), o2.getRating());
//            }
//        };
//        movies.sort(BY_RATING);
//        System.out.println(movies);


        movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(5)
                .forEach(m -> System.out.println(m.getName() + " [" + m.getRating() + "/10]"));

        movies.stream()
                .filter(movie -> movie.getYear() < 2000)
                .sorted(Comparator.comparingInt(Movie::getYear).reversed())
                .limit(10)
                .forEach(System.out::println);


        long newer = movies.stream()
                .filter(movie -> movie.getYear() > 2000)
                .count();
        System.out.println(newer);

        double avgRating = movies.stream()
                .filter(m -> m.getGenre().equals("Horror"))
                .mapToDouble(Movie::getRating)
                .average()
                .orElse(0);
        System.out.println(avgRating);

//        movies.stream().mapToDouble(Movie::getRating).summaryStatistics();

        HashMap<String, List<Movie>> genreMap = new HashMap<>();
        for (Movie movie : movies){
            if (genreMap.containsKey(movie.getGenre())){
                genreMap.get(movie.getGenre()).add(movie);
            } else {
                ArrayList<Movie> newGenre = new ArrayList<>();
                newGenre.add(movie);
                genreMap.put(movie.getGenre(), newGenre);
            }
        }

        for (String genre : genreMap.keySet()){
            System.out.println(genre);
            for (Movie m : genreMap.get(genre)){
                System.out.println("\t" + m.getName());
            }
        }


        Map<String, List<Movie>> genreMapToo = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));


    }
}
