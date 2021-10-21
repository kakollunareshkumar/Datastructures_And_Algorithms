package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Generic_code {
List<Integer> pointList;
    public  Optional<Double> getAverage(List<Integer> pointsList) {
        this.pointList =pointsList;
        double average = 0.;
        if(pointList.isEmpty()) {
            return Optional.empty();
        }
        for(Integer point : pointsList) {
            average += point;
        }
        return Optional.of(average /= pointsList.size());
    }
    public static void main(String[] args) {
        Generic_code g = new Generic_code();

        Optional<Double> average = g.getAverage(new ArrayList<Integer>());
        Double v1;
//WAY 1
        if(average.isPresent()) {
            v1 = average.get();
        }

//WAY 2
        v1 = average.orElse(null);

//WAY 3
        v1 = average.orElseGet(()->null);

//WAY 4
      //  v1 = average.orElseThrow();


    }
}
