package fr.fireowls.spaceowls.math;

import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.corp.StaticCorp;
import fr.fireowls.spaceowls.utils.Location;


import java.util.ArrayList;
import java.util.List;

public class CorpSize{

    private double density = 0;
    private final int MAX_DIAMETER = 100;

    public CorpSize(List<Corp> corps){
        density = getHeveaiestCorp(corps).getMass()/getVolume();
    }

    private double getVolume(){
        return (4/3)*Math.PI*Math.pow(MAX_DIAMETER/2,3);
    }

    public Corp getHeveaiestCorp(List<Corp> corps){
        Corp max = corps.get(0);
        for(Corp c:corps){
            if(c.getMass() > max.getMass()){
                max = c;
            }
        }
        return max;
    }

    public double getCorpSize(Corp corp){
        long tmp = (long) ((corp.getMass()/density)*(3/(4*Math.PI)));
        return Math.pow(tmp,(double)1/3);
    }

}
