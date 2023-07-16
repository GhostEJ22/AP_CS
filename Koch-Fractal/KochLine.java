// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com
import processing.core.*;
import java.util.ArrayList;
// Koch Curve
// A class to describe one line segment in the fractal
// Includes methods to calculate midPVectors along the line according to the Koch algorithm

class KochLine {

  // Two PVectors,
  // a is the "left" PVector and 
  // b is the "right PVector
  private PApplet sketch;
  private float rotateAngle;
  PVector a;
  PVector b;

  KochLine(PApplet sketch, PVector start, PVector end) {
    this.sketch = sketch;
    a = start.copy();
    b = end.copy();
    rotateAngle = (sketch.mouseX / (float) sketch.width) * 90f;
  }

  void display() {
    sketch.stroke(162,228,184);
    sketch.line(a.x, a.y, b.x, b.y);
  }

  PVector start() {
    return a.copy();
  }

  PVector end() {
    return b.copy();
  }

  // This is easy, just 1/3 of the way
  PVector kochleft() {
    PVector v = PVector.sub(b, a);
    v.div(3);
    v.add(a);
    return v;
  }    

  // More complicated, have to use a little trig to figure out where this PVector is!
  PVector kochmiddle() {
    PVector v = PVector.sub(b, a);
    v.div(3);
    
    PVector p = a.copy();
    p.add(v);
    

    v.rotate(-PApplet.radians(rotateAngle));
    p.add(v);
    
    return p;
  }    

  // Easy, just 2/3 of the way
  PVector kochright() {
    PVector v = PVector.sub(a, b);
    v.div(3);
    v.add(b);
    return v;
  }
}