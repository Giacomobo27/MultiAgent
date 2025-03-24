package example;

import astra.core.Module;
import astra.formula.Predicate;
import astra.term.Primitive;
import astra.term.Term;

public class Light extends Module {
    private boolean on = false;
  
    @ACTION
    public boolean set(String state) {
      this.on = (state=="on"); return true;
    }
  
    private Predicate belief;
    private boolean lastState = true;
  
    @SENSOR
    public void sense() {
      if (lastState == on) return;
      if (belief != null) agent.beliefs().dropBelief(belief);
      agent.beliefs().addBelief(
          belief = new Predicate("light",
            new Term[] {Primitive.newPrimitive(on?"on":"off")})
      );
      lastState = on;
    }
  }
  