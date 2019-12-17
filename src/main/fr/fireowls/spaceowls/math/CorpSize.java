package fr.fireowls.spaceowls.math;

import fr.fireowls.spaceowls.system.corp.Corp;

import java.util.List;

public class CorpSize {

    private double density = 0;
    private final int MAX_DIAMETER = 100;

    public CorpSize(List<Corp> corps){
        density = getHeveaiestCorp(corps).getMass()/getVolume();
    }

    private double getVolume(){
        return (4/3)*Math.PI*Math.pow(MAX_DIAMETER/2,3);
    }

    private Corp getHeveaiestCorp(List<Corp> corps){
        Corp max = corps.get(0);
        for(Corp c:corps){
            if(c.getMass() > max.getMass()){
                max = c;
            }
        }
        return max;
    }

    public double getCorpSize(Corp corp){
        double tmp = (corp.getMass()/density)*(3/(4*Math.PI));
        return Math.pow(tmp,(1/3));
    }

}
