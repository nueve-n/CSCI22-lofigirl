/**
    The Girl class represents the lofi girl herself. 
    It has the complex shapes for hair, clothing, and accessories, and includes logic for animations such as breathing and blinking.

    @author Fiona Nadine Macalalag (253550)
    @author John Carlo Ranario (254815)
    @version February 26, 2026

    We have not discussed the Java language code in my program
    with anyone other than our instructor or the teaching assistants
    assigned to this course.

    We have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.
    
    If any Java language code or documentation used in our program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.
*/

import java.awt.*;
import java.awt.geom.*;

public class Girl implements DrawingObject {
    static double baseWidth = 625.4;
    static double baseHeight = 1291.3;
    static double baseX = 67.9;
    static double baseY = 35;

    double x, y, w, h;
    Color skinC, socks2C, socks1C, pants2C, pants1C, sweaterC, hairC, headphonesOuterC, headphonesInnerC;
    
    double breathProgress = 0;
    double breathSpeed = 0.09;
    
    double eyeX = 401.8;
    double eyeY = 238.9;
    double blinkProgress = 0;
    boolean isBlinking = false;
    double blinkSpeed = 0.30;

    /**
        Constructs the Girl object with specific positions and a color palette.
        @param x The x-coordinate for the character.
        @param y The y-coordinate for the character.
        @param w The width of the character.
        @param h The height of the character.
        @param skinC The color for skin tones.
        @param socks2C Secondary color for socks.
        @param socks1C Primary color for socks.
        @param pants2C Secondary color for pants.
        @param pants1C Primary color for pants.
        @param sweaterC The color for the sweater.
        @param hairC The color for hair, eyebrows, and eyes.
        @param headphonesOuterC The color for the headphone frame.
        @param headphonesInnerC The color for the headphone earcups.
    */
    public Girl(
        double x, double y, double w, double h, 
        Color skinC, 
        Color socks2C, Color socks1C, 
        Color pants2C, Color pants1C, 
        Color sweaterC, 
        Color hairC, 
        Color headphonesOuterC, Color headphonesInnerC) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.skinC = skinC;
        this.socks2C = socks2C;
        this.socks1C = socks1C;
        this.pants2C = pants2C;
        this.pants1C = pants1C;
        this.sweaterC = sweaterC;
        this.hairC = hairC;
        this.headphonesOuterC = headphonesOuterC;
        this.headphonesInnerC = headphonesInnerC;
    }
    
    /**
        Renders the character using AffineTransforms for scaling and breathing effects.
        The method draws layers including the face, clothing, and eyes.
        @param g2d The Graphics2D object used for rendering.
    */
    @Override 
    public void draw(Graphics2D g2d) {
        Path2D.Double hair = new Path2D.Double();
        hair.moveTo(369.5, 198.1);
        hair.quadTo(369.0, 247.6, 302.5, 235.0);
        hair.quadTo(245.4, 330.2, 219.5, 326.3);
        hair.quadTo(147.6, 280.6, 126.2, 182.6);
        hair.lineTo( 124.3, 213.6);
        hair.lineTo( 91.3, 184.5);
        hair.lineTo( 93.2, 202.0);
        hair.quadTo(3.9, 142.8, 101.0, 71.9);
        hair.quadTo(172.9, -41.8, 240.8, 35.0);
        hair.quadTo(383.6, 2.9, 472.0, 149.5);
        hair.quadTo(501.1, 222.4, 429.2, 213.6);
        hair.closePath();

        Path2D.Double face = new Path2D.Double();
        face.moveTo(297.7, 378.7);
        face.quadTo(309.8, 357.4, 321.9, 336.0);
        face.quadTo(376.5, 365.1, 385.3, 338.0);
        face.quadTo(395.2, 322.8, 403.0, 309.0);
        face.quadTo(403.6, 304.9, 402.0, 297.2);
        face.quadTo(413.7, 291.3, 425.3, 285.5);
        face.quadTo(411.7, 270.0, 411.3, 248.1);
        face.quadTo(423.9, 235.2, 429.2, 209.8);
        face.quadTo(295.2, -17.5, 219.5, 318.5);
        face.closePath();

        Path2D.Double headphones = new Path2D.Double();
        headphones.moveTo(250.9, 152.4);
        headphones.quadTo(262.2, 80.0, 309.0, 25.4);
        headphones.quadTo(338.3, 21.3, 351.1, 37.5);
        headphones.quadTo(298.4, 95.9, 291.4, 163.2);
        Ellipse2D.Double headphones1 = new Ellipse2D.Double(190, 160, 140, 140);
        Ellipse2D.Double headphones2 = new Ellipse2D.Double(215, 185, 90, 90);

        Path2D.Double sweater = new Path2D.Double();
        sweater.moveTo(219.5, 318.5);
        sweater.quadTo(-92.7, 558.4, 67.9, 962.6);
        sweater.quadTo(218.2, 931.4, 350.7, 801.8);
        sweater.quadTo(294.8, 767.2, 310.7, 378.7);
        sweater.closePath();

        Path2D.Double pants1 = new Path2D.Double();
        pants1.moveTo(79.9, 944.8);
        pants1.quadTo(55.1, 1043.1, 539.5, 980.5);
        pants1.quadTo(494.2, 1066.5, 493.6, 1241.8);
        pants1.quadTo(527.1, 1247.4, 560.6, 1253.0);
        pants1.quadTo(608.6, 1122.3, 656.7, 991.7);
        pants1.quadTo(735.9, 840.9, 297.1, 833.1);
        pants1.closePath();

        Path2D.Double pants2 = new Path2D.Double();
        pants2.moveTo(323.0, 804.1);
        pants2.quadTo(759.4, 818.6, 693.3, 955.9);
        pants2.quadTo(638.1, 1092.2, 600.8, 1224.0);
        pants2.quadTo(574.0, 1221.7, 547.2, 1219.5);
        pants2.quadTo(780.6, 773.9, 214.4, 882.2);
        pants2.closePath();

        Path2D.Double socks1 = new Path2D.Double();
        socks1.moveTo(505.3, 1222.9);
        socks1.quadTo(497.7, 1271.6, 490.1, 1320.4);
        socks1.quadTo(567.0, 1323.3, 643.9, 1326.3);
        socks1.quadTo(685.7, 1317.3, 614.4, 1287.9);
        socks1.quadTo(584.9, 1276.1, 555.3, 1264.2);
        socks1.quadTo(555.3, 1245.0, 555.3, 1225.8);
        socks1.closePath();

        Path2D.Double socks2 = new Path2D.Double();
        socks2.moveTo(597.3, 1207.2);
        socks2.quadTo(594.6, 1225.2, 592.0, 1243.2);
        socks2.quadTo(631.2, 1258.6, 670.4, 1274.0);
        socks2.quadTo(715.3, 1310.0, 662.7, 1310.0);
        socks2.quadTo(599.8, 1301.0, 536.8, 1292.0);
        socks2.quadTo(542.0, 1241.9, 544.5, 1199.5);
        socks2.closePath();

        Path2D.Double eyebrow = new Path2D.Double();
        eyebrow.moveTo(370.3, 216.3);
        eyebrow.quadTo(402.5, 203.2, 415.2, 224.7);
        eyebrow.quadTo(389.5, 215.2, 371.3, 222.1);
        eyebrow.closePath();

        double currentEyeHeight = 20.0 * (1.0 - (blinkProgress * 0.95)); 
        double eyeOffset = 10.0 * blinkProgress;

        Ellipse2D.Double eye = new Ellipse2D.Double(
            384.6, 234.8 + eyeOffset, 15.0, currentEyeHeight
        );

        Line2D.Double eyelash = new Line2D.Double(
            374.5, 236.3 + (10 * blinkProgress), 401.8, 238.9 + (10 * blinkProgress)
        );

        Path2D.Double hairtie = new Path2D.Double();
        hairtie.moveTo(232.1, 24.4);
        hairtie.quadTo(197.7, 41.1, 170.9, 99.9);
        hairtie.quadTo(207.6, 47.0, 243.5, 36.9);
        hairtie.closePath();
        
        AffineTransform at = new AffineTransform();

        at.translate(x, y);
        at.scale(w/baseWidth, h/baseHeight);
        at.translate(-baseX, -baseY);

        g2d.setColor(skinC);
        g2d.fill(at.createTransformedShape(face));

        g2d.setColor(socks2C);
        g2d.fill(at.createTransformedShape(socks2));

        g2d.setColor(socks1C);
        g2d.fill(at.createTransformedShape(socks1));

        g2d.setColor(pants2C);
        g2d.fill(at.createTransformedShape(pants2));

        g2d.setColor(pants1C);
        g2d.fill(at.createTransformedShape(pants1));
        
        double multiplier = (Math.sin(breathProgress) + 1) / 2;
        double breatheY = 1 + 0.012 * multiplier;
        double breatheX = 1 + 0.02 * multiplier;
        double breatheShift = -18 * multiplier;

        AffineTransform sweaterAT = new AffineTransform(at);

        sweaterAT.translate(0, 600);

        sweaterAT.scale(breatheX, breatheY);
        sweaterAT.translate(0, breatheShift);

        sweaterAT.translate(0, -600);

        g2d.setColor(sweaterC);
        g2d.fill(sweaterAT.createTransformedShape(sweater));

        g2d.setColor(hairC);
        g2d.fill(at.createTransformedShape(hair));

        g2d.setColor(headphonesOuterC);
        g2d.fill(at.createTransformedShape(headphones));

        g2d.setColor(headphonesOuterC);
        g2d.fill(at.createTransformedShape(headphones1));
        
        g2d.setColor(headphonesInnerC);
        g2d.fill(at.createTransformedShape(headphones2));

        g2d.setColor(hairC);
        g2d.fill(at.createTransformedShape(eyebrow));

        g2d.setColor(hairC);
        g2d.setStroke(new BasicStroke((float) (h * 0.0035)));
        g2d.draw(at.createTransformedShape(eyelash));

        g2d.setColor(hairC);
        g2d.fill(at.createTransformedShape(eye));

        g2d.setColor(sweaterC);
        g2d.fill(at.createTransformedShape(hairtie));
    }

    /**
        Updates the breathing animation progress using a sine wave function.
        This method is called within SceneFrame
    */
    public void breathe() {
        breathProgress += breathSpeed;
    }

    /**
        Manages the blinking animation state.
        This method is called within SceneFrame
    */
    public void blink() {
        if (isBlinking) {
            
            blinkProgress += blinkSpeed;
            
            if (blinkProgress >= 1.0) {
                blinkProgress = 1.0;
                isBlinking = false;
            }
        } 

        else if (blinkProgress > 0) {
            blinkProgress -= blinkSpeed;
            if (blinkProgress < 0) blinkProgress = 0;
        }
    }

    /**
        Initiates the blinking sequence.
    */
    public void startBlink() {
        isBlinking = true;
    }
}

/**
REFERENCES:
    1. CodingTechRoom. "How to Scale a Shape from Its Center Using AffineTransform in Java." https://codingtechroom.com/question/-affine-transform-scale-center-java
    2. CodingTechRoom. "How to Translate and Scale Graphics Using Java's Graphics2D?." https://codingtechroom.com/question/java-graphics2d-translate-scale
    3. GeeksforGeeks. "Java Math sin() method with Examples." https://www.geeksforgeeks.org/java/java-math-sin-method-examples/
    4. Coordinate tracing tool for shapes created by Marxus Magisa.
*/
