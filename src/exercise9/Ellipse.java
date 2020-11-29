package exercise9;

public class Ellipse {
  private Point startPoint;
  private double halba;
  private double halbb;

  public Ellipse (){
    startPoint = new Point (0, 0);
    halba = 1;
    halbb = 1;

  }
  public Ellipse(Ellipse otherEllipse) {
        startPoint = new Point(otherEllipse.startPoint);
        halba = otherEllipse.halba;
        halbb = otherEllipse.halbb;
    }

    public boolean isValid() {
        return halba > 0 && halbb > 0;
    }

    public void initialize() {

      do{
        System.out.println("Start point: ");
        startPoint.initialize();
        System.out.println("Halbachse a: ");
        halba = Utils.INPUT.nextDouble();
        System.out.println("Halbachse b: ");
        halbb = Utils.INPUT.nextDouble();


      } while (!isValid ());
    }

    public double calculatePerimeter (){
      return  Math.PI * Math.abs(3*(halba + halbb) - Math.sqrt((3*halba + halbb)*(halba + 3*halbb)));
    }
    public double calculateArea () {
      return  Math.PI * halba * halbb;
    }
    public String getType(){
      return (halba == halbb) ? "Cycle" : "Elipse";
    }
    public String toString (){
      return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, halba, halbb, getType(), calculatePerimeter(), calculateArea());
    }
    public boolean equals() {
       boolean sameHalba = Utils.equals(halba, otherEllipse.halba);
       boolean sameHalbb = Utils.equals(halbb, otherEllipse.halbb);
       boolean sameHalbaReversed = Utils.equals(halba, otherEllipse.halbb);
       boolean sameHalbbReversed = Utils.equals(halbb, otherEllipse.halba);

      return (sameHalba && sameHalbb) || (sameHalbaReversed && sameHalbbReversed);
    }
}
